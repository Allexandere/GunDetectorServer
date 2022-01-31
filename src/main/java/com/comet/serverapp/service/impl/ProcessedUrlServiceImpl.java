package com.comet.serverapp.service.impl;

import com.comet.serverapp.entity.ProcessedUrl;
import com.comet.serverapp.repository.ProcessedUrlRepository;
import com.comet.serverapp.service.ProcessedUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
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
        Optional<ProcessedUrl> processedUrl = processedUrlRepository.findById(key);
        if(processedUrl.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Model result not found"
            );
        }
        return processedUrl.get().getJsonResult();
    }
}
