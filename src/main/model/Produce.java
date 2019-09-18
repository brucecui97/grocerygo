package model;

public class Produce {
    private int price;
    private int calories;
    private int weight;

    public int getPrice(){
        return price;
    }
    public int getcalories(){
        return calories;
    }
    public int getweight(){
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
    public void promote(){
        for (int i=0; i<10;i++){
            System.out.println("Produce is good for you!");
        }

    }
}
