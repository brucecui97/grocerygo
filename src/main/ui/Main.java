package ui;

import model.Food;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Food lettuce = new Food();
        lettuce.setPrice(2);
        lettuce.setCalories(300);
        int weight = 3;
        lettuce.setWeight(weight);
        int weightGotten = lettuce.getWeight();
        System.out.println("weightGotten is " + weightGotten);

        Scanner input = new Scanner(System.in);
        System.out.println("how much would you want lettuce to cost?");
        int number = input.nextInt();
        System.out.println("you really think lettuce should cost " + number + "$?");
        lettuce.setPrice(number);

        if (lettuce.getPrice() > 3) {
            System.out.println("Too expensive");

        } else {
            System.out.println("Great deal");
        }

    }


}