package dev.exchange.exchangeproject.service;

import dev.exchange.exchangeproject.dto.TransactionDTO;
import dev.exchange.exchangeproject.mapper.TransactionMapper;
import dev.exchange.exchangeproject.models.Transaction;
import dev.exchange.exchangeproject.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @InjectMocks
    private TransactionServiceImpl transactionService;

    private final TransactionMapper transactionMapper = Mappers.getMapper(TransactionMapper.class);

    @Mock
    private TransactionRepository transactionRepository;

    TransactionDTO transactionDto = TransactionDTO.builder()
            .transactionId("123")
            .sourceAccountId("1234567890")
            .destinationAccountId("0987654321")
            .amount(BigDecimal.valueOf(100.00))
            .build();

    Transaction transaction = Transaction.builder()
            .transactionId("123")
            .sourceAccountId("1234567890")
            .destinationAccountId("0987654321")
            .amount(BigDecimal.valueOf(100.00))
            .build();
    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        transactionService = new TransactionServiceImpl( transactionRepository,transactionMapper);
    }


    @Test
    void test_createTransaction_success() {

        when(transactionRepository.save(any())).thenReturn(transaction);
        Optional<TransactionDTO> transactionDTO = transactionService.createTransaction(transactionDto);
        assertNotNull(transactionDTO);
        assertEquals(transactionDto.getTransactionId(), transactionDTO.get().getTransactionId());
    }

    @Test
    void test_getTransactionById_success() {
        when(transactionRepository.findById(any())).thenReturn(Optional.of(transaction));
        Optional<TransactionDTO> transactionDTO = transactionService.getTransactionById(transactionDto.getTransactionId());
        assertNotNull(transactionDTO);
        assertEquals(transactionDto.getTransactionId(), transactionDTO.get().getTransactionId());
    }

    @Test
    void test_getAllTransactions_success() {
        when(transactionRepository.findAll()).thenReturn(List.of(transaction));
        Optional<List<TransactionDTO>> transactionDTO = transactionService.getAllTransactions();
        assertNotNull(transactionDTO);
        assertEquals(transactionDto.getTransactionId(), transactionDTO.get().get(0).getTransactionId());

    }

    @Test
    void test_updateTransaction_success() {
        when(transactionRepository.findById(any())).thenReturn(Optional.of(transaction));

        when(transactionRepository.save(any())).thenReturn(transaction);

        Optional<TransactionDTO> transactionDTOUpdated = transactionService.updateTransaction(transactionDto.getTransactionId(), transactionDto);
        assertNotNull(transactionDTOUpdated);
        assertEquals(transactionDto.getTransactionId(), transactionDTOUpdated.get().getTransactionId());
    }

    @Test
    void test_deleteTransactionById_success() {
        when(transactionRepository.findById(any())).thenReturn(Optional.of(transaction));

        Optional<TransactionDTO> transactionDTOserviced = transactionService.deleteTransactionById(transactionDto.getTransactionId());
        assertNotNull(transactionDTOserviced);
        assertEquals(transactionDto.getTransactionId(), transactionDTOserviced.get().getTransactionId());

    }

    @Test
    void test_getTransactionBySourceAccount_success() {
        when(transactionRepository.findBySourceAccountId(any())).thenReturn(Optional.of(List.of(transaction)));

        Optional<List<TransactionDTO>> transactionDTO = transactionService.getTransactionBySourceAccount(transactionDto.getSourceAccountId());
        assertNotNull(transactionDTO);
        assertEquals(transactionDto.getTransactionId(), transactionDTO.get().get(0).getTransactionId());
    }

    @Test
    void getTransactionByDestinationAccount() {

    }

    @Test
    void getTransactionBySourceAccountAndDestinationAccount() {

    }

    @Test
    void getTransactionByStatus() {

    }

    @Test
    void getTransactionByType() {

    }

    @Test
    void getTransactionByDateAndTime() {

    }

    @Test
    void getTransactionByAmount() {

    }
}