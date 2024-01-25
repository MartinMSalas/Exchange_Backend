package dev.exchange.exchangeproject.controller;


import dev.exchange.exchangeproject.models.Transaction;
import dev.exchange.exchangeproject.service.TransactionService;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
@AllArgsConstructor
public class TransactionController{

    private final TransactionService transactionService;

    // Mutation Methods

    @MutationMapping
    public Transaction createTransaction(CreateTransactionInput createTransactionInput) {
        return transactionService.createTransaction(createTransactionInput);
    }
    
    @MutationMapping
    public Transaction updateTransaction(UpdateTransactionInput updateTransactionInput) {
        return transactionService.updateTransaction(updateTransactionInput);
    }

    @MutationMapping
    public Transaction deleteTransactionById(String transactionId) {
        return transactionService.deleteTransactionById(transactionId);
    }

    // Query Methods

    @QueryMapping
    public Transaction getTransactionById(String id) {
        return transactionService.getTransactionById(id);
    }
    
    @QueryMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @QueryMapping
    public List<Transaction> getTransactionBySourceAccount(String accountNumber) {
        return transactionService.getTransactionBySourceAccount(accountNumber);
    }

    @QueryMapping
    public List<Transaction> getTransactionByDestinationAccount(String accountNumber) {
        return transactionService.getTransactionByDestinationAccount(accountNumber);
    }

    @QueryMapping
    public List<Transaction> getTransactionBySourceAccountAndDestinationAccount(String sourceAccountNumber, String destinationAccountNumber) {
        return transactionService.getTransactionBySourceAccountAndDestinationAccount(sourceAccountNumber, destinationAccountNumber);
    }

    @QueryMapping
    public List<Transaction> getTransactionByStatus(String status) {
        return transactionService.getTransactionByStatus(status);
    }

    @QueryMapping
    public List<Transaction> getTransactionByType(String type) {
        return transactionService.getTransactionByType(type);
    }

    @QueryMapping
    public List<Transaction> getTransactionByDateAndTime(String dateAndTime) {
        return transactionService.getTransactionByDateAndTime(dateAndTime);
    }

    @QueryMapping
    public List<Transaction> getTransactionByAmount(BigDecimal amount) {
        return transactionService.getTransactionByAmount(amount);
    }
}