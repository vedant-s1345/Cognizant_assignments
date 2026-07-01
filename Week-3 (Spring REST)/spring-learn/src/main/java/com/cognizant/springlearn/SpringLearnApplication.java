package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START - main()");
        SpringApplication.run(SpringLearnApplication.class, args);
        displayDate();
        displayCountry();
        displayCountries();
        LOGGER.info("END - main()");
    }

    public static void displayDate() {
        LOGGER.info("START - displayDate()");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed date: {}", date);
        } catch (ParseException e) {
            LOGGER.error("Failed to parse date", e);
        }
        LOGGER.info("END - displayDate()");
    }
    
    public static void displayCountry() {
        LOGGER.info("START - displayCountry()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());
        LOGGER.debug("Same instance? {}", country == anotherCountry);
        LOGGER.info("END - displayCountry()");
    }
    @SuppressWarnings("unchecked")
    public static void displayCountries() {
        LOGGER.info("START - displayCountries()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        java.util.List<Country> countryList = (java.util.List<Country>) context.getBean("countryList");
        LOGGER.debug("Country list : {}", countryList);
        LOGGER.info("END - displayCountries()");
    }
}