package com.hai.xsmb.batch.service.impl;

import com.hai.xsmb.batch.constant.XoSoDotCom;
import com.hai.xsmb.batch.quazt.CrawJob;
import com.hai.xsmb.batch.service.ResultService;
import com.hai.xsmb.core.entity.ResultEntity;
import com.hai.xsmb.core.repository.ResultRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.quartz.Scheduler;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class ResutlServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    private final String BASE_URL = "https://xoso.com.vn/xo-so-mien-bac/xsmb-p1.html";

    @Override
    public Boolean craw() {
        try {
            System.setProperty("webdriver.chrome.driver","/home/hai-hn/deploy/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get(BASE_URL);
            Integer first = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.First)).getText());
            Integer second = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Second)).getText());
            Integer third1 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Third1)).getText());
            Integer third2 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Third2)).getText());
            Integer fourth1 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Fourth1)).getText());
            Integer fourth2 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Fourth2)).getText());
            Integer fourth3 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Fourth3)).getText());
            Integer fourth4 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Fourth4)).getText());
            Integer fourth5 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Fourth5)).getText());
            Integer fourth6 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Fourth6)).getText());
            Integer fifth1 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Fifth1)).getText());
            Integer fifth2 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Fifth2)).getText());
            Integer fifth3 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Fifth3)).getText());
            Integer fifth4 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Fifth4)).getText());
            Integer sixth1 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Sixth1)).getText());
            Integer sixth2 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Sixth2)).getText());
            Integer sixth3 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Sixth3)).getText());
            Integer sixth4 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Sixth4)).getText());
            Integer sixth5 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Sixth5)).getText());
            Integer sixth6 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Sixth6)).getText());
            Integer seventh1 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Seventh1)).getText());
            Integer seventh2 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Seventh2)).getText());
            Integer seventh3 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Seventh3)).getText());
            Integer eighth1 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Eighth1)).getText());
            Integer eighth2 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Eighth2)).getText());
            Integer eighth3 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Eighth3)).getText());
            Integer eighth4 = Integer.parseInt(driver.findElement(By.xpath(XoSoDotCom.Eighth4)).getText());
            ResultEntity result = new ResultEntity(first, second, third1, third2, fourth1, fourth2, fourth3, fourth4, fourth5, fourth6, fifth1, fifth2, fifth3, fifth4, sixth1, sixth2, sixth3, sixth4, sixth5, sixth6, seventh1, seventh2, seventh3, eighth1, eighth2, eighth3, eighth4);
            driver.close();
            Date toDay = new Date();
            result.setDate(toDay);
            resultRepository.save(result);
            changeCronExprestion();
        }catch (Exception e){
            return Boolean.FALSE;
            // Todo Refacter
        }
        return Boolean.TRUE;
    }

    @Transactional(rollbackOn = Exception.class)
    public void changeCronExprestion(){
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        try {
                            resultRepository.deleteAll();
                            Scheduler scheduler = schedulerFactoryBean.getScheduler();
                            TriggerKey triggerKey = TriggerKey.triggerKey(CrawJob.TRIGGER_NAME,
                                    CrawJob.GROUP);
                            if(scheduler.checkExists(triggerKey)){
                                CronTriggerImpl cronTrigger = (CronTriggerImpl) scheduler.getTrigger(triggerKey);
                                cronTrigger.setCronExpression("0 01 11 * * ?");
                                scheduler.rescheduleJob(triggerKey, cronTrigger);
                            }
                        }catch (Exception e){

                        }
                    }
                },
                10000
        );

    }
}
