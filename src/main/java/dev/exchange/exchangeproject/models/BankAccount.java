package dev.exchange.exchangeproject.models;

import dev.exchange.exchangeproject.models.enums.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    @NotNull
    @Size(max=50, message = "BankAccount accountNumber must be less than or equal to 50 characters")
    @Column(length=50)
    private String accountNumber;


    private String bankName;
    private String bankAddress;
    @NotBlank
    @NotNull
    @Size(max=50, message = "BankAccount swiftCode must be less than or equal to 50 characters")
    @Column(length=50)
    private String swiftCode;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private Long accountDni;

    @ElementCollection
    @CollectionTable(name = "account_transactions")
    private List<Transaction> transactions;

    public BankAccount (String accountNumber, String bankName, String bankAddress, String swiftCode, AccountType accountType, Long accountDni, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.swiftCode = swiftCode;
        this.accountType = accountType;
        this.accountDni = accountDni;
        this.transactions = transactions;
    }

}
