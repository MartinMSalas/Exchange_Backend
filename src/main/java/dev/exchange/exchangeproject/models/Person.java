package dev.exchange.exchangeproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public abstract class Person {
    private Long dni;

    private String name;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;
}
