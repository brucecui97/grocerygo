package model;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Food> foods;
    private int openTime;
    private int openHours;

    public Store() {
        foods = new ArrayList<>();
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
    public void remove(Food food) {
        foods.remove(food);
    }

    //Effect: determine if foods has food called foodName
    public boolean contains(String foodName) {
        return true;
    }

    //effect: get total number of items of food
    public int total_food() {
        return 0;
    }

    //Produce list of food ranked high to low in calorie/$
    public List<Food> sortDollarPerCalorie() {
        List<Food> result = new ArrayList<>();
        ;
        Food dummy = new Food();
        result.add(dummy);
        return result;
    }

    //Produce list of food ranked high to low in price
    public List<Food> sortPrice() {
        List<Food> result = new ArrayList<>();
        ;
        Food dummy = new Food();
        result.add(dummy);
        return result;
    }


}
