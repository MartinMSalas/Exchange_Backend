package dev.exchange.exchangeproject.service;

import dev.exchange.exchangeproject.dto.TransactionDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {




    @Override
    public Optional<TransactionDTO> createTransaction(TransactionDTO transactionDto) {
        return Optional.empty();
    }

    @Override
    public Optional<TransactionDTO> getTransactionById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getAllTransactions() {
        return Optional.empty();
    }

    @Override
    public Optional<TransactionDTO> updateTransaction(String transactionId, TransactionDTO transactionDto) {
        return Optional.empty();
    }

    @Override
    public Optional<TransactionDTO> deleteTransactionById(String transactionId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionBySourceAccount(String accountNumber) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionByDestinationAccount(String accountNumber) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionBySourceAccountAndDestinationAccount(String sourceAccountNumber, String destinationAccountNumber) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionByStatus(String status) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionByType(String type) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionByDateAndTime(String dateAndTime) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionByAmount(BigDecimal amount) {
        return Optional.empty();
    }
}
