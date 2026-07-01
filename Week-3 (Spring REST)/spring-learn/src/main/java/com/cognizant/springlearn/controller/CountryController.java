package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;
    
    public CountryController(CountryService countryService) {
        LOGGER.debug("Inside CountryController Constructor.");
        this.countryService = countryService;
    }

    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.info("END - getCountryIndia()");
        return country;
    }
    
    @GetMapping("/countries")
    @SuppressWarnings("unchecked")
    public java.util.List<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        java.util.List<Country> countryList = (java.util.List<Country>) context.getBean("countryList");
        LOGGER.info("END - getAllCountries()");
        return countryList;
    }
    
    @GetMapping("/countries/{code}")
    public Country getCountry(@org.springframework.web.bind.annotation.PathVariable String code) 
            throws com.cognizant.springlearn.service.exception.CountryNotFoundException {
        LOGGER.info("START - getCountry() : code = {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END - getCountry()");
        return country;
    }
}