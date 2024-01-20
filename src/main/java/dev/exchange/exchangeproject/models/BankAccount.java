package dev.exchange.exchangeproject.models;

import dev.exchange.exchangeproject.models.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //private String id;
    private String bankAccountId;

    private String accountNumber;

    private String bankName;
    private String bankAddress;

    private String swiftCode;

    @Enumerated(EnumType.STRING)
    //private Enum accountType;
    private AccountType accountType;

    private Long accountDni;
//
//    @ElementCollection
//    @CollectionTable(name = "account_transactions")
//    private List<Transaction> transactions;


}
