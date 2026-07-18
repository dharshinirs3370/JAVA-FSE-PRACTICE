package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringlearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringlearnApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SpringlearnApplication.class,args);

        LOGGER.info("Inside main");

        displayCountry();
    }

    private static void displayCountry() {

    LOGGER.info("Inside displayCountry()");

    ApplicationContext context =
            new ClassPathXmlApplicationContext("country.xml");

    Country country = context.getBean("country", Country.class);

    LOGGER.info("Country : {}", country);
}
}