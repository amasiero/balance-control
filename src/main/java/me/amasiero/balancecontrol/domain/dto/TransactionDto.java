package me.amasiero.balancecontrol.domain.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
public class TransactionDto {
    private String description;
    @NotNull(message = "'amount' is mandatory")
    private Double amount;
    @NotBlank(message = "'type' is mandatory")
    private String type;
    @Builder.Default
    private LocalDate date = LocalDate.now();
}
