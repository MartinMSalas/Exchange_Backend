package dev.exchange.exchangeproject.repository;

import dev.exchange.exchangeproject.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Optional<List<Transaction>> findBySourceAccountId(String sourceAccountId);
    Optional<List<Transaction>> findByDestinationAccountId(String destinationAccountId);
}
