package com.cdl.checkout.test;

import com.cdl.checkout.service.DiscountService;
import com.cdl.checkout.model.PricingRule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class DiscountServiceTest {

    @Test
    public void checkDiscountGiven() {
        ArrayList<PricingRule> pricingRuleArray = new ArrayList<PricingRule>();
        pricingRuleArray.add(new PricingRule("B", 2, 3.00));
        pricingRuleArray.add(new PricingRule("C", 2, 5.00));
        String scannedItem = "B";
        double price = 2.0;
        Map<String, Integer> scannedItemMap = new HashMap<String, Integer>();
        //set value of 2 to denote the 2nd B item
        scannedItemMap.put(scannedItem, 2);
        DiscountService discountStrategy = new DiscountService();
        double discount = discountStrategy.calculateDiscount(pricingRuleArray, scannedItem, price, scannedItemMap);
        assertTrue(discount == 1);
    }

    @Test
    public void checkDiscountNotGiven() {
        ArrayList<PricingRule> pricingRuleArray = new ArrayList<PricingRule>();
        pricingRuleArray.add(new PricingRule("B", 2, 3.00));
        pricingRuleArray.add(new PricingRule("C", 2, 5.00));
        String scannedItem = "B";
        double price = 2.0;
        Map<String, Integer> scannedItemMap = new HashMap<String, Integer>();
        //set value of 2 to denote the 1st B item
        scannedItemMap.put(scannedItem, 1);
        DiscountService discountStrategy = new DiscountService();
        double discount = discountStrategy.calculateDiscount(pricingRuleArray, scannedItem, price, scannedItemMap);
        assertTrue(discount == 0);
    }
}
