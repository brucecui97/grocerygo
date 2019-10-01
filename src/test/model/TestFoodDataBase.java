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
        carrot = new Food("carrot",2,3,5);
        apple = new Food("apple",10,5,8);
        myFoodDataBase.insert(carrot);
        myFoodDataBase.insert(apple);
    }

    @Test
    void testSave() throws IOException, ClassNotFoundException {

        myFoodDataBase.save();
        FoodDataBase myDataBase2 = new FoodDataBase();

        FileInputStream fis = new FileInputStream("./data/myloFood.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Food> myFoods = (List<Food>) ois.readObject();
        ois.close();
        for (Food food:myFoods){
            myDataBase2.insert(food);
        }
        assertEquals(carrot.getName(),myDataBase2.getFoods().get(0).getName());
        assertEquals(apple.getName(),myDataBase2.getFoods().get(1).getName());

    }

    @Test
    void testLoad() throws IOException, ClassNotFoundException {
        myFoodDataBase.insert(apple);
        myFoodDataBase.load();
        assertEquals(carrot.getName(),myFoodDataBase.getFoods().get(0).getName());
        assertEquals(apple.getName(),myFoodDataBase.getFoods().get(1).getName());

    }


}