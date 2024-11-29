package com.xyzbank.ms_account;

import com.xyzbank.ms_account.model.Account;
import com.xyzbank.ms_account.repository.AccountRepository;
import com.xyzbank.ms_account.service.AccountService;
import com.xyzbank.ms_account.service.impl.AccountServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MsAccountApplicationTests {

	@Mock
	private AccountRepository accountRepository;

	private AccountServiceImpl accountService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		// Instanciar el servicio con el mock del repositorio
		accountService = new AccountServiceImpl(accountRepository);
	}

	@Test
	void testGetAllAccounts() {
		// Datos simulados
		Account account1 = new Account(1L, "191-1000000", 0.0, "2");
		Account account2 = new Account(2L, "191-1000001", 0.0, "1");
		Account account3 = new Account(3L, "191-1000101", 0.0, "3");
		List<Account> mockAccounts = Arrays.asList(account1, account2, account3);

		// Configurar el comportamiento del mock
		when(accountRepository.findAll()).thenReturn(mockAccounts);

		// Llamar al metodo a probar
		List<Account> result = accountService.getAllAccounts();

		// Verificar los resultados
		assertEquals(3, result.size());
		assertEquals("191-1000000", result.get(0).getAccount_number());
		assertEquals("191-1000001", result.get(1).getAccount_number());
		assertEquals("191-1000101", result.get(2).getAccount_number());
	}
}
