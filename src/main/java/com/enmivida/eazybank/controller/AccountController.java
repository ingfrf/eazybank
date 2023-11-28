package com.enmivida.eazybank.controller;

import com.enmivida.eazybank.model.Accounts;
import com.enmivida.eazybank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id) {
        Accounts accounts = accountRepository.findByCustomerId(id);
        if (accounts != null) {
            return accounts;
        }
        return null;
    }
}

