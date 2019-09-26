package model;

public class Food {
    private int price;
    private int calories;
    private int weight;
    private String name;

    public Food() {
    }

    public Food(String name, int price, int calories, int weight) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
        this.price = price;
    }


    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("name is " + getName() + " weight is " + getWeight()
                + " calorie is " + getCalories() + " price is " + getPrice());

    }

    //determines whether this is equal to other
    public boolean equals(Food other) {
        if (name == other.getName()
                && price == other.getPrice()
                && calories == other.getCalories()
                && weight == other.getWeight()) {
            return true;
        }
        return false;
    }

}
