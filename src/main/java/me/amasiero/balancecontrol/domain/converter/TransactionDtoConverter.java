package me.amasiero.balancecontrol.domain.converter;

import me.amasiero.balancecontrol.domain.Transaction;
import me.amasiero.balancecontrol.domain.dto.TransactionDto;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter implements BaseConverter<Transaction, TransactionDto> {
    @Override
    public TransactionDto apply(Transaction transaction) {
        return TransactionDto.builder()
                .description(transaction.getDescription())
                .amount(transaction.getAmount())
                .type(transaction.getType().name())
                .date(transaction.getDate())
                .build();
    }
}
