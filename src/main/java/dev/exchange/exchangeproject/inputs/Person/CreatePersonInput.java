package dev.exchange.exchangeproject.inputs.Person;
import java.time.LocalDate;


public record CreatePersonInput(
    Long dni,
    String name,
    String lastName,
    LocalDate birthDate
) {
}
