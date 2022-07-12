package com.cdl.checkout.service;

import com.cdl.checkout.model.PricingRule;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class PricingRuleService {

    public void displayPricingRule(ArrayList<PricingRule> pricingRuleArray) {
        // fetch and display existing pricing rules
        for (PricingRule pr : pricingRuleArray) {
            System.out.println("Special price: " + pr.getQuantity() + " " + pr.getItemName() + " for " + pr.getOfferPrice());
        }
    }

    public void modifyPricingRule(ArrayList<PricingRule> pricingRuleArray, PricingRule newPricingRule) {
        Optional<PricingRule> optionalPricingRule = pricingRuleArray.stream()
                .filter(s -> s.getItemName().equals(newPricingRule.getItemName())).findFirst();
        if (optionalPricingRule.isEmpty()) {
            //Add new item offers
            pricingRuleArray.add(newPricingRule);
        } else {
            //update the quantity and offer price for existing item offer
            pricingRuleArray.stream().filter(s -> s.getItemName().equals(newPricingRule.getItemName()))
                    .forEach(i -> {
                        i.setQuantity(newPricingRule.getQuantity());
                        i.setOfferPrice(newPricingRule.getOfferPrice());
                    });
        }
    }

    public void alterPricingRules(Scanner itemScanner, ArrayList<PricingRule> pricingRuleArray) {
        System.out.println("Enter new/update rule/offer: ");
        System.out.println("Item Name: ");
        String itemName = itemScanner.next();
        System.out.println("Item Quantity: ");
        int itemQuantity = itemScanner.nextInt();
        System.out.println("Offer Price: ");
        double itemOfferPrice = itemScanner.nextDouble();
        PricingRule newPricingRule = new PricingRule(itemName, itemQuantity, itemOfferPrice);
        modifyPricingRule(pricingRuleArray, newPricingRule);
        System.out.println("Continue to add/modify pricing rules (y/n)? ");

    }
}
