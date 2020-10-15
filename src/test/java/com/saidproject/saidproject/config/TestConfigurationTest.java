package com.saidproject.saidproject.config;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

public class TestConfigurationTest {

    private Logger logger = LoggerFactory.getLogger(TestConfiguration.class);

    @Test
    public void testSimpleConfiguration(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TestConfiguration.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            logger.info("Bean name: " + beanDefinitionName);
        }
        Resource resource = ctx.getResource("application.properties");

    }
}