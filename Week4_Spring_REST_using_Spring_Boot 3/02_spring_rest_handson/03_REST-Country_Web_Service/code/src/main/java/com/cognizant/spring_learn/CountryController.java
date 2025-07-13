package com.cognizant.spring_learn;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.model.Country;

@RestController
public class CountryController {

    @GetMapping("/country")
    public Country getCountryIndia() {
        return new ClassPathXmlApplicationContext("springConfig.xml").getBean("india", Country.class);
    }
}