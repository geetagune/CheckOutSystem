package com.cdl.checkout.main;

import com.cdl.checkout.model.ItemDetails;
import com.cdl.checkout.model.PricingRule;
import com.cdl.checkout.service.DataGeneratorService;
import com.cdl.checkout.service.DiscountService;
import com.cdl.checkout.service.PricingRuleService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Checkout {
    private static String scannedItem = "";
    private static String keepShopping = "y";
    private static String alterPricingRules = "y";
    private static double price = 0.0;
    private static String currency = "";
    private static double runningTotal = 0.0;

    public static void main(String[] args) {

        DiscountService discountService = new DiscountService();
        DataGeneratorService dataGeneratorService = new DataGeneratorService();
        PricingRuleService pricingRuleService = new PricingRuleService();
        ArrayList<PricingRule> pricingRuleArray = new ArrayList<PricingRule>();
        Scanner itemScanner = new Scanner(System.in);
        Map<String, Integer> scannedItemMap = new HashMap<String, Integer>();

        //set up the existing pricing rules
        dataGeneratorService.populatePricingRules(pricingRuleArray);

        System.out.println("Welcome to Checkout System");
        System.out.println("The current pricing rules/offers are as below:");

        // fetch and display existing pricing rules
        pricingRuleService.displayPricingRule(pricingRuleArray);

        System.out.println("Do you want to add/modify pricing rules (y/n)? ");

        do {
            alterPricingRules = itemScanner.next();

            //if input is 'n' for Add/Modify pricing rules (y/n)? then break else continue
            if (alterPricingRules.equals("n")) {
                break;
            } else {
                pricingRuleService.alterPricingRules(itemScanner, pricingRuleArray);
                continue;
            }
        } while (alterPricingRules.equalsIgnoreCase("y"));

        //populate items available for shopping
        Map<String, ItemDetails> itemMap = dataGeneratorService.populateItems();


        System.out.println("Now scan items in your shopping basket: ");
        do {
            System.out.print("Enter the name of the item: ");
            int i = 0;
            scannedItem = itemScanner.next();

            //check if scanned item exists in our Items list
            if (!itemMap.containsKey(scannedItem)) {
                System.out.println("Incorrect Item scanned. Please check.");
            } else {
                price = itemMap.get(scannedItem).getUnitPrice();
                currency = itemMap.get(scannedItem).getCurrency();

                if (scannedItemMap.containsKey(scannedItem)) {
                    i = scannedItemMap.get(scannedItem).intValue();
                }

                System.out.println("Item: " + scannedItem + " Price: " + price);
                scannedItemMap.put(scannedItem, i + 1);
                double discount = discountService.calculateDiscount(pricingRuleArray, scannedItem, price, scannedItemMap);
                runningTotal += price - discount;
                System.out.println("Current Total = " + runningTotal + " " + currency);


            }
            //check if user wants to continue shopping
            System.out.print("Continue shopping (y/n)? ");
            keepShopping = itemScanner.next();

            //Ask 'Continue shopping (y/n)?' till input is Y or N
            ContinueShopping(keepShopping, itemScanner);

        } while (keepShopping.equalsIgnoreCase("y"));  //end of while
        System.out.println("Final Total: " + runningTotal + " " + currency);

    }

    public static void ContinueShopping(String keepShopping, Scanner itemScanner) {
        if (!(keepShopping.equalsIgnoreCase("y") || keepShopping.equalsIgnoreCase("n"))) {
            while (!keepShopping.equalsIgnoreCase("y")) {
                System.out.print("Continue shopping (y/n)? ");
                keepShopping = itemScanner.next();
                continue;
            }
        }
    }
}
