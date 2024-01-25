package dev.exchange.exchangeproject.mapper;

import dev.exchange.exchangeproject.dto.TransactionDTO;
import dev.exchange.exchangeproject.models.Transaction;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-23T17:15:07-0600",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240103-0614, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction transactionDtoToTransaction(TransactionDTO transactionDTO) {
        if ( transactionDTO == null ) {
            return null;
        }

        Transaction.TransactionBuilder transaction = Transaction.builder();

        transaction.amount( transactionDTO.getAmount() );
        transaction.dateAndTime( transactionDTO.getDateAndTime() );
        transaction.description( transactionDTO.getDescription() );
        transaction.destinationAccountId( transactionDTO.getDestinationAccountId() );
        transaction.sourceAccountId( transactionDTO.getSourceAccountId() );
        transaction.status( transactionDTO.getStatus() );
        transaction.transactionId( transactionDTO.getTransactionId() );
        transaction.type( transactionDTO.getType() );

        return transaction.build();
    }

    @Override
    public TransactionDTO transactionToTransactionDTO(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionDTO.TransactionDTOBuilder transactionDTO = TransactionDTO.builder();

        transactionDTO.amount( transaction.getAmount() );
        transactionDTO.dateAndTime( transaction.getDateAndTime() );
        transactionDTO.description( transaction.getDescription() );
        transactionDTO.destinationAccountId( transaction.getDestinationAccountId() );
        transactionDTO.sourceAccountId( transaction.getSourceAccountId() );
        transactionDTO.status( transaction.getStatus() );
        transactionDTO.transactionId( transaction.getTransactionId() );
        transactionDTO.type( transaction.getType() );

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
