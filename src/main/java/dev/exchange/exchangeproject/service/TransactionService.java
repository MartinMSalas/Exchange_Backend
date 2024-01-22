package dev.exchange.exchangeproject.service;

import dev.exchange.exchangeproject.dto.TransactionDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Optional<TransactionDTO> createTransaction(TransactionDTO transactionDto);

    Optional<TransactionDTO> getTransactionById(String id);

    Optional<List<TransactionDTO>> getAllTransactions();

    Optional<TransactionDTO> updateTransaction(String transactionId, TransactionDTO transactionDto);

    Optional<TransactionDTO> deleteTransactionById(String transactionId);

    Optional<List<TransactionDTO>> getTransactionBySourceAccount(String accountNumber);

    Optional<List<TransactionDTO>> getTransactionByDestinationAccount(String accountNumber);

Optional<List<TransactionDTO>> getTransactionBySourceAccountAndDestinationAccount(String sourceAccountNumber, String destinationAccountNumber);

Optional<List<TransactionDTO>> getTransactionByStatus(String status);

Optional<List<TransactionDTO>> getTransactionByType(String type);

Optional<List<TransactionDTO>> getTransactionByDateAndTime(String dateAndTime);

Optional<List<TransactionDTO>> getTransactionByAmount(BigDecimal amount);
}
