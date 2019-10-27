package model;

import exceptions.SortingOptionNotAvailableException;

import java.io.IOException;
import java.util.*;


public class Store {
    private List<Food> foods;
    private List<NonFood> nonFoods;
    private String name;

    public Store() {
        foods = new ArrayList<>();
    }

    //assign name to the store
    public Store(String storename) {
        foods = new ArrayList<>();
        name = storename;
    }

    public void loadFoodDataBase() throws IOException {
        FoodDataBase temp = new FoodDataBase();
        temp.load("./data/foodData.txt");
        foods = temp.getFoods();
    }

    public void loadNonFoodDataBase() throws IOException {
        NonFoodDataBase temp = new NonFoodDataBase();
        temp.load("./data/nonFoodData.txt");
        nonFoods = temp.getNonFoods();
    }

    public void setNonFoods(List<NonFood> nonFoods) {
        this.nonFoods = nonFoods;
    }

    public List<NonFood> getNonFoods() {
        return nonFoods;
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
    public void insertFood(Food food) {
        foods.add(food);
    }

    //Modfiies this
    //Effect: remove specified food to the foods available in the store
    public void removeFood(String foodName) {
        for (Food food : foods) {
            if (food.getName() == foodName) {
                foods.remove(food);
                return;
            }
        }
    }

    //Effect: determine if foods contains food called foodName
    public boolean containsFood(String foodName) {
        for (Food food : foods) {
            if (food.getName() == foodName) {
                return true;
            }

        }
        return false;

    }

    //effect: get total number of items of food
    public int totalFood() {
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
    public List<Food> sortFoods(String sortBy) throws SortingOptionNotAvailableException {
        if (sortBy.equals("price")) {
            Comparator<Food> comp = new CompPrice();
            Collections.sort(foods, comp);
            return (foods);
        } else {
            throw new SortingOptionNotAvailableException();
        }
    }

    //effect: print the info of each food in foods
    public void printListofFood(List<Food> foods) {
        for (int i = 0; i < foods.size(); i++) {
            foods.get(i).printInfo();
        }
    }

    //effect: print the info of each food in foods
    public void printListofNonFood(List<NonFood> nonFoods) {
        for (int i = 0; i < nonFoods.size(); i++) {
            nonFoods.get(i).printInfo();
        }
    }


}
