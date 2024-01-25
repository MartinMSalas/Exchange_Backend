package dev.exchange.exchangeproject.controller;


import dev.exchange.exchangeproject.inputs.CreatePersonInput;
import dev.exchange.exchangeproject.inputs.UpdatePersonInput;
import dev.exchange.exchangeproject.models.Person;
import dev.exchange.exchangeproject.service.PersonService;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
@AllArgsConstructor
public class PersonController {

    private final PersonService PersonService;

    // Mutation Methods

    @MutationMapping
    public Person createPerson(CreatePersonInput createPersonInput){
        return PersonService.createPerson(createPersonInput);
    }

    @MutationMapping
    public Person updatePerson(UpdatePersonInput updatePersonInput){
        return PersonService.updatePerson(updatePersonInput);
    }

    
    @MutationMapping
    public Person deletePersonByDni(String personDni){
        return PersonService.deletePersonByDni(personDni);
    }

    // Query Method

    @QueryMapping
    public Person getPersonByDni(String dni) {
        return PersonService.getPersonByDni(dni);
    }

    @QueryMapping
    public List<Person> getPersonsByName(String name) {
        return PersonService.getPersonsByName(name);
    }

    @QueryMapping
    public List<Person> getPersonsByLastName(String lastName) {
        return PersonService.getPersonsByLastName(lastName);
    }

    @QueryMapping
    public List<Person> getPersonsByBirthDate(LocalDate birthDate) {
        return PersonService.getPersonsByBirthDate(birthDate);
    }


}
