package dev.exchange.exchangeproject.service;

import dev.exchange.exchangeproject.dto.BankAccountDTO;
import dev.exchange.exchangeproject.exception.BankAccountNotFoundException;
import dev.exchange.exchangeproject.inputs.CreateBankAccountInput;
import dev.exchange.exchangeproject.inputs.UpdateBankAccountInput;
import dev.exchange.exchangeproject.mapper.BankAccountMapper;
import dev.exchange.exchangeproject.models.BankAccount;
import dev.exchange.exchangeproject.models.Transaction;
import dev.exchange.exchangeproject.models.enums.AccountType;
import dev.exchange.exchangeproject.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class BankAccountService {


    private final BankAccountRepository bankAccountRepository;


    private final BankAccountMapper bankAccountMapper;

    public BankAccount createBankAccout(CreateBankAccountInput createBankAccountInput){
        BankAccount bankAccount = new BankAccount(createBankAccountInput.accountNumber(),
                createBankAccountInput.bankName(),
                createBankAccountInput.bankAddress(),
                createBankAccountInput.swiftCode(),
                createBankAccountInput.accountType(),
                createBankAccountInput.accountDni(),
                createBankAccountInput.transactions());
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount updateBankAccout(UpdateBankAccountInput updateBankAccountInput){
        BankAccount bankAccount = bankAccountRepository.findById(updateBankAccountInput.id()).orElseThrow(BankAccountNotFoundException::new);
        bankAccount.setAccountDni(updateBankAccountInput.accountDni());
        bankAccount.setBankName(updateBankAccountInput.bankName());
        bankAccount.setAccountType(updateBankAccountInput.accountType());
        bankAccount.setBankAddress(updateBankAccountInput.bankAddress());
        bankAccount.setSwiftCode(updateBankAccountInput.swiftCode());
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public Optional<BankAccountDTO> updateBankAccount(String bankAccountId, BankAccountDTO bankAccountDto) {
        Optional<BankAccount> bankAccountOptional = bankAccountRepository.findById(bankAccountId);
        if(bankAccountOptional.isPresent()){

            BankAccount bankAccount = bankAccountOptional.get();
            if(bankAccountDto.getAccountNumber() != null)
                bankAccount.setAccountNumber(bankAccountDto.getAccountNumber());
            if(bankAccountDto.getAccountDni() != null)
                bankAccount.setAccountDni(bankAccountDto.getAccountDni());
            if(bankAccountDto.getAccountType() != null)
                bankAccount.setAccountType(bankAccountDto.getAccountType());
            if(bankAccountDto.getBankAddress() != null)
                bankAccount.setBankAddress(bankAccountDto.getBankAddress());
            if(bankAccountDto.getBankName() != null)
                bankAccount.setBankName(bankAccountDto.getBankName());
            if(bankAccountDto.getSwiftCode() != null)
                bankAccount.setSwiftCode(bankAccountDto.getSwiftCode());



            BankAccountDTO bankAccountDTO = bankAccountMapper.bankAccountToBankAccountDTO(bankAccountRepository.
                    save(bankAccount));
            return Optional.of(bankAccountDTO);
        }


        return Optional.empty();
    }

    @Override
    public Optional<BankAccountDTO> deleteBankAccountById(String bankAccountId) {


        AtomicReference<Optional<BankAccountDTO>> deletedBankAccount = new AtomicReference<>();
        bankAccountRepository.findById(bankAccountId).ifPresentOrElse(bankAccount -> {
            bankAccountRepository.delete(bankAccount);
            deletedBankAccount.set(Optional.of(bankAccountMapper.bankAccountToBankAccountDTO(bankAccount)));

        }, () -> {
            deletedBankAccount.set(Optional.empty());
        });
        return deletedBankAccount.get();
    }


    @Override
    public Optional<BankAccountDTO> getBankAccountByAccountNumber(String accountNumber) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
        if(bankAccount.isPresent()){
            BankAccountDTO bankAccountDTO = bankAccountMapper.bankAccountToBankAccountDTO(bankAccount.get());
            return Optional.of(bankAccountDTO);
        }
        return Optional.empty();
    }
}
