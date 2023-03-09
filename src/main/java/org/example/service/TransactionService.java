package org.example.service;


import org.example.dto.Transaction;
import org.example.enums.TransactionType;
import org.example.repository.TransactionRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class TransactionService {
    public TransactionService() {
    }

    private TransactionRepository transactionRepository;
    public void createTransaction(Integer cardId, Integer terminalId, Double amount, TransactionType type) {
        Transaction transaction = new Transaction();
        transaction.setCardId(cardId);
        transaction.setTerminalId(terminalId);
        transaction.setAmount(amount);
        transaction.setTransactionType(type);
        transaction.setCreatedDate(LocalDateTime.now());


        transactionRepository.createTransaction(transaction);
    }
}
