package com.cognizant.loan;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class loancontroller {
    @GetMapping("/loans/{number}")
    public Map<String, Object> getDetails(@PathVariable String number) {
        return Map.of("number", "H00987987972342", "type", "car", "loan", 400000, "emi", 3258, "tenure", 18);
    }
}