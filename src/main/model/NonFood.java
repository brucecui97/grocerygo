package model;

import java.util.Objects;

public class NonFood extends Item {

    //modifies this, store
    //effect: sets this nonFood item belongs to store, and add this nonFood item to listof nonFood items in store
    public void setStore(Store store) {
        if (this.store != store) {
            this.store = store;
            store.insertNonFood(this);
        }


    }

    public Store getStore() {
        return store;
    }

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
