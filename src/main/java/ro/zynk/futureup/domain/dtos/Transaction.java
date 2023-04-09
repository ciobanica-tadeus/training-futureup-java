package ro.zynk.futureup.domain.dtos;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity{

    @Column
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "coin_id")
    private Coin coin;

    @Column
    private Double amount;

    @Column
    private Double totalValue;

    public Transaction() {

    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


}
