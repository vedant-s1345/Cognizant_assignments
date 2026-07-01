package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmlearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmlearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmlearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
    }

    // Test 1: Get all countries
    private static void testGetAllCountries() {
        LOGGER.info("=== Test Get All Countries ===");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Countries: {}", countries);
        LOGGER.info("Total countries: {}", countries.size());
    }

    // Test 2: Find country by code
    private static void testFindCountryByCode() {
        LOGGER.info("=== Test Find Country By Code ===");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Found Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
    }

    // Test 3: Add new country
    private static void testAddCountry() {
        LOGGER.info("=== Test Add Country ===");
        Country country = new Country();
        country.setCode("SG");
        country.setName("Singapore");
        countryService.addCountry(country);
        LOGGER.debug("Country added successfully");

        try {
            Country added = countryService.findCountryByCode("SG");
            LOGGER.debug("Verified added country: {}", added);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
    }

    // Test 4: Update country
    private static void testUpdateCountry() {
        LOGGER.info("=== Test Update Country ===");
        try {
            countryService.updateCountry("SG", "Singapore (Updated)");
            Country updated = countryService.findCountryByCode("SG");
            LOGGER.debug("Updated Country: {}", updated);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
    }

    // Test 5: Delete country
    private static void testDeleteCountry() {
        LOGGER.info("=== Test Delete Country ===");
        countryService.deleteCountry("SG");
        LOGGER.debug("Country SG deleted successfully");

        try {
            countryService.findCountryByCode("SG");
        } catch (CountryNotFoundException e) {
            LOGGER.error("Verified deletion - {}", e.getMessage());
        }
    }
}