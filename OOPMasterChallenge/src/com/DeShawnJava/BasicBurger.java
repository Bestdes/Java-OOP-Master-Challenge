package com.DeShawnJava;

public class BasicBurger {

    private String addOn1, addOn2, addOn3, addOn4;
    private double addOn1Price, addOn2Price, addOn3Price, addOn4Price;
    private String breadRollType;
    private String meatType;
    private double meatPrice;
    private double lettucePrice = .50;
    private double tomatoPrice = .50;
    private double picklePrice = .75;
    private double onionPrice = .50;
    private double totalPrice;
    private int addOnItemTracker;
    private int wrongAddOnCount;

    public BasicBurger(String breadRollType, String meatType, double meatPrice) {
        this.breadRollType = breadRollType;
        this.meatType = meatType;
        this.meatPrice = meatPrice;
        this.totalPrice = meatPrice;
    }

    public void selectAddOns(String addOnType) {

        if (addOnItemTracker < 4) {
            if (addOnType.equalsIgnoreCase("Lettuce") || addOnType.equalsIgnoreCase("Tomato") || addOnType.equalsIgnoreCase("Pickles") || addOnType.equalsIgnoreCase("Onions")) {
                if (addOnItemTracker == 0) {
                    this.addOn1 = addOnType;
                    if (addOnType.equalsIgnoreCase("Lettuce")) {
                        this.addOn1Price = lettucePrice;
                    }
                    if (addOnType.equalsIgnoreCase("Tomato")) {
                        this.addOn1Price = tomatoPrice;
                    }
                    if (addOnType.equalsIgnoreCase("Pickles")) {
                        this.addOn1Price = picklePrice;
                    }
                    if (addOnType.equalsIgnoreCase("Onions")) {
                        this.addOn1Price = onionPrice;
                    }
                }
                if (addOnItemTracker == 1) {
                    this.addOn2 = addOnType;
                    if (addOnType.equalsIgnoreCase("Lettuce")) {
                        this.addOn2Price = lettucePrice;
                    }
                    if (addOnType.equalsIgnoreCase("Tomato")) {
                        this.addOn2Price = tomatoPrice;
                    }
                    if (addOnType.equalsIgnoreCase("Pickles")) {
                        this.addOn2Price = picklePrice;
                    }
                    if (addOnType.equalsIgnoreCase("Onions")) {
                        this.addOn2Price = onionPrice;
                    }
                }
                if (addOnItemTracker == 2) {
                    this.addOn3 = addOnType;
                    if (addOnType.equalsIgnoreCase("Lettuce")) {
                        this.addOn3Price = lettucePrice;
                    }
                    if (addOnType.equalsIgnoreCase("Tomato")) {
                        this.addOn3Price = tomatoPrice;
                    }
                    if (addOnType.equalsIgnoreCase("Pickles")) {
                        this.addOn3Price = picklePrice;
                    }
                    if (addOnType.equalsIgnoreCase("Onions")) {
                        this.addOn3Price = onionPrice;
                    }
                }
                if (addOnItemTracker == 3) {
                    this.addOn4 = addOnType;
                    if (addOnType.equalsIgnoreCase("Lettuce")) {
                        this.addOn4Price = lettucePrice;
                    }
                    if (addOnType.equalsIgnoreCase("Tomato")) {
                        this.addOn4Price = tomatoPrice;
                    }
                    if (addOnType.equalsIgnoreCase("Pickles")) {
                        this.addOn4Price = picklePrice;
                    }
                    if (addOnType.equalsIgnoreCase("Onions")) {
                        this.addOn4Price = onionPrice;
                    }
                    System.out.println("You have reach the maximum amount of add-ons");
                }
                this.addOnItemTracker++;
                System.out.println("You have selected " + addOnType + " as your # " + addOnItemTracker + " add-on.");
                this.totalPrice = meatPrice + addOn1Price + addOn2Price + addOn3Price + addOn4Price;
            } else {
                System.out.println("You have selected an a response that does not indicate an ingredient that we have!");
                System.out.println("Our add-ons include: Onions, Pickles, Lettuce, and Tomato!");
                wrongAddOnCount++;
            }
        }
    }

    public void clearOrder(){
        this.addOnItemTracker = 0;
        this.addOn1 = "null";
        this.addOn2 = "null";
        this.addOn3 = "null";
        this.addOn4 = "null";
        this.addOn1Price = 0;
        this.addOn2Price = 0;
        this.addOn3Price = 0;
        this.addOn4Price = 0;
        this.totalPrice = 0;
        System.out.println("-----------------Ready to initiate new order!------------");
    }

    public void printReceipt() {
        System.out.println("This order of consist of a " + getClass().getSimpleName() + ".");
        System.out.println("Additional Items are:");
        System.out.println(addOn1 + " = " + addOn1Price);
        System.out.println(addOn2 + " = " + addOn2Price);
        System.out.println(addOn3 + " = " + addOn3Price);
        System.out.println(addOn4 + " = " + addOn4Price);
        System.out.println("The total order comes to the amount of : " + getTotalPrice());
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getAddOnItemTracker() {
        return addOnItemTracker;
    }

    public int getWrongAddOnCount() {
        return wrongAddOnCount;
    }
}
