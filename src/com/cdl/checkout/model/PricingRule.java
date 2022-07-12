package com.cdl.checkout.model;

public class PricingRule {
    private String itemName;
    private int quantity;
    private double offerPrice;

    public PricingRule(String itemName, int quantity, double offerPrice) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.offerPrice = offerPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    @Override
    public String toString() {
        return "PricingRule{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", offerPrice=" + offerPrice +
                '}';
    }
}
