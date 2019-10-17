package test_grocerygo;


import model.Food;
import model.SortingOptionNotAvailableException;
import model.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Unit tests for IntegerSet
public class TestStore {
    Store mystore;
    Food carrot;
    Food apple;

    @BeforeEach
    public void runBefore() {

        mystore = new Store();
        carrot = new Food("carrot", 2, 3, 5);
        apple = new Food("apple", 10, 5, 8);
    }

    //!!! test constructor
    @Test
    public void testStore() {

        Store tempStore = new Store("bruce store");
        assertEquals("bruce store", tempStore.getName());
    }

    @Test
    public void testInsertEmpty() {
        assertEquals(0, mystore.total_food());
        Food carrot = new Food();
        mystore.insertFood(carrot);
        assertEquals(1, mystore.total_food());
    }

    @Test
    public void testInsertNonEmpty() {
        assertEquals(0, mystore.total_food());
        Food carrot = new Food();
        mystore.insertFood(carrot);
        mystore.insertFood(carrot);
        assertEquals(2, mystore.total_food());
    }

    @Test
    public void testRemoveEmpty() {
        Food carrot = new Food();
        mystore.removeFood("carrot");
        assertEquals(0, mystore.total_food());
    }

    @Test
    public void testRemoveNoDuplicates() {

        mystore.insertFood(apple);
        mystore.insertFood(carrot);
        assertTrue(mystore.containsFood("carrot"));
        mystore.removeFood("carrot");
        assertFalse(mystore.containsFood("carrot"));
    }

    @Test
    public void testRemoveYesDuplicates() {
        mystore.insertFood(carrot);
        mystore.insertFood(carrot);
        mystore.insertFood(apple);
        assertTrue(mystore.containsFood("carrot"));
        mystore.removeFood("carrot");
        assertTrue(mystore.containsFood("carrot"));
        mystore.removeFood("carrot");
        assertFalse(mystore.containsFood("carrot"));
        assertEquals(1, mystore.total_food());
    }

    @Test
    public void testEmptyContains() {
        assertFalse(mystore.containsFood("pineapple"));
    }

    @Test
    public void testNonEmptyContains() {
        mystore.insertFood(carrot);
        mystore.insertFood(apple);
        assertTrue(mystore.containsFood("carrot"));
        assertTrue(mystore.containsFood("apple"));
        assertFalse(mystore.containsFood("pear"));
    }

    @Test
    public void testTotalFoodEmpty() {
        assertEquals(0, mystore.total_food());
    }

    @Test
    public void testTotalFoodNonEmpty() {
        mystore.insertFood(carrot);
        mystore.insertFood(apple);
        assertEquals(2, mystore.total_food());
        mystore.removeFood("carrot");
        assertEquals(1, mystore.total_food());
    }

    @Test
    public void testPriceEmpty() {
        try {
            mystore.sortFoods("price");
            assertTrue(mystore.getFoods().isEmpty());
        } catch (SortingOptionNotAvailableException e) {
            assertTrue(false);

        }
    }

    @Test //!!!
    public void testSortPriceNonEmpty() {
        Food lettuce = new Food("lettuce", 2, 5, 3);
        Food carrot = new Food("carrot", 3, 10, 5);
        Food apple = new Food("apple", 7, 20, 10);
        mystore.insertFood(lettuce);
        mystore.insertFood(apple);
        mystore.insertFood(carrot);
        try {
            mystore.sortFoods("price");
        } catch (SortingOptionNotAvailableException e) {
            assertTrue(false);
        }
        List<Food> temp = new ArrayList<Food>();
        temp.add(lettuce);
        temp.add(carrot);
        temp.add(apple);


        for (int i = 0; i < mystore.getFoods().size(); i++) {
            assertTrue(mystore.getFoods().get(i).equals(temp.get(i)));
        }


    }

    @Test
    public void testSortNotImplementedThrowSortingOptionNotAvailableException() {
        try {
            mystore.sortFoods("NotImplmentedSortingOption");
            assertTrue(false);
        } catch (SortingOptionNotAvailableException e) {

        }
    }
//    @Test
//    public void testSortDollarPerCalorieEmpty() {
//        assertEquals(mystore.sortDollarPerCalorie(), Collections.<Food> emptyList());
//
//    }
//    @Test
//    public void testSortDollarPerCalorieNonEmpty() {
//
//
//    }

}

