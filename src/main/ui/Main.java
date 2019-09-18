package ui;

import model.Produce;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Produce lettuce = new Produce();
        lettuce.promote();
        lettuce.setPrice(2);
        lettuce.setCalories(300);
        lettuce.setWeight(3);

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