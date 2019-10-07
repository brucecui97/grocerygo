package model;

public class NonFood extends Item {

    public NonFood() {
    }

    //modifies this
    // effect: populate this with info
    public NonFood(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void printInfo() {
        System.out.println("I don't know currently how to print my info");
    }
}
