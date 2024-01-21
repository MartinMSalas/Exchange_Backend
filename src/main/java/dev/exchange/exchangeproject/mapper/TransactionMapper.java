package dev.exchange.exchangeproject.mapper;

import dev.exchange.exchangeproject.dto.BankAccountDTO;
import dev.exchange.exchangeproject.dto.TransactionDTO;
import dev.exchange.exchangeproject.models.BankAccount;
import dev.exchange.exchangeproject.models.Transaction;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper
public interface TransactionMapper {
    Transaction transactionDtoToTransaction(TransactionDTO transactionDTO);

    TransactionDTO transactionToTransactionDTO(Transaction transaction);

    List<Transaction> transactionDtoListToTransactionList(List<TransactionDTO> transactionDTOList);

    List<TransactionDTO> transactionListToTransactionDtoList(List<Transaction> transactionList);

}

