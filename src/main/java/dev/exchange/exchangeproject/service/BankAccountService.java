package dev.exchange.exchangeproject.service;

import dev.exchange.exchangeproject.dto.BankAccountDTO;

import java.util.Optional;


public interface BankAccountService {

    public Optional<BankAccountDTO>  createBankAccount(BankAccountDTO bankAccountDto);

    public Optional<BankAccountDTO> getBankAccountById(String id);

    public Optional<BankAccountDTO>  updateBankAccount(String bankAccountId, BankAccountDTO bankAccountDto);

    public Optional<BankAccountDTO>  deleteBankAccountById(String bankAccountId);

    public Optional<BankAccountDTO>  getBankAccountByAccountNumber(String accountNumber);
}
