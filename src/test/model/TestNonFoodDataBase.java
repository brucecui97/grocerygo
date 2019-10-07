package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestNonFoodDataBase {

    NonFood pencil;
    NonFood ruler;
    NonFoodDataBase nonFoodDataBase = new NonFoodDataBase();

    @BeforeEach
    public void runBefore() {
        pencil = new NonFood("pencil", 2);
        ruler = new NonFood("ruler", 10);
    }

    @Test
    void testLoadAndSave() throws IOException, ClassNotFoundException {
        nonFoodDataBase.insert(pencil);
        nonFoodDataBase.insert(ruler);
        nonFoodDataBase.save("./data/nonFoodData.txt");
        NonFoodDataBase testNonFoodDataBase = new NonFoodDataBase();
        testNonFoodDataBase.load("./data/nonFoodData.txt");
        assertEquals("pencil", testNonFoodDataBase.getNonFoods().get(0).getName());
        assertEquals(pencil.getPrice(), testNonFoodDataBase.getNonFoods().get(0).getPrice());
        assertEquals("ruler", testNonFoodDataBase.getNonFoods().get(1).getName());
}
}