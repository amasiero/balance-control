package me.amasiero.balancecontrol.service;

import lombok.AllArgsConstructor;
import me.amasiero.balancecontrol.domain.Account;
import me.amasiero.balancecontrol.domain.dto.AccountDto;
import me.amasiero.balancecontrol.exception.AccountNotFoundException;
import me.amasiero.balancecontrol.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private AccountDto.FromAccount fromAccount;

    @Override
    public Set<AccountDto> getAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(fromAccount::apply)
                .collect(Collectors.toSet());
    }

    @Override
    public AccountDto getById(Long id) {
        return accountRepository.findById(id)
                .map(fromAccount::apply)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        return null;
    }
}
