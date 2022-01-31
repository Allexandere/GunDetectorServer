package com.comet.serverapp.scheduled;

import com.comet.serverapp.adapters.ModelAdapter;
import com.comet.serverapp.dto.PhotoUrlDto;
import com.comet.serverapp.entity.NewUrl;
import com.comet.serverapp.service.ProcessedUrlService;
import com.comet.serverapp.service.UrlService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@EnableScheduling
@Slf4j
public class QueuePoller {

    @Autowired
    private ModelAdapter modelAdapter;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UrlService urlService;
    @Autowired
    private ProcessedUrlService processedUrlService;

    @Scheduled(fixedRate = 500, initialDelay = 11000)
    public void reportCurrentTime()  {
        NewUrl photoUrl = urlService.popFirstUrlInQueue();
        if(photoUrl == null){
            return;
        }
        String jsonResult = modelAdapter.processPhotoByUrl(new PhotoUrlDto(photoUrl.getUrl()));
        jsonResult = jsonResult.replace("\"", "").replace("'", "\"");
        UUID key = UUID.fromString(photoUrl.getKey().replace(".jpg", ""));
        log.info(String.format("QueuePoller pop: key: %s jsonResult: %s", key, jsonResult));
        processedUrlService.saveProcessedUrl(key, jsonResult);
    }

}
