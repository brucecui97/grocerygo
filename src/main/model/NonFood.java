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
        System.out.println("name is " + getName() + " price is " + getPrice());
    }

}
