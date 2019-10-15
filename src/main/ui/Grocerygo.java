package ui;

import model.Food;
import model.SortingOptionNotAvailableException;
import model.Store;

import java.io.IOException;
import java.util.Scanner;

public class Grocerygo {
    private Store store;

    public Grocerygo() throws IOException {

        store = new Store();
        store.loadFoodDataBase();
        Food pear = new Food("pear", 1, 200, 300);
        store.insertFood(pear);
        store.loadNonFoodDataBase();
        System.out.println("here's whats in bruce's stores food database");
        store.printListofFood(store.getFoods());
        System.out.println("here's whats in bruce's store's non food database");
        store.printListofNonFood(store.getNonFoods());

    }

    public void startInteraction() {
        while (true) {
            try {
                int number = getNumber();
                System.out.println("you entered " + number);

                if (number == 1) {
                    store.sortPriceFood();
                    store.printListofFood(store.getFoods());
                } else if (number == 0) {
                    System.out.println("you didn't want to sort");
                }
            } catch (SortingOptionNotAvailableException e) {
                System.out.println("you entered a sorting option that is unavailable. Please try again");
                continue;
            } finally {
                System.out.println("we are in an infinite loop so let's do that again!");
            }

        }
    }

    private int getNumber() throws SortingOptionNotAvailableException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number below: would you like to sort Food Items by Price? "
                + "(1 means yes, 0 means no)");
        int numEntered = input.nextInt();
        if (numEntered != 0 && numEntered != 1) {
            throw new SortingOptionNotAvailableException();
        }
        return numEntered;
    }
}
