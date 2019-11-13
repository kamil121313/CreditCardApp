package pl.krakow.uek.pp5.kijo.creditcard.model;

import pl.krakow.uek.pp5.kijo.creditcard.model.exceptions.CreditBelowMinimumException;
import pl.krakow.uek.pp5.kijo.creditcard.model.exceptions.NotEnoughMoneyException;

import java.math.BigDecimal;

class CreditCard {
    private String cardNumber;
    private BigDecimal creditLimit;
    private String slogan;
    private BigDecimal cardBalance;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void assignLimit(BigDecimal newLimit) {
        if (BigDecimal.valueOf(100).compareTo(newLimit) == 1) {
            throw new CreditBelowMinimumException();
        }

        creditLimit = newLimit;
        cardBalance = creditLimit;
    }

    public BigDecimal getLimit() {
        return creditLimit;
    }

    public void withdraw(BigDecimal money) {
        if (currentBalance().compareTo(money) == -1) {
            throw new NotEnoughMoneyException();
        }

        cardBalance = cardBalance.subtract(money);
    }

    public BigDecimal currentBalance() {
        return cardBalance;
    }
}