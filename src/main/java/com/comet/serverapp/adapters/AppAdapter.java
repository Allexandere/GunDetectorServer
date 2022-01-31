package com.comet.serverapp.adapters;

import com.comet.serverapp.service.ProcessedUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/result")
public class AppAdapter {

    @Autowired
    private ProcessedUrlService processedUrlService;

    @GetMapping("/{key}")
    public String getProcessedPhotoResult(@PathVariable(name = "key") UUID key){
        return processedUrlService.getProcessedUrlResult(key);
    }
}
