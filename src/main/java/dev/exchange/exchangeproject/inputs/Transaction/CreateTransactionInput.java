package dev.exchange.exchangeproject.inputs.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import dev.exchange.exchangeproject.models.enums.TransactionStatus;
import dev.exchange.exchangeproject.models.enums.TransactionType;


public record CreateTransactionInput(
    LocalDateTime dateAndTime,
    TransactionType type,
    BigDecimal amount,
    String description,
    String sourceAccountId,
    String destinationAccountId,
    TransactionStatus status
) {
}
