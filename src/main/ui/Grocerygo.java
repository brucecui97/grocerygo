package ui;

import model.Food;
import exceptions.SortingOptionNotAvailableException;
import model.Store;

import java.io.IOException;
import java.util.Scanner;

public class Grocerygo {
    private Store store;

    public Grocerygo() throws SortingOptionNotAvailableException {
        while (true) {
            try {
                store = new Store();
                store.loadFoodDataBase("./data/foodData.txt");
                Food pear = new Food("pear", 1, 200, 300);
                store.insertFood(pear);
                store.loadNonFoodDataBase("./data/nonFoodData.txt");
                break;
            } catch (IOException e) {
                System.out.println("make sure your data paths are correct and try again");
                promptEnterKey();
            }
        }

    }

    public void startInteraction()  {
        while (true) {
            try {
                String stringEntered = getString();
                System.out.println("you entered: " + stringEntered);
                store.printListofItem(store.sortFoods(stringEntered));
                store.printListofItem(store.sortNonFoods(stringEntered));

            } catch (SortingOptionNotAvailableException e) {
                System.out.println("you entered a sorting option that is unavailable. Please try again");
                continue;
            } finally {
                System.out.println("we are in an infinite loop so let's do that again!");
            }

        }
    }

    // got from https://stackoverflow.com/questions/26184409/java-console-prompt-for-enter-input-before-moving-on
    private void promptEnterKey() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private String  getString() throws SortingOptionNotAvailableException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how you want to sort foods by");
        String stringEntered = input.nextLine();
        return stringEntered;
    }
}
