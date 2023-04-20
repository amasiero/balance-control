package me.amasiero.balancecontrol.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(Long id) {
        super("Account number %d not found".formatted(id));
    }
}
