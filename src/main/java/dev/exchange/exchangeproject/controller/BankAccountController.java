package dev.exchange.exchangeproject.controller;


import dev.exchange.exchangeproject.inputs.BankAccount.CreateBankAccountInput;
import dev.exchange.exchangeproject.inputs.BankAccount.UpdateBankAccountInput;
import dev.exchange.exchangeproject.models.BankAccount;
import dev.exchange.exchangeproject.service.BankAccountService;
import lombok.AllArgsConstructor;

import java.util.Optional;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
@AllArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    // Mutation Methods

    @MutationMapping
    public BankAccount createBankAccount(CreateBankAccountInput createBankAccountInput){
        return bankAccountService.createBankAccout(createBankAccountInput);
    }

    @MutationMapping
    public BankAccount updateBankAccount(UpdateBankAccountInput updateBankAccountInput){
        return bankAccountService.updateBankAccout(updateBankAccountInput);
    }

    
    @MutationMapping
    public BankAccount deleteBankAccountById(String bankAccountId){
        return bankAccountService.deleteBankAccountById(bankAccountId);
    }

    // Query Method

    @QueryMapping
    public BankAccount getBankAccountByAccountNumber(String accountNumber) {
        return bankAccountService.getBankAccountByAccountNumber(accountNumber);
    }

}
