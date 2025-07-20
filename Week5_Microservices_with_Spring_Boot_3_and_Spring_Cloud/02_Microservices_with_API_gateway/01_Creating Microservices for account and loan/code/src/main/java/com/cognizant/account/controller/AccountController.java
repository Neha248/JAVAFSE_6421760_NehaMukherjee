package com.cognizant.account.controller;
import org.springframework.web.bind.annotation.*;

import com.cognizant.account.model.Account;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping("/{number}")
    public Account getAccountByNumber(@PathVariable String number) {
      
        return new Account(number, "Neha Mukherjee", 98765.43);
    }
}
