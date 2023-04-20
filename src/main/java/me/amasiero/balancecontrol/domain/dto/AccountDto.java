package me.amasiero.balancecontrol.domain.dto;

import lombok.Builder;
import lombok.Data;
import me.amasiero.balancecontrol.domain.Account;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Builder
public class AccountDto {
    private Long id;
    @NotBlank(message = "'name' is mandatory")
    private String name;
    private Set<TransactionDto> transactions;

    @Component
    public static class FromAccount {
        public AccountDto apply(Account account) {
            return AccountDto.builder()
                    .id(account.getId())
                    .name(account.getName())
                    .build();
        }

    }
}
