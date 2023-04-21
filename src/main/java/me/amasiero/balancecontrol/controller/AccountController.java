package me.amasiero.balancecontrol.controller;

import lombok.AllArgsConstructor;
import me.amasiero.balancecontrol.domain.dto.AccountDto;
import me.amasiero.balancecontrol.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> create(@Valid @RequestBody AccountDto accountDto) {
        AccountDto responseAccount = accountService.create(accountDto);
        return ResponseEntity
                .created(URI.create("/%d".formatted(responseAccount.getId())))
                .body(responseAccount);
    }

    @GetMapping
    public ResponseEntity<Set<AccountDto>> getAll() {
        return ResponseEntity.ok(accountService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getById(id));
    }
}
