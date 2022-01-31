package com.comet.serverapp.service;

import com.amazonaws.services.s3.event.S3EventNotification;
import com.comet.serverapp.entity.NewUrl;

public interface UrlService {

    String extractUrlFromS3Event(S3EventNotification event);

    NewUrl addObjectUrlToQueue(S3EventNotification event);

    NewUrl popFirstUrlInQueue();

    String extractKeyFromS3Event(S3EventNotification event);

}
