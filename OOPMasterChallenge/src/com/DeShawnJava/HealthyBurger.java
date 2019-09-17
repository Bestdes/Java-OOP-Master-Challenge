package com.DeShawnJava;

public class HealthyBurger extends BasicBurger {

    private String healthyAddOn1;
    private String healthyAddOn2;
    private double healthyAddOn1Price;
    private double healthyAddOn2Price;
    private double healthySaucePrice = 0.75;
    private double healthyCheesePrice = 1.0;
    private int healthyAddOnTracker;
    private double healthyBurgerTotal;

    public HealthyBurger(double meatPrice) {
        super("Brown Rye", "Vegetarian", meatPrice);
        this.healthyBurgerTotal = meatPrice;
    }

    public HealthyBurger(String meatType, double meatPrice) {
        super("Brown Rye", meatType, meatPrice);
    }

    @Override
    public int getAddOnItemTracker() {
        return super.getAddOnItemTracker();
    }

    @Override
    public void selectAddOns(String addOnType) {
        if (getAddOnItemTracker() + this.healthyAddOnTracker < 6) {
            if (addOnType.equalsIgnoreCase("Healthy Sauce") || addOnType.equalsIgnoreCase("Healthy Cheese")) {
                if (healthyAddOnTracker == 0) {
                    if (addOnType.equalsIgnoreCase("Healthy Sauce")) {
                        this.healthyAddOn1Price = this.healthySaucePrice;
                        this.healthyAddOn1 = "Healthy Sauce";
                    }
                    if (addOnType.equalsIgnoreCase("Healthy Cheese")) {
                        this.healthyAddOn1Price = this.healthyCheesePrice;
                        this.healthyAddOn1 = "Healthy Cheese";
                    }
                }
                if (healthyAddOnTracker == 1) {
                    if (addOnType.equalsIgnoreCase("Healthy Sauce")) {
                        this.healthyAddOn2Price = this.healthySaucePrice;
                        this.healthyAddOn2 = "Healthy Sauce";
                    }
                    if (addOnType.equalsIgnoreCase("Healthy Cheese")) {
                        this.healthyAddOn2Price = this.healthyCheesePrice;
                        this.healthyAddOn2 = "Healthy Cheese";
                    }
                    System.out.println("You have reach the maximum amount of specialty add-ons");
                }
                this.healthyAddOnTracker++;
                System.out.println("You have selected " + addOnType + " as your # " + healthyAddOnTracker + " specialty add-on.");
            }
            else {
                super.selectAddOns(addOnType);
                if (this.healthyAddOnTracker < 2) {
                    System.out.println("Remember you can also select specialty add-ons for this burger: Healthy Sauce and Healthy Cheese!");
                }
            }
        }
    }

    @Override
    public void clearOrder() {
        this.healthyAddOn1 = "null";
        this.healthyAddOn2 = "null";
        this.healthyAddOn1Price = 0;
        this.healthyAddOn2Price = 0;
        this.healthyAddOnTracker = 0;
        super.clearOrder();
    }

    @Override
    public void printReceipt() {
        System.out.println("Specialty Burger add-ons include :");
        System.out.println(healthyAddOn1 + " = " + healthyAddOn1Price);
        System.out.println(healthyAddOn2 + " = " + healthyAddOn2Price);
        setTotalPrice(healthyBurgerTotal);
        super.printReceipt();
    }

    @Override
    public void setTotalPrice(double totalPrice) {
        totalPrice = healthyBurgerTotal + healthyAddOn1Price + healthyAddOn2Price + super.getTotalPrice();
        super.setTotalPrice(totalPrice);
    }

    @Override
    public double getTotalPrice() {
        return super.getTotalPrice();
    }

}
