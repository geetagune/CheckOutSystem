package com.cdl.checkout.service;

import com.cdl.checkout.model.PricingRule;

import java.util.ArrayList;
import java.util.Map;

public class DiscountService {

    public double calculateDiscount(ArrayList<PricingRule> pricingRuleArray, String scannedItem, double price, Map<String, Integer> scannedItemMap) {
        double discount = 0.0;
        for (PricingRule pricingRule : pricingRuleArray) {
            //check if scanned item has an offer price on it.
            if (pricingRule.getItemName().equals(scannedItem)) {
                int quantity = pricingRule.getQuantity();
                //calculate discount on it
                if (quantity == scannedItemMap.get(scannedItem).intValue()) {
                    double offerPrice = pricingRule.getOfferPrice();
                    double actualPrice = price * quantity;
                    discount = actualPrice - offerPrice;
                    System.out.println("Special price: " + quantity + " " + scannedItem + " for " + offerPrice);
                    scannedItemMap.put(scannedItem, 0);
                }
            }
        }
        return discount;
    }
}
