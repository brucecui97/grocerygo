package model;


import model.Food;
import exceptions.SortingOptionNotAvailableException;
import model.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for IntegerSet
public class TestStore {
    Store mystore;
    Food carrot;
    Food apple;
    NonFood fork;
    NonFood knife;

    @BeforeEach
    public void runBefore() {

        mystore = new Store();
        carrot = new Food("carrot", 2, 3, 5);
        apple = new Food("apple", 10, 5, 8);
        fork = new NonFood("fork", 5);
        knife = new NonFood("knife", 8);

    }

    //!!! test constructor
    @Test
    public void testStore() {

        Store tempStore = new Store("bruce store");
        assertEquals("bruce store", tempStore.getName());
    }

    @Test
    public void testInsertEmpty() {
        assertEquals(0, mystore.totalFood());
        Food carrot = new Food();
        mystore.insertFood(carrot);
        assertEquals(1, mystore.totalFood());
    }


    @Test
    public void testRemoveEmpty() {
        Food carrot = new Food();
        mystore.removeFood(carrot);
        assertEquals(0, mystore.totalFood());
    }

    @Test
    public void testRemoveNoDuplicates() {

        mystore.insertFood(apple);
        mystore.insertFood(carrot);
        assertTrue(mystore.containsFood(carrot));
        mystore.removeFood(carrot);
        assertFalse(mystore.containsFood(carrot));
    }

    @Test
    public void testEmptyContains() {
        Item pineapple = new Food("pineapple",5,2,3);
        assertFalse(mystore.containsFood(pineapple));
    }

    @Test
    public void testNonEmptyContains() {
        mystore.insertFood(carrot);
        mystore.insertFood(apple);
        assertTrue(mystore.containsFood(carrot));
        assertTrue(mystore.containsFood(apple));

    }

    @Test
    public void testTotalFoodEmpty() {
        assertEquals(0, mystore.totalFood());
    }

    @Test
    public void testTotalFoodNonEmpty() {
        mystore.insertFood(carrot);
        mystore.insertFood(apple);
        assertEquals(2, mystore.totalFood());
        mystore.removeFood(carrot);
        assertEquals(1, mystore.totalFood());
    }

    @Test
    public void testPriceEmpty() {
        try {
            mystore.sortFoods("price");
            assertEquals(mystore.getFoodHashMap().size(), 0);
        } catch (SortingOptionNotAvailableException e) {
            fail("should not have caught SortingOptionNotAvailableException");

        }
    }

    @Test //!!!
    public void testSortPriceNonEmpty() {
        Food lettuce = new Food("lettuce", 2, 5, 3);
        Food carrot = new Food("carrot", 3, 10, 5);
        Food apple = new Food("apple", 7, 20, 10);
        List<Food> sortedFoods = new ArrayList<>();
        mystore.insertFood(lettuce);
        mystore.insertFood(apple);
        mystore.insertFood(carrot);
        try {
            sortedFoods = mystore.sortFoods("price");
        } catch (SortingOptionNotAvailableException e) {
            fail("should not have caught SortingOptionNotAvailableException");
        }
        List<Food> temp = new ArrayList<Food>();
        temp.add(lettuce);
        temp.add(carrot);
        temp.add(apple);

        for (int i = 0; i < sortedFoods.size(); i++) {
            assertTrue(sortedFoods.get(i).equals(temp.get(i)));
        }


    }

    @Test
    public void testSortNotImplementedThrowSortingOptionNotAvailableException() {
        try {
            mystore.sortFoods("NotImplmentedSortingOption");
            fail("exception was not thrown but was expected");
        } catch (SortingOptionNotAvailableException e) {

        }
    }

    @Test
    public void insertFoodEmptyListAndMapContainAdded() {
        mystore.insertFood(carrot);
        assertTrue(mystore.getFoodHashMap().containsKey(carrot));
        assertTrue(mystore.getFoodHashMap().containsKey(carrot));

    }

    @Test
    public void removeFoodListAndMapBothRemoved() {
        mystore.insertFood(carrot);
        mystore.insertFood(apple);
        assertTrue(mystore.getFoodHashMap().containsKey(apple));
        assertTrue(mystore.getFoodHashMap().containsKey(carrot));

        mystore.removeFood(carrot);
        assertFalse(mystore.containsFood(carrot));

    }






}

