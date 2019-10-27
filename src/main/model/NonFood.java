package model;

import java.util.Objects;

public class NonFood extends Item {
    private Store store;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NonFood nonFood = (NonFood) o;
        return Objects.equals(store, nonFood.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), store);
    }
}
