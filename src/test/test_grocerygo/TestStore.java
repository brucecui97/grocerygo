package test_grocerygo;


import model.Food;
import model.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

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
        carrot = new Food("carrot",2,3,5);
        apple = new Food("apple",10,5,8);
    }

    //!!! test constructor

    @Test
    public void testInsertEmpty() {
        assertEquals(0, mystore.total_food());
        Food carrot = new Food();
        mystore.insert(carrot);
        assertEquals(1, mystore.total_food());
    }

    @Test
    public void testInsertNonEmpty() {
        assertEquals(0, mystore.total_food());
        Food carrot = new Food();
        mystore.insert(carrot);
        mystore.insert(carrot);
        assertEquals(2, mystore.total_food());
    }

    @Test
    public void testRemoveEmpty() {
        Food carrot = new Food();
        mystore.remove("carrot");
        assertEquals(0, mystore.total_food());
    }

    @Test
    public void testRemoveNoDuplicates() {

        mystore.insert(apple);
        mystore.insert(carrot);
        assertTrue(mystore.contains("carrot"));
        mystore.remove("carrot");
        assertFalse(mystore.contains("carrot"));
    }

    @Test
    public void testRemoveYesDuplicates() {
        mystore.insert(carrot);
        mystore.insert(carrot);
        mystore.insert(apple);
        assertTrue(mystore.contains("carrot"));
        mystore.remove("carrot");
        assertTrue(mystore.contains("carrot"));
        mystore.remove("carrot");
        assertFalse(mystore.contains("carrot"));
        assertEquals(1, mystore.total_food());
    }

    @Test
    public void testEmptyContains() {
        assertFalse(mystore.contains("pineapple"));
    }

    @Test
    public void testNonEmptyContains() {
        mystore.insert(carrot);
        mystore.insert(apple);
        assertTrue(mystore.contains("carrot"));
        assertTrue(mystore.contains("apple"));
        assertFalse(mystore.contains("pear"));
    }

    @Test
    public void testTotalFoodEmpty() {
        assertEquals(0, mystore.total_food());
    }

    @Test
    public void testTotalFoodNonEmpty() {
        mystore.insert(carrot);
        mystore.insert(apple);
        assertEquals(2, mystore.total_food());
        mystore.remove("carrot");
        assertEquals(1, mystore.total_food());
    }
    @Test
    public void testSortDollarPerCalorieEmpty() {
        assertEquals(mystore.sortDollarPerCalorie(), Collections.<Food> emptyList());

    }
    @Test
    public void testSortDollarPerCalorieNonEmpty() {

//        Food carrot = new Food("carrot");
//        carrot.setPrice(5);
//        carrot.setCalories(10);
//        Food apple = new Food("apple");
//        apple.setPrice(10);
//        apple.setCalories(1000);
//        mystore.insert(carrot);
//        mystore.insert(apple);

    }

}

