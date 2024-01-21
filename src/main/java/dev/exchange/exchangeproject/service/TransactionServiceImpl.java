package dev.exchange.exchangeproject.service;

import dev.exchange.exchangeproject.dto.TransactionDTO;
import dev.exchange.exchangeproject.mapper.TransactionMapper;
import dev.exchange.exchangeproject.models.Transaction;
import dev.exchange.exchangeproject.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;



    @Override
    public Optional<TransactionDTO> createTransaction(TransactionDTO transactionDto) {

        Transaction transaction = transactionRepository.save(transactionMapper.transactionDtoToTransaction(transactionDto));




        return Optional.of(transactionMapper.transactionToTransactionDTO(transaction));
    }

    @Override
    public Optional<TransactionDTO> getTransactionById(String id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(transaction.isPresent()){
            TransactionDTO transactionDTO = transactionMapper.transactionToTransactionDTO(transaction.get());
            return Optional.of(transactionDTO);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getAllTransactions() {
        Optional<List<Transaction>> transactions = Optional.of(transactionRepository.findAll());
        if(transactions.isPresent()){
            List<TransactionDTO> transactionDTOS = transactionMapper.transactionListToTransactionDtoList(transactions.get());
            return Optional.of(transactionDTOS);
        }

        return Optional.empty();
    }

    @Override
    public Optional<TransactionDTO> updateTransaction(String transactionId, TransactionDTO transactionDto) {
        Optional<Transaction> transactionOpt = transactionRepository.findById(transactionId);
        if(transactionOpt.isPresent()) {
            Transaction transaction = transactionOpt.get();

            if (transactionDto.getSourceAccountId() != null) {
                transaction.setSourceAccountId(transactionDto.getSourceAccountId());
            }
            if (transactionDto.getDestinationAccountId() != null) {
                transaction.setDestinationAccountId(transactionDto.getDestinationAccountId());
            }
            if (transactionDto.getAmount() != null) {
                transaction.setAmount(transactionDto.getAmount());
            }
            if (transactionDto.getDescription() != null) {
                transaction.setDescription(transactionDto.getDescription());
            }
            if (transactionDto.getStatus() != null) {
                transaction.setStatus(transactionDto.getStatus());
            }
            if (transactionDto.getType() != null) {
                transaction.setType(transactionDto.getType());
            }
            if (transactionDto.getDateAndTime() != null) {
                transaction.setDateAndTime(transactionDto.getDateAndTime());
            }


            TransactionDTO transactionDTO = transactionMapper.transactionToTransactionDTO(transactionRepository.save(transaction));
            return Optional.of(transactionDTO);
        }
        return Optional.empty();
    }

    @Override
    public Optional<TransactionDTO> deleteTransactionById(String transactionId) {
        Optional<Transaction> transactionFound = transactionRepository.findById(transactionId);
        if(transactionFound.isPresent()){
            transactionRepository.delete(transactionFound.get());
            return Optional.of(transactionMapper.transactionToTransactionDTO(transactionFound.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionBySourceAccount(String accountNumber) {

        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionByDestinationAccount(String accountNumber) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionBySourceAccountAndDestinationAccount(String sourceAccountNumber, String destinationAccountNumber) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionByStatus(String status) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionByType(String type) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionByDateAndTime(String dateAndTime) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TransactionDTO>> getTransactionByAmount(BigDecimal amount) {
        return Optional.empty();
    }
}
