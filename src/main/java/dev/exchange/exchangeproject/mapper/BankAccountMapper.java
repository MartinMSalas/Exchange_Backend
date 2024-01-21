package dev.exchange.exchangeproject.mapper;

import dev.exchange.exchangeproject.dto.BankAccountDTO;
import dev.exchange.exchangeproject.models.BankAccount;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
@Mapper
public interface BankAccountMapper {
    BankAccount bankAccountDtoToBankAccount(BankAccountDTO bankAccountDTO);

    BankAccountDTO bankAccountToBankAccountDTO(BankAccount bankAccount);
}

