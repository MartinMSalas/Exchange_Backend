package dev.exchange.exchangeproject.service;

import dev.exchange.exchangeproject.dto.BankAccountDTO;
import dev.exchange.exchangeproject.mapper.BankAccountMapper;
import dev.exchange.exchangeproject.models.BankAccount;
import dev.exchange.exchangeproject.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {


    private final BankAccountRepository bankAccountRepository;


    private final BankAccountMapper bankAccountMapper;




    @Override
    public Optional<BankAccountDTO> createBankAccount(BankAccountDTO bankAccountDto) {
        BankAccount bankAccount = bankAccountMapper.bankAccountDtoToBankAccount(bankAccountDto);

        BankAccountDTO bankAccountDTO = bankAccountMapper.bankAccountToBankAccountDTO(bankAccountRepository.
                                        save(bankAccount));

        return Optional.of(bankAccountDTO);
    }

    @Override
    public Optional<BankAccountDTO> getBankAccountById(String id) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
        if(bankAccount.isPresent()){
            BankAccountDTO bankAccountDTO = bankAccountMapper.bankAccountToBankAccountDTO(bankAccount.get());
            return Optional.of(bankAccountDTO);
        }
        return Optional.empty();
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