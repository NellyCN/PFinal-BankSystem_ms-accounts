package com.xyzbank.ms_account.service.impl;

import com.xyzbank.ms_account.model.Account;
import com.xyzbank.ms_account.repository.AccountRepository;
import com.xyzbank.ms_account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Constructor para inyectar el repositorio
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();  // Obtiene todos los clientes de la base de datos
    }

}
