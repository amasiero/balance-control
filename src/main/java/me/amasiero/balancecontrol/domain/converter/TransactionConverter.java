package me.amasiero.balancecontrol.domain.converter;

import me.amasiero.balancecontrol.domain.Transaction;
import me.amasiero.balancecontrol.domain.TransactionType;
import me.amasiero.balancecontrol.domain.dto.TransactionDto;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter implements BaseConverter<TransactionDto, Transaction> {
    @Override
    public Transaction apply(TransactionDto transactionDto) {
        return Transaction.builder()
                .description(transactionDto.getDescription())
                .amount(transactionDto.getAmount())
                .type(TransactionType.valueOf(transactionDto.getType().toUpperCase()))
                .date(transactionDto.getDate())
                .build();
    }
}
