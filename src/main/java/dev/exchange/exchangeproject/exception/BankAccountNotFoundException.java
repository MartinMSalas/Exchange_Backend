package dev.exchange.exchangeproject.exception;

public class BankAccountNotFoundException extends RuntimeException {
    public BankAccountNotFoundException() {
        super("Bank account not found");
    }
}
