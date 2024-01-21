package dev.exchange.exchangeproject.mapper;

import dev.exchange.exchangeproject.dto.TransactionDTO;
import dev.exchange.exchangeproject.models.Transaction;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-21T18:48:01-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction transactionDtoToTransaction(TransactionDTO transactionDTO) {
        if ( transactionDTO == null ) {
            return null;
        }

        Transaction.TransactionBuilder transaction = Transaction.builder();

        transaction.transactionId( transactionDTO.getTransactionId() );
        transaction.dateAndTime( transactionDTO.getDateAndTime() );
        transaction.type( transactionDTO.getType() );
        transaction.amount( transactionDTO.getAmount() );
        transaction.description( transactionDTO.getDescription() );
        transaction.sourceAccountId( transactionDTO.getSourceAccountId() );
        transaction.destinationAccountId( transactionDTO.getDestinationAccountId() );
        transaction.status( transactionDTO.getStatus() );

        return transaction.build();
    }

    @Override
    public TransactionDTO transactionToTransactionDTO(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionDTO.TransactionDTOBuilder transactionDTO = TransactionDTO.builder();

        transactionDTO.transactionId( transaction.getTransactionId() );
        transactionDTO.dateAndTime( transaction.getDateAndTime() );
        transactionDTO.type( transaction.getType() );
        transactionDTO.amount( transaction.getAmount() );
        transactionDTO.description( transaction.getDescription() );
        transactionDTO.sourceAccountId( transaction.getSourceAccountId() );
        transactionDTO.destinationAccountId( transaction.getDestinationAccountId() );
        transactionDTO.status( transaction.getStatus() );

        return transactionDTO.build();
    }

    @Override
    public List<Transaction> transactionDtoListToTransactionList(List<TransactionDTO> transactionDTOList) {
        if ( transactionDTOList == null ) {
            return null;
        }

        List<Transaction> list = new ArrayList<Transaction>( transactionDTOList.size() );
        for ( TransactionDTO transactionDTO : transactionDTOList ) {
            list.add( transactionDtoToTransaction( transactionDTO ) );
        }

        return list;
    }

    @Override
    public List<TransactionDTO> transactionListToTransactionDtoList(List<Transaction> transactionList) {
        if ( transactionList == null ) {
            return null;
        }

        List<TransactionDTO> list = new ArrayList<TransactionDTO>( transactionList.size() );
        for ( Transaction transaction : transactionList ) {
            list.add( transactionToTransactionDTO( transaction ) );
        }

        return list;
    }
}
