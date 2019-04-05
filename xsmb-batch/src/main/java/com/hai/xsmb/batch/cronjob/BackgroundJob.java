package com.hai.xsmb.batch.cronjob;

import com.hai.xsmb.batch.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class BackgroundJob {

    @Autowired
    private ResultService resultService;

    //Fire at 6:30pm Everyday
    @Scheduled(cron = "0 30 18 * * ?")
    public void cronXsmb(){
        Boolean success = Boolean.FALSE;
        try {
            success = resultService.craw();
        }catch (Exception e){

            //Todo refacter
        }
        if(!success){
            // Todo refacter
        }
    }
}
