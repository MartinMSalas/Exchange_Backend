package dev.exchange.exchangeproject.repository;

import dev.exchange.exchangeproject.models.Transaction;
import dev.exchange.exchangeproject.models.enums.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Optional<List<Transaction>> findBySourceAccountId(String sourceAccountId);
    Optional<List<Transaction>> findByDestinationAccountId(String destinationAccountId);

    Optional<List<Transaction>> findBySourceAccountIdAndDestinationAccountId(String sourceAccountId, String destinationAccountId);

    Optional<List<Transaction>> findByStatus(TransactionStatus status);
}
