package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestNonFood {
    NonFood nonFood;

    @BeforeEach
    public void runBefore() {
        nonFood = new NonFood("fork",5);
    }

    @Test
    public void testFood(){
        NonFood fork = new NonFood();
        fork.setName("fork");
        fork.setPrice(5);
        assertEquals(fork.getPrice(),nonFood.getPrice());
        assertEquals(fork.getName(),nonFood.getName());
    }

    @Test
    public void testEqualsShouldBeTrue(){
        NonFood fork = new NonFood();
        fork.setName("fork");
        fork.setPrice(5);
        assertTrue(fork.equals(nonFood));
    }

    @Test
    public void testEqualsShouldBeFalse(){
        NonFood fork = new NonFood();
        fork.setName("fo2rk");
        fork.setPrice(5);
        assertFalse(fork.equals(nonFood));
    }

    @Test
    public void testSetStore(){
        Store testStore = new Store();
        nonFood.setStore(testStore);
        assertEquals(nonFood.getStore(),testStore);
        assertTrue(testStore.getNonFoods().contains(nonFood));

    }

}
