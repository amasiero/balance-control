package me.amasiero.balancecontrol.service;

import me.amasiero.balancecontrol.domain.dto.AccountDto;

import java.util.Set;

public interface AccountService {
    Set<AccountDto> getAll();

    AccountDto getById(Long id);

    AccountDto create(AccountDto accountDto);
}
