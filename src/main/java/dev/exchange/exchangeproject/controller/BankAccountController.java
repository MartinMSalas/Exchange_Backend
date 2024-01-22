package dev.exchange.exchangeproject.controller;

import dev.exchange.exchangeproject.dto.BankAccountDTO;
import dev.exchange.exchangeproject.inputs.CreateBankAccountInput;
import dev.exchange.exchangeproject.inputs.UpdateBankAccountInput;
import dev.exchange.exchangeproject.models.BankAccount;
import dev.exchange.exchangeproject.service.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
@AllArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @MutationMapping
    public BankAccount createBankAccount(CreateBankAccountInput createBankAccountInput){
        return bankAccountService.createBankAccout(createBankAccountInput);
    }

    @MutationMapping
    public BankAccount updateBankAccount(UpdateBankAccountInput updateBankAccountInput){
        return bankAccountService.updateBankAccout(updateBankAccountInput);
    }


}
