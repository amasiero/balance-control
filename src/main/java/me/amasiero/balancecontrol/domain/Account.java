package me.amasiero.balancecontrol.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.amasiero.balancecontrol.domain.dto.AccountDto;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder.Default
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "account")
    private Set<Transaction> transactions = new LinkedHashSet<>();

    @Component
    @AllArgsConstructor
    public static class FromAccountDto {

        private final Transaction.FromTransationDto fromTransationDto;

        public Account apply(AccountDto accountDto) {
            return Account.builder()
                    .id(accountDto.getId())
                    .name(accountDto.getName())
                    .transactions(accountDto.getTransactions()
                            .stream()
                            .map(fromTransationDto::apply)
                            .collect(Collectors.toSet()))
                    .build();
        }
    }
}
