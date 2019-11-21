package model;


public class Food extends Item {
    private int calories;
    private int weight;

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
    public String printInfo() {
        return super.printInfo()
                + "additonal information: weight is " + getWeight() + " calorie is " + getCalories() + "\n";
    }


    public void setStore(Store store) {
        if (this.store != store) {
            this.store = store;
            store.insertFood(this);
        }
    }


    public Store getStore() {
        return store;
    }


}
