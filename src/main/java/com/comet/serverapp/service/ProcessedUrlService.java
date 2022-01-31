package com.comet.serverapp.service;

import com.comet.serverapp.entity.ProcessedUrl;

import java.util.UUID;

public interface ProcessedUrlService {

    ProcessedUrl saveProcessedUrl(UUID key, String jsonResult);

    String getProcessedUrlResult(UUID key);
}
