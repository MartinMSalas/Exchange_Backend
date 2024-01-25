package dev.exchange.exchangeproject.controller;


import dev.exchange.exchangeproject.inputs.CreateUserInput;
import dev.exchange.exchangeproject.inputs.UpdateUserInput;
import dev.exchange.exchangeproject.models.User;
import dev.exchange.exchangeproject.service.UserService;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService UserService;

    // Mutation Methods

    @MutationMapping
    public User createUser(CreateUserInput createUserInput){
        return UserService.createUser(createUserInput);
    }

    @MutationMapping
    public User updateUser(UpdateUserInput updateUserInput){
        return UserService.updateUser(updateUserInput);
    }

    
    @MutationMapping
    public User deleteUserById(String userId){
        return UserService.deleteUserById(userId);
    }

    // Query Method

    @QueryMapping
    public User getUserById(String userId) {
        return UserService.getUserById(userId);
    }

