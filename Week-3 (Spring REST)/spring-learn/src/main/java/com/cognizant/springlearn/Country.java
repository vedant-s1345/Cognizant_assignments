package com.cognizant.springlearn;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    @NotNull
    @Size(min = 2, max = 2, message = "Country code should be 2 characters")
    private String code;

    @NotBlank(message = "Country name should not be blank")
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("getCode() invoked");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("setCode() invoked with value: {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("getName() invoked");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("setName() invoked with value: {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}