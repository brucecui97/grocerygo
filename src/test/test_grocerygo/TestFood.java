package test_grocerygo;


import model.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Unit tests for IntegerSet
public class TestFood {
    Food myfood;

    @BeforeEach
    public void runBefore() {
        myfood = new Food("carrot",5,2,1000);
    }

    @Test
    public void testFood(){
        Food rawCarrot = new Food();
        rawCarrot.setName("carrot");
        rawCarrot.setCalories(2);
        rawCarrot.setWeight(1000);
        rawCarrot.setPrice(5);
        assertEquals(rawCarrot.getPrice(),myfood.getPrice());
        assertEquals(rawCarrot.getWeight(),myfood.getWeight());
        assertEquals(rawCarrot.getCalories(),myfood.getCalories());
        assertEquals(rawCarrot.getName(),myfood.getName());
    }

    @Test
    public void testEqualsShouldBeTrue(){
        Food carrot = new Food("carrot",5,2,1000);
        assertTrue(myfood.equals(carrot));
    }

    @Test
    public void testEqualsShouldBeFalse(){
        Food carrot = new Food("carrot",6,2,1000);
        assertFalse(myfood.equals(carrot));
    }

    @Test
    public void testEqualsShouldBeFalseWithUnitialized(){
        Food carrot = new Food();
        assertFalse(myfood.equals(carrot));
    }




}

