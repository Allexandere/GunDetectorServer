package com.comet.serverapp;

import com.comet.serverapp.adapters.ModelAdapter;
import com.comet.serverapp.dto.PhotoUrlDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ComponentScan
class ModelAdapterTest {

    @Autowired
    private ModelAdapter modelAdapter;
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    @Disabled
    void modelAdapterFlowTest() {
        String response = modelAdapter.processPhotoByUrl(new PhotoUrlDto("https://guns1g23.s3.eu-central-1.amazonaws.com/b2e2a8a0-d76e-48fb-ba2b-d0115141a4c0.jpg"));
        response = response.replace("\"", "");
        response = response.replace("'", "\"");
        Assertions.assertNotNull(response);
        System.out.println(response);
    }
}
