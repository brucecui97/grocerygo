package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    List<ItemObserver> observers = new ArrayList<>();


    public void attachObserver(ItemObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void detachObserver(ItemObserver observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }

    }

    public void notifyObservers(Item item) {
        for (ItemObserver itemObserver : observers) {
            itemObserver.update(item);
        }
    }
}

