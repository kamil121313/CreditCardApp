package pl.krakow.uek.pp5.kijo.creditcard.model;

import org.junit.Assert;
import org.junit.Test;
import pl.krakow.uek.pp5.kijo.creditcard.model.exceptions.CreditBelowMinimumException;
import pl.krakow.uek.pp5.kijo.creditcard.model.exceptions.NotEnoughMoneyException;

import java.math.BigDecimal;

public class CreditCardTest {
    private static final int NEW_CARD_LIMIT = 2000;

    @Test
    public void itAllowsAssignLimitToCreditCard(){
        //Arrange //Given
        CreditCard creditCard = new CreditCard("1234-5678");
        //Act //When
        creditCard.assignLimit(BigDecimal.valueOf(NEW_CARD_LIMIT));
        //Assert //Then //Expect
        Assert.assertTrue(creditCard.getLimit().equals(BigDecimal.valueOf(NEW_CARD_LIMIT)));

    }

    @Test
    public void itVerifyMinimumCreditValue(){

        CreditCard card = new CreditCard("1234-1244");

        try {
            card.assignLimit(BigDecimal.valueOf(50));
            Assert.fail("Exception should be thrown");
        } catch (CreditBelowMinimumException e){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void foo(){
        CreditCard card = new CreditCard("1234-1242");
        card.assignLimit(BigDecimal.valueOf(100));
        Assert.assertTrue(card.getLimit().equals(BigDecimal.valueOf(100)));
    }

    @Test
    public void withdrawFromCard(){
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5678");
        card1.assignLimit(BigDecimal.valueOf(1000));
        card2.assignLimit(BigDecimal.valueOf(1000));
        card1.withdraw(BigDecimal.valueOf(500));
        card2.withdraw(BigDecimal.valueOf(200));
        Assert.assertEquals(card1.currentBalance(), BigDecimal.valueOf(500));
        Assert.assertEquals(card2.currentBalance(), BigDecimal.valueOf(800));
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void denyWithdrawBelowCurrentBalance() {
        CreditCard card = new CreditCard("1234-5678");
        card.assignLimit((BigDecimal.valueOf(1000)));
        card.withdraw(BigDecimal.valueOf(600));
        card.withdraw(BigDecimal.valueOf(600));
    }
}
