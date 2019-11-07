package model;

import exceptions.SortingOptionNotAvailableException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ItemSorter {


    public List<? extends Item> sortItems(String sortBy, List<? extends Item> items)
            throws SortingOptionNotAvailableException {

        if (sortBy.equals("price")) {
            Comparator<Item> comp = new CompPrice();
            Collections.sort(items, comp);
            return items;
        } else {
            throw new SortingOptionNotAvailableException();
        }
    }


}