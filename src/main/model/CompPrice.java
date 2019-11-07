package model;

import java.util.Comparator;

public class CompPrice implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        }
        return -1;
    }
}
