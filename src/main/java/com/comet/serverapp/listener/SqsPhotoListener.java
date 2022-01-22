package com.comet.serverapp.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SqsPhotoListener {
    @SqsListener("gun-photo-queue")
    public void receiveMessage(String stringJson) {
        log.info("Message Received using SQS Listner " + stringJson);
    }
}
