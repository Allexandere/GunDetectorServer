package com.comet.serverapp.listener;

import com.amazonaws.services.s3.event.S3EventNotification;
import com.comet.serverapp.service.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SqsPhotoListener {

    @Autowired
    private UrlService urlService;

    @SqsListener("gun-photo-queue")
    public void receiveMessage(String message) {
        log.info("SQS message: " + message);
        S3EventNotification event = S3EventNotification.parseJson(message);
        urlService.addObjectUrlToQueue(event);
    }
}
