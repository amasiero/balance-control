package me.amasiero.balancecontrol.domain.converter;

import lombok.AllArgsConstructor;
import me.amasiero.balancecontrol.domain.Account;
import me.amasiero.balancecontrol.domain.dto.AccountDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AccountConverter implements BaseConverter<AccountDto, Account> {

    private final TransactionConverter converter;

    @Override
    public Account apply(AccountDto accountDto) {
        return Account.builder()
                .id(accountDto.getId())
                .name(accountDto.getName())
                .transactions(accountDto.getTransactions()
                        .stream()
                        .map(converter::apply)
                        .collect(Collectors.toSet()))
                .build();
    }
}
