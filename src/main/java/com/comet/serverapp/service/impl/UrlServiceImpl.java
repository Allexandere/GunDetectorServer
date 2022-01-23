package com.comet.serverapp.service.impl;

import com.amazonaws.services.s3.event.S3EventNotification;
import com.amazonaws.services.s3.event.S3EventNotification.S3EventNotificationRecord;
import com.comet.serverapp.entity.NewUrl;
import com.comet.serverapp.repository.NewUrlRepository;
import com.comet.serverapp.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UrlServiceImpl implements UrlService {

    private final static String URL_PATTERN = "https://%s.s3.%s.amazonaws.com/%s";

    @Autowired
    private NewUrlRepository newUrlRepository;

    @Override
    public String extractUrlFromS3Event(S3EventNotification event) {
        S3EventNotificationRecord record = event.getRecords().get(0);
        String bucketName = record.getS3().getBucket().getName();
        String region = record.getAwsRegion();
        String fileName = record.getS3().getObject().getKey();
        return String.format(URL_PATTERN, bucketName, region, fileName);
    }

    @Override
    public void addObjectUrlToQueue(S3EventNotification event) {
        String url = extractUrlFromS3Event(event);
        NewUrl newUrlEntry = new NewUrl(url);
        newUrlRepository.save(newUrlEntry);
    }

    @Override
    @Transactional
    public String popFirstUrlInQueue() {
        NewUrl firstInQueueUrl = newUrlRepository.findFirstByOrderByCreationDate();
        if (firstInQueueUrl == null) {
            return null;
        }
        newUrlRepository.deleteById(firstInQueueUrl.getId());
        return firstInQueueUrl.getUrl();
    }
}
