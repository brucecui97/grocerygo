package model;

import java.util.Objects;

public abstract class Item {
    protected int price;
    protected String name;
    protected Store store;
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

    public String printInfo() {
        return ("* name is " + getName() + " price is " + getPrice() + "\n");
    }

    public void removeStore() {
        if (store != null) {
            Store storePointer = store;
            store = null;
            storePointer.removeFood(this);
            storePointer.removeNonFood(this);

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return price == item.price
                && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }
}
