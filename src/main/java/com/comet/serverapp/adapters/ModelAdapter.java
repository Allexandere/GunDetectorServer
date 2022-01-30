package com.comet.serverapp.adapters;

import com.comet.serverapp.dto.PhotoUrlDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "model-adapter", url = "${model.url}")
public interface ModelAdapter {

    @RequestMapping(method = RequestMethod.POST, value = "${model.detect_endpoint}")
    String processPhotoByUrl(@RequestBody PhotoUrlDto photoUrlDto);

}
