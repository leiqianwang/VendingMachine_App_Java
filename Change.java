package com.techelevator;
//
//
//
public class Change {
    private int dimes;
    private int nickles;
    private int quarters;
    private double totalChange;


    public Change(double moneyOwed){
        this.totalChange = moneyOwed;
    }

    public void calculateChange() {
        int totalChangeInPennies =(int)(this.totalChange * 100);
        this.quarters = totalChangeInPennies / 25;
        totalChangeInPennies -= this.quarters * 25;
        this.dimes = totalChangeInPennies / 10;
        totalChangeInPennies -= this.dimes * 10;
        this.nickles = totalChangeInPennies/ 5;
        totalChangeInPennies -= this.nickles * 5;

    }

    @Override
    public String toString(){
        return "quarters: " + quarters + "dimes " + dimes + "nickels " + nickles;
    }
}
