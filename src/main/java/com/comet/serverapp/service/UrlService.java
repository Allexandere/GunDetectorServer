package com.comet.serverapp.service;

import com.amazonaws.services.s3.event.S3EventNotification;

public interface UrlService {

    String extractUrlFromS3Event(S3EventNotification event);

    void addObjectUrlToQueue(S3EventNotification event);

    String popFirstUrlInQueue();

}
