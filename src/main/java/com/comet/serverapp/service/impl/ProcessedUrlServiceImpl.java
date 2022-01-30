package com.comet.serverapp.service.impl;

import com.comet.serverapp.entity.ProcessedUrl;
import com.comet.serverapp.repository.ProcessedUrlRepository;
import com.comet.serverapp.service.ProcessedUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProcessedUrlServiceImpl implements ProcessedUrlService {

    @Autowired
    private ProcessedUrlRepository processedUrlRepository;

    @Override
    public ProcessedUrl saveProcessedUrl(UUID key, String jsonObject) {
        ProcessedUrl processedUrl = new ProcessedUrl(key, jsonObject);

        return processedUrlRepository.save(processedUrl);
    }

    @Override
    public String getProcessedUrlResult(UUID key) {
        ProcessedUrl processedUrl = processedUrlRepository.getById(key);
        if(processedUrl == null){
            return null;
        }
        return processedUrl.getJsonResult();
    }
}
