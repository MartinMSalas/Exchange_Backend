package dev.exchange.exchangeproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExchangeAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany
    private List<BankAccount> bankAccounts;

    @OneToMany
    //private List<Transaction> transactions;
    private List<Transaction> transactionsList;
    private Double balance;
}
