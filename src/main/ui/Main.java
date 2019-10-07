package ui;

import model.Food;
import model.Store;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Store bruceStore = new Store();
        bruceStore.loadFoodDataBase();
        bruceStore.loadNonFoodDataBase();
        System.out.println("here's whats in bruce's stores food database");
        bruceStore.printListofFood(bruceStore.getFoods());
        System.out.println("here's whats in bruce's stores non database");
        bruceStore.printListofNonFood(bruceStore.getNonFoods());
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number below: would you like to sort Food Items by Price? "
                + "(1 means yes, 0 means no)");
        int number = input.nextInt();
        System.out.println("you entered " + number);


        if (number == 1) {
            bruceStore.sortPriceFood();
            bruceStore.printListofFood(bruceStore.getFoods());
        } else if (number == 0) {
            System.out.println("you didn't want to sort");
        }
    }
}


