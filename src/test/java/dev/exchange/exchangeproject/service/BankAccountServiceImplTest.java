package dev.exchange.exchangeproject.service;


import dev.exchange.exchangeproject.dto.BankAccountDTO;
import dev.exchange.exchangeproject.mapper.BankAccountMapper;
import dev.exchange.exchangeproject.models.BankAccount;
import dev.exchange.exchangeproject.models.enums.AccountType;
import dev.exchange.exchangeproject.repository.BankAccountRepository;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BankAccountServiceImplTest {


    @InjectMocks
    private BankAccountService bankAccountService;


    private final BankAccountMapper bankAccountMapper = Mappers.getMapper(BankAccountMapper.class);
    @Mock
    private BankAccountRepository bankAccountRepository;





    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        bankAccountService = new BankAccountService( bankAccountRepository,bankAccountMapper);
    }

    BankAccountDTO bankAccountDto = BankAccountDTO.builder()
            .bankAccountId("123")
            .accountNumber("1234567890")
            .bankName("Bank of America")
            .bankAddress("123 Main St")
            .swiftCode("ABCDEF")
            .accountType(AccountType.SAVINGS)
            .accountDni(1234567890L)
            .build();
    BankAccount bankAccount = BankAccount.builder()
            .bankAccountId("123")
            .accountNumber("1234567890")
            .bankName("Bank of America")
            .bankAddress("123 Main St")
            .swiftCode("ABCDEF")
            .accountType(AccountType.SAVINGS)
            .accountDni(1234567890L)
            .build();
    // BankAccountDTO object is created successfully
    @Test
    void test_createBankAccount_success() {


        //when(bankAccountMapper.bankAccountDtoToBankAccount(bankAccountDto)).thenReturn(bankAccount);
        //when(bankAccountMapper.bankAccountToBankAccountDTO(bankAccount)).thenReturn(bankAccountDto);
        when(bankAccountRepository.save(any())).thenReturn(bankAccount);
        //System.out.println(bankAccountDto);
        Optional<BankAccountDTO> result = bankAccountService.createBankAccount(bankAccountDto);

        assertTrue(result.isPresent());
        assertEquals(bankAccountDto, result.get());
    }



    // BankAccountDTO object is retrieved successfully
    @Test
    public void test_getBankAccountById_success() {
        String id = "123";
        when(bankAccountRepository.findById(id)).thenReturn(Optional.of(bankAccount));
        //when(bankAccountMapper.bankAccountToBankAccountDTO(bankAccount)).thenReturn(bankAccountDto);

        Optional<BankAccountDTO> result = bankAccountService.getBankAccountById(id);

        assertTrue(result.isPresent());
        assertEquals(bankAccountDto, result.get());

    }

    // BankAccountDTO object is updated successfully
    @Test
    public void test_updateBankAccount_success() {
        String id = "123";
        when(bankAccountRepository.save(any())).thenReturn(bankAccount);

        when(bankAccountRepository.findById("123")).thenReturn(Optional.of(bankAccount));

//
        Optional<BankAccountDTO> result = bankAccountService.updateBankAccount("123",bankAccountDto);
//
        assertTrue(result.isPresent());
        assertEquals(bankAccountDto, result.get());
        // Add additional assertions if necessary
    }

    // BankAccountDTO object is deleted successfully
    @Test
    public void test_deleteBankAccountById_success() {
        String id = "123";
        when(bankAccountRepository.findById(id)).thenReturn(Optional.of(bankAccount));


//
        Optional<BankAccountDTO> result = bankAccountService.deleteBankAccountById(id);
//
        assertTrue(result.isPresent());
        assertEquals(bankAccountDto, result.get());
    }

    // BankAccountDTO object is retrieved by account number successfully
    @Test
    public void test_getBankAccountByAccountNumber_success() {
        String accountNumber = "123456789";

        when(bankAccountRepository.findByAccountNumber(accountNumber)).thenReturn(Optional.of(bankAccount));



        Optional<BankAccountDTO> result = bankAccountService.getBankAccountByAccountNumber(accountNumber);

        assertTrue(result.isPresent());
        assertEquals(bankAccountDto, result.get());

    }

    // Optional.empty() is returned when no BankAccountDTO object is found by id
    @Test
    public void test_getBankAccountById_notFound() {

        String id = "123";

        when(bankAccountRepository.findById(id)).thenReturn(Optional.empty());

        Optional<BankAccountDTO> result = bankAccountService.getBankAccountById(id);

        assertFalse(result.isPresent());

    }

    // BankAccountDTO object creation fails due to missing required fields
    @Test
    public void test_createBankAccount_missingFields() {

        // Set necessary fields for creation, but leave out required fields
        // ...
        BankAccountDTO incompleteBankAccount = BankAccountDTO.builder()
                .bankAccountId("123")
                .bankName("Bank of America")
                .bankAddress("123 Main St")
//                .swiftCode("ABCDEF")
                .accountType(AccountType.SAVINGS)
                .accountDni(1234567890L)
                .build();

        when(bankAccountRepository.save(bankAccountMapper.bankAccountDtoToBankAccount(incompleteBankAccount))).thenThrow(ConstraintViolationException.class);

        assertThrows(ConstraintViolationException.class, () -> {
            bankAccountService.createBankAccount(incompleteBankAccount);
        });
    }


    // BankAccountDTO object retrieval fails due to invalid id format
    @Test
    public void test_getBankAccountById_invalidIdFormat() {
        String id = "invalid_id";

        Optional<BankAccountDTO> result = bankAccountService.getBankAccountById(id);

        assertFalse(result.isPresent());

    }

    // BankAccountDTO object update fails due to invalid id format

}