package com.comet.serverapp.tests;

import com.amazonaws.services.s3.event.S3EventNotification;
import com.comet.serverapp.Utils;
import com.comet.serverapp.service.UrlService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Stream;

@SpringBootTest
@ComponentScan
class UrlServiceTest extends Utils {

    @Autowired
    UrlService urlService;

    @ParameterizedTest
    @MethodSource("provideMessageAndValidUrl")
    void testMessageUrlExtraction(String filePath, String validUrl) {
        String message = readFileToString(MESSAGE_PATH + filePath);
        S3EventNotification event = S3EventNotification.parseJson(message);
        String url = urlService.extractUrlFromS3Event(event);
        Assertions.assertEquals(url,validUrl);
    }

    private static Stream<Arguments> provideMessageAndValidUrl() {
        return Stream.of(
                Arguments.of("ValidMessage1.json", "https://guns1g23.s3.eu-central-1.amazonaws.com/me.jpg"),
                Arguments.of("ValidMessage2.json", "https://guns1g23.s3.eu-central-1.amazonaws.com/2022-01-23-12-56-53.png"),
                Arguments.of("ValidMessage3.json", "https://guns1g23.s3.eu-central-1.amazonaws.com/autobiography.jpeg")
                );
    }
}
