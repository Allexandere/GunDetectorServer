package com.comet.serverapp;

import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = PostgreTestConfig.class)
@Import(PostgreTestConfig.class)
public class BaseTest {
}
