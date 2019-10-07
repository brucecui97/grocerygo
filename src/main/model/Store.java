package model;

import java.io.IOException;
import java.util.*;


public class Store {
    private List<Food> foods;
    private String name;

    public Store() {
        foods = new ArrayList<>();
    }

    //assign name to the store
    public Store(String storename) {
        foods = new ArrayList<>();
        name = storename;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }


    public List<Food> getFoods() {
        return foods;
    }

    public String getName() {
        return name;
    }

    //Modfiies this
    //Effect: add specified food to the foods available in the store
    public void insert(Food food) {
        foods.add(food);
    }

    //Modfiies this
    //Effect: remove specified food to the foods available in the store
    public void remove(String foodName) {
        for (Food food : foods) {
            if (food.getName() == foodName) {
                foods.remove(food);
                return;
            }
        }
    }

    //Effect: determine if foods has food called foodName
    public boolean contains(String foodName) {
        for (Food food : foods) {
            if (food.getName() == foodName) {
                return true;
            }

        }
        return false;

    }

    //effect: get total number of items of food
    public int total_food() {
        return foods.size();
    }

//    //modifies this
//    //Produce list of food ranked high to low in calorie/$ and updates order of foods list
//    public List<Food> sortDollarPerCalorie() {
//        List<Food> result = new ArrayList<>();
//
//        Food dummy = new Food();
//        result.add(dummy);
//        return result;
//    }

    //modifies this
    //Produce list of food ranked high to low in price and updates order of foods list
    public List<Food> sortPrice() {
        Comparator<Food> comp = new CompPrice();
        Collections.sort(foods, comp);
        return (foods);
    }

    //effect: print the info of each food in foods
    public void printListofFood(List<Food> foods) {
        for (int i = 0; i < foods.size(); i++) {
            foods.get(i).print();
        }
    }

    // modifies: this
    // effect: adds some food to the foods list and asks user how they want to sort the list
    public void run() throws IOException, ClassNotFoundException {
        FoodDataBase myFoodDataBase = new FoodDataBase();


        Food pineapple = new Food("pineapple", 2, 3, 5);
        Food pear = new Food("pear", 10, 5, 8);
        Food apple = new Food("apple", 10, 5, 8);
        myFoodDataBase.insert(pineapple);
        myFoodDataBase.insert(pear);
        myFoodDataBase.insert(apple);

        myFoodDataBase.save();

        FoodDataBase temp = new FoodDataBase();
        System.out.println("initially foods is empty, but we load from dataBase");
        temp.load();
        System.out.println(temp.getFoods().get(0).getName());
        System.out.println(temp.getFoods().get(1).getName());
        System.out.println(temp.getFoods().get(2).getName());

    }


}
