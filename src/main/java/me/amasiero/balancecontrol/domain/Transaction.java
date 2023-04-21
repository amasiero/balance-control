package me.amasiero.balancecontrol.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.amasiero.balancecontrol.domain.dto.TransactionDto;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double amount;
    private TransactionType type;
    private LocalDate date;
    @ManyToOne
    private Account account;

    @Component
    public static class FromTransationDto {
        public Transaction apply(TransactionDto transactionDto) {
            return Transaction.builder()
                    .description(transactionDto.getDescription())
                    .amount(transactionDto.getAmount())
                    .type(TransactionType.valueOf(transactionDto.getType().toUpperCase()))
                    .date(transactionDto.getDate())
                    .build();
        }
    }
}
