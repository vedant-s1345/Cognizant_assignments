package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries()");
        return countryService.getAllCountries();
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("START - getCountry() : code = {}", code);
        return countryService.getCountry(code);
    }

    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("Start - addCountry() : {}", country);
        Country saved = countryService.addCountry(country);
        LOGGER.info("End - addCountry()");
        return saved;
    }

    @PutMapping
    public Country updateCountry(@RequestBody @Valid Country country) {
        LOGGER.info("Start - updateCountry() : {}", country);
        Country updated = countryService.updateCountry(country);
        LOGGER.info("End - updateCountry()");
        return updated;
    }

    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {
        LOGGER.info("Start - deleteCountry() : {}", code);
        countryService.deleteCountry(code);
        LOGGER.info("End - deleteCountry()");
    }
}