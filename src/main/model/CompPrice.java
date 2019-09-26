package model;

import java.util.Comparator;

public class CompPrice implements Comparator<Food> {
    @Override
    public int compare(Food o1, Food o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        }
        return -1;
    }
}
