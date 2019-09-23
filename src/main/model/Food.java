package model;

public class Food {
    private int price;
    private int calories;
    private int weight;
    private String name;

    public Food() {

    }

    public Food(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getCalories() {
        return calories;
    }

    public int getWeight() {
        return weight;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
