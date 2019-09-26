package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private List<Food> foods;
    private int openTime;
    private int openHours;
    private String name;

    public Store() {
        foods = new ArrayList<>();
    }

    public Store(String storename) {
        foods = new ArrayList<>();
        name = storename;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public void setOpenHours(int openHours) {
        this.openHours = openHours;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    public int getOpenHours() {
        return openHours;
    }

    public int getOpenTime() {
        return openTime;
    }

    public List<Food> getFoods() {
        return foods;
    }


    //Modfiies this
    //Effect: add specified food to the foods available in the store
    public void insert(Food food) {
        foods.add(food);
    }

    //Modfiies this
    //Effect: remove specified food to the foods available in the store
    public void remove(String foodName) {
    }

    //Effect: determine if foods has food called foodName
    public boolean contains(String foodName) {
        return true;
    }

    //effect: get total number of items of food
    public int total_food() {
        return 0;
    }

    //Produce list of food ranked high to low in calorie/$!!!
    public List<Food> sortDollarPerCalorie() {
        List<Food> result = new ArrayList<>();

        Food dummy = new Food();
        result.add(dummy);
        return result;
    }

    //Produce list of food ranked high to low in price!!!
    public List<Food> sortPrice() {
        List<Food> result = new ArrayList<>();
        ;
        Food dummy = new Food();
        result.add(dummy);
        return result;
    }

    public void printListofFood(List<Food> foods) {
        for (int i = 0; i < foods.size(); i++) {
            foods.get(i).print();
        }
    }

    public void run() {
        Food lettuce = new Food("lettuce", 2, 5, 3);
        Food carrot = new Food("carrot", 3, 10, 5);
        foods.add(lettuce);
        foods.add(carrot);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number below: would you like to sort by 1.$/calorie or 2.Price?");
        int number = input.nextInt();
        System.out.println("you entered " + number);


        if (number == 2) {
            printListofFood(sortPrice());
        } else if (number == 1) {
            printListofFood(sortDollarPerCalorie());
        }

    }


}
