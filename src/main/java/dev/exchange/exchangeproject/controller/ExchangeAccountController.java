package dev.exchange.exchangeproject.controller;

import lombok.AllArgsConstructor;

import dev.exchange.exchangeproject.inputs.CreateExchangeAccountInput;
import dev.exchange.exchangeproject.inputs.UpdateExchangeAccountInput;
import dev.exchange.exchangeproject.models.BankAccount;
import dev.exchange.exchangeproject.models.ExchangeAccount;
import dev.exchange.exchangeproject.models.ExchangeAccount;
import dev.exchange.exchangeproject.service.ExchangeAccountService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ExchangeAccountController {
    
    
    private final ExchangeAccountService exchangeAccountService; 

    // Mutation Methods

    @MutationMapping
    public ExchangeAccount createExchangeAccount(CreateExchangeAccountInput createExchangeAccountInput){
        return ExchangeAccountService.createExchangeAccout(createExchangeAccountInput); //DUDAD DE SI DEBE SER INPUT Y PORQUE EN TRANSACTION NO
    }

    @MutationMapping
    public ExchangeAccount updateExchangeAccount(UpdateExchangeAccountInput updateExchangeAccountInput){
        return ExchangeAccountService.updateExchangeAccout(updateExchangeAccountInput);
    }

    
    @MutationMapping
    public ExchangeAccount deleteExchangeAccountById(String ExchangeAccountId){
        return ExchangeAccountService.deleteExchangeAccountById(ExchangeAccountId);
    }

    // Query Method

    @QueryMapping
    public ExchangeAccount getExchangeAccountById(String ExchangeAccountId) {
        return ExchangeAccountService.getExchangeAccountById(ExchangeAccountId);
    }

}
