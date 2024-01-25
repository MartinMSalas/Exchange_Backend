package dev.exchange.exchangeproject.inputs.Exchange;

import java.util.List;

import dev.exchange.exchangeproject.models.BankAccount;
import dev.exchange.exchangeproject.models.Transaction;

public record CreateExchangeAccountInput(
         List<BankAccount> bankAccounts,
         List<Transaction> transactionsList,
         Double balance){
}
