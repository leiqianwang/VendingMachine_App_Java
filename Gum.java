// Gum: Items Type in the Vending Machine that is purchasable
// We must "extend" Gum to the product Class so the item can be purchased. **line8**
// Each itemType must print out display message when dispensing. **line15**
//

package com.techelevator;

public class Gum extends Product{

    public Gum(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void displayMessage() {
        System.out.println("Chew Chew, Yum!");


    }

}


