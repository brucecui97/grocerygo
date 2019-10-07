package model;

public abstract class Item {
    protected int price;
    protected String name;
//
//    public Item(String name, int price) {
//        this.name = name;
//        this.price = price;
//    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void printInfo();
}
