package dev.exchange.exchangeproject.inputs.User;

import java.util.List;

import dev.exchange.exchangeproject.models.ExchangeAccount;
import dev.exchange.exchangeproject.models.User;
import dev.exchange.exchangeproject.models.enums.UserRoles;

public record CreateUserInput(
    UserRoles role,
    String email,
    List<User> contacts,
    List<ExchangeAccount> exchangeAccountList
) {
}