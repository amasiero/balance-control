package me.amasiero.balancecontrol.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import me.amasiero.balancecontrol.domain.Account;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class AccountDto {
    private Long id;
    @NotBlank(message = "'name' is mandatory")
    private String name;
    private Set<TransactionDto> transactions;

    @Component
    @AllArgsConstructor
    public static class FromAccount {

        private final TransactionDto.FromTransaction fromTransaction;

        public AccountDto apply(Account account) {
            return AccountDto.builder()
                    .id(account.getId())
                    .name(account.getName())
                    .transactions(account.getTransactions()
                            .stream()
                            .map(fromTransaction::apply)
                            .collect(Collectors.toSet()))
                    .build();
        }

    }
}
