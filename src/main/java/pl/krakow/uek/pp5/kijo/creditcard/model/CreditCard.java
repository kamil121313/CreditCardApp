package pl.krakow.uek.pp5.kijo.creditcard.model;

import pl.krakow.uek.pp5.kijo.creditcard.model.exceptions.CreditBelowMinimumException;

import java.math.BigDecimal;

public class CreditCard {
    private String cardNumber;
    private BigDecimal creditLimit;
    private String slogan;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }



    public void assignLimit(BigDecimal newLimit) {
        if (BigDecimal.valueOf(100).compareTo(newLimit) == 1){
            throw new CreditBelowMinimumException();
        }

        creditLimit = newLimit;
    }


    public BigDecimal getLimit() {
        return creditLimit;
    }

    public void withDraw(BigDecimal money) {
    }

    public BigDecimal currentBalance() {
        return null;

    }
}
