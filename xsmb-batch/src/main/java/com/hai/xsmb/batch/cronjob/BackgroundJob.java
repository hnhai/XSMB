package com.hai.xsmb.batch.cronjob;

import com.hai.xsmb.batch.service.ResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableScheduling
public class BackgroundJob {

    private static final Logger LOG = LoggerFactory.getLogger(BackgroundJob.class);

    @Autowired
    private ResultService resultService;

    //Fire at 6:30pm Everyday
    @Scheduled(cron = "0 30 18 * * ?")
    public void cronXsmb(){
        Boolean success = Boolean.FALSE;
        try {
            success = resultService.craw();
            LOG.info("/nCraw at: " + new Date());
        }catch (Exception e){
            LOG.error(e.getMessage(), e);
        }
        if(!success){
            LOG.error("/nFailed Craw");
            // Todo refacter
        }else{
            LOG.info("/nCraw success");
        }
    }
}
