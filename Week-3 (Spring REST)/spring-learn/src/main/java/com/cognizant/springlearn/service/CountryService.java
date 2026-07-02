package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    private final List<Country> countryList;

    @SuppressWarnings("unchecked")
    public CountryService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> xmlList = (List<Country>) context.getBean("countryList");
        this.countryList = new ArrayList<>(xmlList);
    }

    public List<Country> getAllCountries() {
        return countryList;
    }

    public Country getCountry(String code) {
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(CountryNotFoundException::new);
    }

    public Country addCountry(Country country) {
        countryList.add(country);
        return country;
    }

    public Country updateCountry(Country country) {
        Country existing = getCountry(country.getCode());
        existing.setName(country.getName());
        return existing;
    }

    public void deleteCountry(String code) {
        Country existing = getCountry(code);
        countryList.remove(existing);
    }
}