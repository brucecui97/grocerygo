package model;


import java.util.Objects;

public class Food extends Item {
    private int calories;
    private int weight;
    private Store store;

    public Food() {
    }


    //modifies this
    // effect: populate this with info
    public Food(String name, int price, int calories, int weight) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public int getWeight() {
        return weight;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    //effect: print info related to this food item
    @Override
    public void printInfo() {
        System.out.println("name is " + getName() + " weight is " + getWeight()
                + " calorie is " + getCalories() + " price is " + getPrice());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return (calories == food.calories
                && weight == food.weight
                && Objects.equals(store, food.store)
                && price == food.price
                && name == food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calories, weight, store, price, name);
    }

//    //effect: determines whether two foods are equal
//    public boolean equals(Food other) {
//        if (name == other.getName()
//                && price == other.getPrice()
//                && calories == other.getCalories()
//                && weight == other.getWeight()) {
//            return true;
//        }
//        return false;
//    }

}
