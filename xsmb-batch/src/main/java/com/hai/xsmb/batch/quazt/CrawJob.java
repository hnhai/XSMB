package com.hai.xsmb.batch.quazt;

import com.hai.xsmb.batch.service.ResultService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class CrawJob extends QuartzJobBean {
    private static final Logger LOG = LoggerFactory.getLogger(CrawJob.class);
    public final static String JOB_NAME = "crawJob";
    public final static String GROUP = "crawGroup";
    public final static String TRIGGER_NAME = "crawTrigger";
    public final static String Expression = "0 58 10 * * ?";

    @Autowired
    private ResultService resultService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Boolean success = Boolean.FALSE;
        try {
            success = resultService.craw();
        } catch (Exception e) {
            LOG.error("Error when craw: " + e.getMessage(), e);
        }
        if (!success) {
            // Todo refacter
        } else {
            LOG.info("Craw Success");
        }
    }
}
