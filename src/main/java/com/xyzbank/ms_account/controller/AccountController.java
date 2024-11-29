package com.xyzbank.ms_account.controller;


import com.xyzbank.ms_account.model.Account;
import com.xyzbank.ms_account.service.AccountService;

import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();   // Llama al servicio para obtener todos los clientes
    }
}