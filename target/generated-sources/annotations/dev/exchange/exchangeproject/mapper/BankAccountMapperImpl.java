package dev.exchange.exchangeproject.mapper;

import dev.exchange.exchangeproject.dto.BankAccountDTO;
import dev.exchange.exchangeproject.models.BankAccount;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-23T17:15:07-0600",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240103-0614, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class BankAccountMapperImpl implements BankAccountMapper {

    @Override
    public BankAccount bankAccountDtoToBankAccount(BankAccountDTO bankAccountDTO) {
        if ( bankAccountDTO == null ) {
            return null;
        }

        BankAccount.BankAccountBuilder bankAccount = BankAccount.builder();

        bankAccount.accountDni( bankAccountDTO.getAccountDni() );
        bankAccount.accountNumber( bankAccountDTO.getAccountNumber() );
        bankAccount.accountType( bankAccountDTO.getAccountType() );
        bankAccount.bankAddress( bankAccountDTO.getBankAddress() );
        bankAccount.bankName( bankAccountDTO.getBankName() );
        bankAccount.swiftCode( bankAccountDTO.getSwiftCode() );

        return bankAccount.build();
    }

    @Override
    public BankAccountDTO bankAccountToBankAccountDTO(BankAccount bankAccount) {
        if ( bankAccount == null ) {
            return null;
        }

        BankAccountDTO.BankAccountDTOBuilder bankAccountDTO = BankAccountDTO.builder();

        bankAccountDTO.accountDni( bankAccount.getAccountDni() );
        bankAccountDTO.accountNumber( bankAccount.getAccountNumber() );
        bankAccountDTO.accountType( bankAccount.getAccountType() );
        bankAccountDTO.bankAddress( bankAccount.getBankAddress() );
        bankAccountDTO.bankName( bankAccount.getBankName() );
        bankAccountDTO.swiftCode( bankAccount.getSwiftCode() );

        return bankAccountDTO.build();
    }
}
