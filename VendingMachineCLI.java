package com.techelevator;


import com.techelevator.view.Menu;

import java.io.*;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
//
// VendingMachineCLI = Vending Machine Command Line Interface
// The main area of processing for the Vending Machine
//
public class VendingMachineCLI {


    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";      // Menu Option 1
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";                                // Menu Option 2
    private static final String EXIT_MAIN_MENU_OPTION = "Exit";                                        // Menu Option 3
    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, EXIT_MAIN_MENU_OPTION };
    private static final String FEED_MONEY_OPTION = "Feed Money";                                      // Insertion of Moneny Option
    private static final String BUY_OPTION = "Select Product";                                         // Buying of Product Option
    private static final String END_TRANSACTION = "Finish Transaction";                                // End Transaction Option
    private static final String []PURCHASE_MENU_OPTION = {FEED_MONEY_OPTION, BUY_OPTION, END_TRANSACTION};

    Scanner input = new Scanner(System.in);
    VendingMachine vendingMachine = new VendingMachine();

    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
        vendingMachine.establishInventory();
    }

    public void run ()throws NumberFormatException {
            System.out.println("*****************************************");
            System.out.println("    WELCOME TO THE DURAN & YINGYING'S     ");
            System.out.println("            VENDING MACHINE    ");
            System.out.println("    WE GOT THE SWEETEST CANDY IN TOWN     ");
            System.out.println("*****************************************");

        while (true) {

            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS) || choice.equals("1")) {
                DisplayMenuItem(vendingMachine);
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                mainMenuOptionPurchase();
            } else if (choice.equals(EXIT_MAIN_MENU_OPTION) || choice.equals("3")) {
                System.exit(1);
            }
        }
    }

    private void mainMenuOptionPurchase() { // Purchase Options feeding money, finishing the transaction
        System.out.println("*****************************************");
        String select = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTION);
        System.out.println("*****************************************");
        if (select.equals(FEED_MONEY_OPTION) || select.equals("1")) {
            System.out.println("Enter amount to feed");
            double amount = input.nextDouble();
            input.nextLine();
            vendingMachine.feedMoney(amount);
            System.out.println("*****************************************");
        } else if (select.equals(BUY_OPTION) || select.equals("2")) {
            purchaseOption();
        } else if (select.equals("Finish Transaction") || select.equals("3")) {
            vendingMachine.change();
        }
    }

    private void purchaseOption() {  // Purchase Options, selection of product
        DisplayMenuItem(vendingMachine);
        System.out.println("Select a product");
        String productId = input.nextLine();
        System.out.println("*****************************************");
        if (vendingMachine.getItems().containsKey(productId)){
            if(vendingMachine.getItems().get(productId).getItems_quantity() >= 1){
                if(vendingMachine.getBalance() >= vendingMachine.getItems().get(productId).getPrice()){
                    vendingMachine.purchaseValidation(productId);
                }else{
                    System.out.println("Not enough money");
                }
            }else {
                System.out.println(vendingMachine.getItems().get(productId).getName()+" is sold out, I'm Sorry" );
            }
        } else {
            System.out.println("This product does not exist");
        }
    }

    private void DisplayMenuItem(VendingMachine vendingMachine) {
        for (Map.Entry<String, Product> item : vendingMachine.getItems().entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue().getName() + " " + item.getValue().getPrice()+" | "+item.getValue().getItems_quantity());
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();


    }
}