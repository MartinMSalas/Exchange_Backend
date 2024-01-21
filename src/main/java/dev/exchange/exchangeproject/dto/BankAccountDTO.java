package dev.exchange.exchangeproject.dto;

import dev.exchange.exchangeproject.models.enums.AccountType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTO {

    private String bankAccountId;

    private String accountNumber;

    @NotBlank
    @NotNull
    @Size(max=50, message = "BankAccount accountNumber must be less than or equal to 50 characters")
    @Column(length=50)
    private String bankName;
    private String bankAddress;

    @NotBlank
    @NotNull
    @Size(max=50, message = "BankAccount swiftCode must be less than or equal to 50 characters")
    @Column(length=50)
    private String swiftCode;

    @Enumerated(EnumType.STRING)
    //private Enum accountType;
    private AccountType accountType;

    private Long accountDni;
}
