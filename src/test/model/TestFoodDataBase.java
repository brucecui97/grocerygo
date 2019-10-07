package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestFoodDataBase {
    Food carrot;
    Food apple;
    FoodDataBase myFoodDataBase = new FoodDataBase();

    @BeforeEach
    public void runBefore() {
        carrot = new Food("carrot", 2, 3, 5);
        apple = new Food("apple", 10, 5, 8);

    }


    @Test
    void testLoadAndSave() throws IOException, ClassNotFoundException {
        myFoodDataBase.insert(carrot);
        myFoodDataBase.insert(apple);
        myFoodDataBase.save("./data/foodData.txt");
        FoodDataBase testFoodDataBase = new FoodDataBase();
        testFoodDataBase.load("./data/foodData.txt");
        assertEquals("carrot", myFoodDataBase.getFoods().get(0).getName());
        assertEquals(carrot.getPrice(), myFoodDataBase.getFoods().get(0).getPrice());
        assertEquals("apple", myFoodDataBase.getFoods().get(1).getName());
    }

    @Test
    void testInsert() {
        myFoodDataBase.insert(carrot);
        assertEquals(myFoodDataBase.getFoods().get(0).getName(), carrot.getName());
    }


}