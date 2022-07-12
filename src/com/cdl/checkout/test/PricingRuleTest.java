package com.cdl.checkout.test;

import com.cdl.checkout.model.PricingRule;
import com.cdl.checkout.service.PricingRuleService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PricingRuleTest {
    PricingRuleService pricingRuleService;

    @Test
    public void checkAddNewPricingRule() {
        ArrayList<PricingRule> pricingRuleArray = new ArrayList<PricingRule>();
        pricingRuleArray.add(new PricingRule("B", 2, 3.00));
        pricingRuleService = new PricingRuleService();
        PricingRule newPricingRule = new PricingRule("A", 2, 1.5);

        pricingRuleService.modifyPricingRule(pricingRuleArray, newPricingRule);
        assertTrue(pricingRuleArray.contains(newPricingRule));
    }

    @Test
    public void checkUpdateExistingPricingRule() {
        ArrayList<PricingRule> pricingRuleArray = new ArrayList<PricingRule>();
        pricingRuleArray.add(new PricingRule("B", 2, 3.00));
        pricingRuleArray.add(new PricingRule("C", 2, 6.00));

        pricingRuleService = new PricingRuleService();
        PricingRule newPricingRule = new PricingRule("B", 3, 5);

        pricingRuleService.modifyPricingRule(pricingRuleArray, newPricingRule);

        List<PricingRule> filteredPricingRule = pricingRuleArray.stream()
                .filter(s -> s.getItemName().equals(newPricingRule.getItemName())).collect(Collectors.toList());
        filteredPricingRule.forEach(s -> {
            assertEquals(s.getOfferPrice(), 5);
            assertEquals(s.getQuantity(), 3);
        });


    }

}
