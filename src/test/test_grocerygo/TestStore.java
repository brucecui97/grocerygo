package test_grocerygo;


import model.Food;
import model.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Unit tests for IntegerSet
public class TestStore {

    @BeforeEach
    public void runBefore() {
        Store mystore = new Store();
    }

    @Test
    public void testInsertEmpty() {
        assertEquals(0, mystore.total_food());
        Food carrot = new Food();
        mystore.insert(carrot);
        assertEquals(1,mystore.total_food());
    }




}

