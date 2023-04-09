package ro.zynk.futureup.controllers;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.zynk.futureup.controllers.responses.BaseResponse;
import ro.zynk.futureup.controllers.responses.ErrorResponse;
import ro.zynk.futureup.controllers.responses.ListTransactionResponse;
import ro.zynk.futureup.exceptions.NotFoundException;
import ro.zynk.futureup.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/get_all_transactions")
    public ResponseEntity<BaseResponse> getAllTransactions() {
        try {
            return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // Test with /get_all_transactions_greater_than?amountOfUsd=...
    @GetMapping("/get_all_transactions_greater_than")
    @ResponseBody
    public ResponseEntity<BaseResponse> getAllTransactionsGreaterThan(
            @RequestParam Double amountOfUsd
    ) {
        try{
            return new ResponseEntity<>(transactionService.getAllTransactionsGreaterThan(amountOfUsd),HttpStatus.OK);
        }catch (NotFoundException e){
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
