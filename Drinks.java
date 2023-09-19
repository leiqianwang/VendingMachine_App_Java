// Drinks: Items Type in the Vending Machine that is purchasable
// We must "extend" Chips to the product Class so the item can be purchased. **line7**
// Each itemType must print out display message when dispensing. **line14**
//
package com.techelevator;

public class Drinks extends Product {
        public Drinks(String name, double price, int quantity) {
            super(name, price, quantity);
        }

        @Override
        public void displayMessage() {
            System.out.println("Glug Glug, Yum!");
        }
}
