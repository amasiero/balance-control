package me.amasiero.balancecontrol.domain.converter;

import lombok.AllArgsConstructor;
import me.amasiero.balancecontrol.domain.Account;
import me.amasiero.balancecontrol.domain.dto.AccountDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AccountDtoConverter implements BaseConverter<Account, AccountDto> {

    private final TransactionDtoConverter converter;

    @Override
    public AccountDto apply(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .transactions(account.getTransactions()
                        .stream()
                        .map(converter::apply)
                        .collect(Collectors.toSet()))
                .build();
    }
}
