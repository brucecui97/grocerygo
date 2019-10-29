package model;

import exceptions.SortingOptionNotAvailableException;

import java.io.IOException;
import java.util.*;


public class Store {
    private List<Food> foods = new ArrayList<>();
    private List<NonFood> nonFoods = new ArrayList<>();
    private Map<String, Food> foodHashMap = new HashMap<>();
    private Map<String, NonFood> nonFoodHashMap = new HashMap<>();
    private String name;

    public Store() {
        foods = new ArrayList<>();
    }

    //assign name to the store
    public Store(String storename) {
        name = storename;
    }

    public Map<String, Food> getFoodHashMap() {
        return foodHashMap;
    }

    public Map<String, NonFood> getNonFoodHashMap() {
        return nonFoodHashMap;
    }

    public void loadFoodDataBase() throws IOException {
        FoodDataBase temp = new FoodDataBase();
        temp.load("./data/foodData.txt");
        for (Food food : temp.getFoods()) {
            insertFood(food);
        }


    }

    public void loadNonFoodDataBase() throws IOException {
        NonFoodDataBase temp = new NonFoodDataBase();
        temp.load("./data/nonFoodData.txt");
        for (NonFood nonFood : temp.getNonFoods()) {
            insertNonFood(nonFood);
        }
    }


    public List<NonFood> getNonFoods() {
        return nonFoods;
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
        if (!foods.contains(food)) {
            foods.add(food);
            foodHashMap.put(food.name, food);
            food.setStore(this);
        }
    }

    public void insertNonFood(NonFood nonFood) {
        if (!nonFoods.contains(nonFood)) {
            nonFoods.add(nonFood);
            nonFoodHashMap.put(nonFood.name, nonFood);
            nonFood.setStore(this);
        }
    }

    //Modfiies this
    //Effect: remove specified food to the foods available in the store
    public void removeFood(String foodName) {
        for (Food food : foods) {
            if (food.getName() == foodName) {
                foods.remove(food);
                foodHashMap.remove(food.name);
                return;
            }
        }
    }

    //Modfiies this
    //Effect: remove specified nonFood from the list of nonFoods available in the store
    public void removeNonFood(String nonFoodName) {
        for (NonFood nonFood : nonFoods) {
            if (nonFood.getName() == nonFoodName) {
                nonFoods.remove(nonFood);
                nonFoodHashMap.remove(nonFood.name);
                return;
            }
        }
    }

    //Effect: determine if foods contains food called foodName
    public boolean containsFood(String foodName) {
        return foodHashMap.containsKey(foodName);
    }

    //effect: get total number of items of food
    public int totalFood() {
        return foods.size();
    }


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
