package com.DeShawnJava;

import java.util.Scanner;

public class Main {

    private static String determinedMeat; // This is the field that allow one static method (determineMeatPrice) to use the output of another (selectMeat), I question if this is good practice.
    private static int tryCountBurger; // This is the counter that tracks how many incorrect responses user has input

    public static void main(String[] args) {

        orderBurger();

    }

    public static void orderBurger() {  // This method that executes the order and pulls everything together

        boolean orderComplete = false; // This variable confirms if order is complete and is used as a conditional
        boolean orderTerminate = false; // This variable confirms if order should terminate and is used as a conditional

        while (!tooManyInvalidResponses() && orderTerminate == false) {

            Scanner orderInput = new Scanner(System.in); // Primary scanner input object creation

            System.out.println("What would you like to order today?");
            String selectBurger = orderInput.nextLine();

            if (selectBurger.equalsIgnoreCase("Basic Burger")) {

                /*
                The following codes is the object creation of the parent class of all Burger classes with the methods
                passed in as parameters.
                 */

                BasicBurger basicBurger = new BasicBurger(selectBread(), selectMeat(), determineMeatPrice());

                if (tooManyInvalidResponses() == true) { // This is a check to see if too many invalid responses were passed in
                    break;
                }

                /*
                The following code begins the process of ordering add-ons for the burger
                 */

                System.out.println("What would you like to put on your burger?");
                String addOnInput = orderInput.nextLine();

                while (!addOnInput.equals("nothing")) {
                    if (basicBurger.getWrongAddOnCount() >= 4) { // The following code handles invalid inputs for selecting add-ons and breaks the loop
                        tryCountBurger = 5;
                        break;
                    }
                    if (basicBurger.getAddOnItemTracker() >= 4) { // The following code handles the limit of valid inputs for selecting add-ons and breaks the loop
                        break;
                    }
                    if (addOnInput.equals("nothing")) { // The following codes is handles the string that can be passed in to break the loop when necessary
                        break;
                    }
                    basicBurger.selectAddOns(addOnInput); // This is the call to the selectAddOns() method that does the work (selects add-ons)
                    if (basicBurger.getAddOnItemTracker() < 4) {
                        System.out.println("What else would you like to put on your burger?");
                        System.out.println("If done with add-ons, type \"nothing\".");
                        addOnInput = orderInput.nextLine();
                    }
                }

                if (tooManyInvalidResponses() == true) { // This is a check to see if too many invalid responses were passed in
                    break;
                }

                System.out.println("Would you like a receipt?");
                String printInput = orderInput.nextLine();

                if (!printInput.equalsIgnoreCase("no")) {
                    basicBurger.printReceipt(); // This is the call to the printReceipt() method that does the work (prints order details)
                }
                orderComplete = true;
                orderTerminate = true;
            }

            if (selectBurger.equalsIgnoreCase("Healthy Burger")) {

                /*
                The following codes is the object creation of the child class of the BasicBurger class with the methods
                passed in as parameters. Notice the selectBread() is not passed in and there is not parameter space for it
                 */

                HealthyBurger healthyBurger = new HealthyBurger(selectMeat(), determineMeatPrice());

                if (tooManyInvalidResponses() == true) {
                    break;
                }

                System.out.println("What would you like to put on your burger?");
                String addOnInput = orderInput.nextLine();

                while (!addOnInput.equals("nothing")) {
                    if (healthyBurger.getWrongAddOnCount() >= 4) {
                        tryCountBurger = 5;
                        break;
                    }
                    if (healthyBurger.getAddOnItemTracker() >= 4) {
                        break;
                    }
                    if (addOnInput.equals("nothing")) {
                        break;
                    }
                    healthyBurger.selectAddOns(addOnInput);
                    if (healthyBurger.getAddOnItemTracker() < 4) {
                        System.out.println("What else would you like to put on your burger?");
                        System.out.println("If done with add-ons, type \"nothing\".");
                        addOnInput = orderInput.nextLine();
                    }
                }

                if (tooManyInvalidResponses() == true) {
                    break;
                }

                System.out.println("Would you like a receipt?");
                String printInput = orderInput.nextLine();

                if (printInput.equalsIgnoreCase("yes")) {
                    healthyBurger.printReceipt();
                }
                orderComplete = true;
                orderTerminate = true;
            }
            if (selectBurger.equalsIgnoreCase("Deluxe Burger")) {

                /*
                The following codes is the object creation of the child class of the BasicBurger class with the methods
                passed in as parameters. Notice this section of codes doesn't execute a call to any selectAddOns() method.
                 */

                DeluxeBurger deluxeBurger = new DeluxeBurger(selectBread(), selectMeat(), determineMeatPrice());

                if (tooManyInvalidResponses() == true) {
                    break;
                }

                deluxeBurger.makeDeluxeCombo(); // This burger class doesn't allow the selection of add-ons and instead simply makes a Burger Combo

                if (tooManyInvalidResponses() == true) {
                    break;
                }

                System.out.println("Would you like a receipt?");
                String printInput = orderInput.nextLine();

                if (printInput.equalsIgnoreCase("yes")) {
                    deluxeBurger.printReceipt();
                }
                orderComplete = true;
                orderTerminate = true;
            }
            else { // This section of codes handles invalid response given for burger type
                if (!tooManyInvalidResponses() && orderComplete == false) {
                    System.out.println("You have chosen a burger that we do not have!");
                    System.out.println("Please select either a \"Basic Burger\", a \"Healthy Burger\", or a \"Deluxe Burger\"!");
                    tryCountBurger++;
                    orderBurger();
                } else if (tooManyInvalidResponses() && orderComplete == false) { // This handles when too many invalid inputs are given and terminates the program
                    System.out.println("Too many invalid response. Try again later!");
                    orderInput.close();
                } else {
                    System.out.println("Thank you for visiting The Great Burger!!!");
                    orderInput.close();
                }
            }
        }
        if (orderTerminate == false) {
            System.out.println("Too many invalid responses!");
            System.out.println("Try to order again.");
        }
    }

