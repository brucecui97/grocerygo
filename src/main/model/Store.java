package model;

import exceptions.SortingOptionNotAvailableException;

import java.io.IOException;
import java.util.*;


public class Store extends Subject {
    //private List<Food> foods = new ArrayList<>();
    // private List<NonFood> nonFoods = new ArrayList<>();
    private Map<Item, Food> foodHashMap = new HashMap<>();
    private Map<Item, NonFood> nonFoodHashMap = new HashMap<>();
    private String name = "default name";
    private ItemSorter itemSorter = new ItemSorter();


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Store store = (Store) o;
        return Objects.equals(name, store.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    //assign name to the store
    public Store(String storename) {
        name = storename;
        Customer joe = new Customer("joe");
        Customer bob = new Customer("bob");
        Customer ken = new Customer("ken");
        attachObserver(joe);
        attachObserver(bob);
        attachObserver(ken);
    }


    public Map<Item, Food> getFoodHashMap() {
        return foodHashMap;
    }

    public Map<Item, NonFood> getNonFoodHashMap() {
        return nonFoodHashMap;
    }

    public void loadFoodDataBase(String path) throws IOException {
        FoodDataBase temp = new FoodDataBase();
        temp.load(path);
        for (Food food : temp.getFoods()) {
            insertFood(food);
        }
    }

    public void saveFoodDataBase(String path) throws IOException {
        FoodDataBase temp = new FoodDataBase();
        temp.setFoods(getFoods());
        temp.save(path);
    }

    public void loadNonFoodDataBase(String path) throws IOException {
        NonFoodDataBase temp = new NonFoodDataBase();
        temp.load(path);
        for (NonFood nonFood : temp.getNonFoods()) {
            insertNonFood(nonFood);
        }
    }

    public void saveNonFoodDataBase(String path) throws IOException {
        NonFoodDataBase temp = new NonFoodDataBase();
        temp.setNonFoods(getNonFoods());
        temp.save(path);
    }


    public String getName() {
        return name;
    }

    //Modfiies this
    //Effect: add specified food to the foods available in the store
    public void insertFood(Food food) {
        if (!foodHashMap.containsKey(food.name)) {
            foodHashMap.put(food, food);
            food.setStore(this);
            notifyObservers(food);
        }
    }

    public void insertNonFood(NonFood nonFood) {
        if (!nonFoodHashMap.containsKey(nonFood)) {
            nonFoodHashMap.put(nonFood, nonFood);
            nonFood.setStore(this);
            notifyObservers(nonFood);
        }
    }

    //Modfiies this
    //Effect: remove specified food to the foods available in the store
    public void removeFood(Item item) {

        if (containsFood(item)) {
            foodHashMap.remove(item);
            item.removeStore();
        }

    }


    //Modfiies this
    //Effect: remove specified nonFood from the list of nonFoods available in the store
    public void removeNonFood(Item item) {
        nonFoodHashMap.remove(item);
        item.removeStore();

    }

    //Effect: determine if foods contains food called foodName
    public boolean containsFood(Item item) {
        return foodHashMap.containsKey(item);
    }

    //Effect: determine if foods contains food called foodName
    public boolean containsNonFood(Item item) {
        return nonFoodHashMap.containsKey(item);
    }

    //effect: get total number of items of food
    public int totalFood() {
        return foodHashMap.size();
    }

    //Return list of food items ranked high to low in price and updates order of foods list
    public List<? extends Item> sortFoods(String sortBy) throws SortingOptionNotAvailableException {
        return itemSorter.sortItems(sortBy, getFoods());
    }

    //Return list of food items ranked high to low in price and updates order of foods list
    public List<? extends Item> sortNonFoods(String sortBy) throws SortingOptionNotAvailableException {
        return itemSorter.sortItems(sortBy, getNonFoods());
    }


    public List<Food> getFoods() {
        List<Food> tempFoods = new ArrayList<>();
        for (Item item : foodHashMap.keySet()) {
            tempFoods.add(foodHashMap.get(item));
        }
        return tempFoods;
    }


    public List<NonFood> getNonFoods() {
        List<NonFood> tempNonFoods = new ArrayList<>();
        for (Item item : nonFoodHashMap.keySet()) {
            tempNonFoods.add(nonFoodHashMap.get(item));
        }
        return tempNonFoods;
    }

    //effect: print the info of each food in foods
    public String printListofItem(List<? extends Item> items) {
        String res = "";
        for (int i = 0; i < items.size(); i++) {
            res = res + items.get(i).printInfo();
        }
        return res;
    }


}
