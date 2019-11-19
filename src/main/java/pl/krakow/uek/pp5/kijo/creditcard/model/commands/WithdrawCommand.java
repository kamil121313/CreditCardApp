package pl.krakow.uek.pp5.kijo.creditcard.model.commands;

import java.math.BigDecimal;

public class WithdrawCommand {
    private final String creditCardNumber;
    private final BigDecimal withdrawValue;

    public WithdrawCommand(String creditCardNumber, BigDecimal withdrawValue){
        this.creditCardNumber = creditCardNumber;
        this.withdrawValue = withdrawValue;
    }

    public String getCreditCardNumber(){
        return creditCardNumber;
    }

    public BigDecimal getWithdrawValue(){
        return withdrawValue;
    }
}
