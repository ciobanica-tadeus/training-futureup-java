package ro.zynk.futureup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.zynk.futureup.controllers.responses.ListTransactionResponse;
import ro.zynk.futureup.controllers.responses.TransactionResponse;
import ro.zynk.futureup.domain.dtos.Transaction;
import ro.zynk.futureup.domain.repositories.TransactionRepository;
import ro.zynk.futureup.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public ListTransactionResponse getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();

        List<TransactionResponse> transactionResponses = new ArrayList<>();
        for (Transaction t : transactions) {
            transactionResponses.add(new TransactionResponse(t));
        }

        return new ListTransactionResponse(transactionResponses);
    }

    public ListTransactionResponse getAllTransactionsGreaterThan(Double totalValue)
            throws NotFoundException {
        List<Transaction> transactions = transactionRepository.findAllByTotalValueGreaterThan(totalValue);
        if(transactions.isEmpty()){
            throw new NotFoundException("Transactions greater than totalValue not found!");
        }
        List<TransactionResponse> transactionResponses = new ArrayList<>();
        for(Transaction t: transactions){
            transactionResponses.add(new TransactionResponse(t));
        }

        return new ListTransactionResponse(transactionResponses);
    }
}
