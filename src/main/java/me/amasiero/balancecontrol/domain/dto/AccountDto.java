package me.amasiero.balancecontrol.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Builder
public class AccountDto {
    private Long id;
    @NotBlank(message = "'name' is mandatory")
    private String name;
    @EqualsAndHashCode.Exclude
    private Set<TransactionDto> transactions;
}
