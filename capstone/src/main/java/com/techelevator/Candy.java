// Candy: Items Type in the Vending Machine that is purchasable
// We must "extend" Candy to the product Class so the item can be purchased. **line7**
// Each itemType must print out display message when dispensing. **line14**
//
package com.techelevator;

public class Candy extends Product{
    public Candy(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void displayMessage() {
        System.out.println("Munch Munch, Yum!");

    }

}
