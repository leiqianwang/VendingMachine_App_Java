package com.techelevator.view;

import org.junit.Assert;
import com.techelevator.VendingMachine;
import org.junit.Test;

public class VendingMachineTest {

    VendingMachine m = new VendingMachine();

    @Test
    public void whenChangeIsGiven_ShouldSetBalanceToZero(){
        m.feedMoney(5);
        m.change();
        Assert.assertEquals(0, m.getBalance(), 0.1);
    }

    @Test
    public void giveLessThanZeroDollars_BalanceShouldNotIncrease(){
        m.feedMoney(-10);
        Assert.assertEquals(0, m.getBalance(), 0.1);
    }

    @Test
    public void giveMoreThanZeroDollars_BalanceShouldIncrease(){
        m.feedMoney(10);
        Assert.assertEquals(10, m.getBalance(), 0.1);
    }

}

