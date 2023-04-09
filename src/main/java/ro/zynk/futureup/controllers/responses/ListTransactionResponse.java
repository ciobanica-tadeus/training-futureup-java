package ro.zynk.futureup.controllers.responses;

import java.util.List;

public class ListTransactionResponse extends BaseResponse{
    private List<TransactionResponse> transactionResponseList;

    public ListTransactionResponse(List<TransactionResponse> transactionResponseList) {
        this.transactionResponseList = transactionResponseList;
    }

    public List<TransactionResponse> getTransactionResponseList() {
        return transactionResponseList;
    }

    public void setTransactionResponseList(List<TransactionResponse> transactionResponseList) {
        this.transactionResponseList = transactionResponseList;
    }
}
