package com.DeShawnJava;

public class DeluxeBurger extends BasicBurger {

    private String deluxeCombo = "Potato Chips and a Drink";
    private double deluxeComboAddOnPrice = 1.5;
    private double deluxeBurgerBasePrice;
    private double totalDeluxeComboPrice;

    public DeluxeBurger(String breadRollType, String meatType, double meatPrice) {
        super(breadRollType, meatType, meatPrice);
        this.deluxeBurgerBasePrice = meatPrice;
    }

    public void makeDeluxeCombo() {
        System.out.println("Your Deluxe Burger is made as a combo and comes with " + deluxeCombo + ".");
        this.totalDeluxeComboPrice = deluxeComboAddOnPrice + (deluxeBurgerBasePrice * 2);
        System.out.println(deluxeBurgerBasePrice);
        setTotalPrice(totalDeluxeComboPrice);
    }

    @Override
    public void printReceipt() {
        super.printReceipt();
    }

    @Override
    public void setTotalPrice(double totalPrice) {
        super.setTotalPrice(totalPrice);
    }
}
