package com.cdl.checkout.model;

public class ItemDetails {

    private double unitPrice;
    private String currency;

    public ItemDetails(double unitPrice, String currency) {
        this.unitPrice = unitPrice;
        this.currency = currency;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
