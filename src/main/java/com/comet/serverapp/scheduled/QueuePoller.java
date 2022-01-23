package com.comet.serverapp.scheduled;

import com.comet.serverapp.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class QueuePoller {

    @Autowired
    private UrlService urlService;

    @Scheduled(fixedRate = 500, initialDelay = 11000)
    public void reportCurrentTime() {
        String url = urlService.popFirstUrlInQueue();
    }

}