    public static String selectBread() { // This method selects the breadType
        Scanner breadInput = new Scanner(System.in);
        System.out.println("What kind of bun would you like for you burger?");
        String breadChoice = breadInput.nextLine();
        if (breadChoice.equalsIgnoreCase("potato") ||
                (breadChoice.equalsIgnoreCase("sesame seed") ||
                        (breadChoice.equalsIgnoreCase("rye") ||
                                (breadChoice.equalsIgnoreCase("onion") ||
                                        (breadChoice.equalsIgnoreCase("kaiser")))))){
           return breadChoice;
        }
        else { // The following code handles invalid inputs for selecting breadTypes
            System.out.println("Sorry we don't have that bun type, Please select from this list:");
            System.out.println("Potato, Sesame Seed, Rye, Onion, Kaiser");
            tryCountBurger++; // Updates counter for invalid inputs
            if(tooManyInvalidResponses()){
                breadChoice = "No valid response given!";
                return breadChoice;
            }
            selectBread();
        }
        return breadChoice;
    }

    public static String selectMeat() { // This method selects the meatType and update the determinedMeat field
        Scanner meatInput = new Scanner(System.in);
        System.out.println("What kind of meat would you like for you burger?");
        String meatChoice = meatInput.nextLine();
        if (meatChoice.equalsIgnoreCase("beef") ||
                (meatChoice.equalsIgnoreCase("spicy beef") ||
                        (meatChoice.equalsIgnoreCase("jalapeno beef") ||
                                (meatChoice.equalsIgnoreCase("chicken") ||
                                        (meatChoice.equalsIgnoreCase("spicy chicken") ||
                                                (meatChoice.equalsIgnoreCase("Vegetarian"))))))) {
            determinedMeat = meatChoice;
            return meatChoice;
        }
        else { // The following code handles invalid inputs for selecting meatTypes
            System.out.println("Sorry we don't have that meat type, Please select from this list:");
            System.out.println("Beef, Spicy Beef, Jalapeno Beef, Chicken, Spicy Chicken, Vegetarian");
            tryCountBurger++; // Updates counter for invalid inputs
            if(tooManyInvalidResponses()){
                determinedMeat = "No valid response given!";
                return determinedMeat;
            }
            selectMeat();

        }
        return meatChoice;
    }

    public static double determineMeatPrice() { // This methods outputs the price for the meatChoice that was passed in by the determinedMeat field
        double meatChoicePrice = 0;

        String priceCheck = determinedMeat;

        if (priceCheck.equalsIgnoreCase("No valid response given!")){
            meatChoicePrice = -1;
        }
        else if(priceCheck.equalsIgnoreCase("vegetarian")){
            meatChoicePrice = 2.85;
        }
        else if (priceCheck.equalsIgnoreCase("beef")){
            meatChoicePrice = 2;
        }
        else if (priceCheck.equalsIgnoreCase("spicy beef")) {
            meatChoicePrice = 2.25;
        }
        else if (priceCheck.equalsIgnoreCase("jalapeno beef")) {
            meatChoicePrice = 2.5;
        }
        else if (priceCheck.equalsIgnoreCase("chicken")) {
            meatChoicePrice = 2.5;
        }
        else if (priceCheck.equalsIgnoreCase("spicy chicken")) {
            meatChoicePrice = 2.75;
        }
        else {
            meatChoicePrice = 2.0;
        }
        return meatChoicePrice;
    }

    public static boolean tooManyInvalidResponses() { // This method is a conditional that checks if too many invalid responses were given
        if (tryCountBurger >= 5) {
            return true;
        }
        else{
            return false;
        }
    }
}
