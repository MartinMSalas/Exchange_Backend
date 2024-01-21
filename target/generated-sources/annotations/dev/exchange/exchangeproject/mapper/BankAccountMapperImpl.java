package dev.exchange.exchangeproject.mapper;

import dev.exchange.exchangeproject.dto.BankAccountDTO;
import dev.exchange.exchangeproject.models.BankAccount;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-21T18:46:08-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class BankAccountMapperImpl implements BankAccountMapper {

    @Override
    public BankAccount bankAccountDtoToBankAccount(BankAccountDTO bankAccountDTO) {
        if ( bankAccountDTO == null ) {
            return null;
        }

        BankAccount.BankAccountBuilder bankAccount = BankAccount.builder();

        bankAccount.bankAccountId( bankAccountDTO.getBankAccountId() );
        bankAccount.accountNumber( bankAccountDTO.getAccountNumber() );
        bankAccount.bankName( bankAccountDTO.getBankName() );
        bankAccount.bankAddress( bankAccountDTO.getBankAddress() );
        bankAccount.swiftCode( bankAccountDTO.getSwiftCode() );
        bankAccount.accountType( bankAccountDTO.getAccountType() );
        bankAccount.accountDni( bankAccountDTO.getAccountDni() );

        return bankAccount.build();
    }

    @Override
    public BankAccountDTO bankAccountToBankAccountDTO(BankAccount bankAccount) {
        if ( bankAccount == null ) {
            return null;
        }

        BankAccountDTO.BankAccountDTOBuilder bankAccountDTO = BankAccountDTO.builder();

        bankAccountDTO.bankAccountId( bankAccount.getBankAccountId() );
        bankAccountDTO.accountNumber( bankAccount.getAccountNumber() );
        bankAccountDTO.bankName( bankAccount.getBankName() );
        bankAccountDTO.bankAddress( bankAccount.getBankAddress() );
        bankAccountDTO.swiftCode( bankAccount.getSwiftCode() );
        bankAccountDTO.accountType( bankAccount.getAccountType() );
        bankAccountDTO.accountDni( bankAccount.getAccountDni() );

        return bankAccountDTO.build();
    }
}
