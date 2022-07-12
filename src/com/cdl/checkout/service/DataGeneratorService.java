package com.cdl.checkout.service;

import com.cdl.checkout.model.ItemDetails;
import com.cdl.checkout.model.PricingRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataGeneratorService {

    public void populatePricingRules(ArrayList<PricingRule> pricingRuleArray) {
        pricingRuleArray.add(new PricingRule("A", 3, 130.00));
        pricingRuleArray.add(new PricingRule("B", 2, 45.00));
    }

    public Map<String, ItemDetails> populateItems() {
        Map<String, ItemDetails> itemMap = new HashMap<String, ItemDetails>();
        itemMap.put("A", new ItemDetails(50.00, "pence"));
        itemMap.put("B", new ItemDetails(30.00, "pence"));
        itemMap.put("C", new ItemDetails(20.00, "pence"));
        itemMap.put("D", new ItemDetails(15.00, "pence"));
        return itemMap;
    }
}
