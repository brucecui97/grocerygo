package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

//loading and saving to/from file was done following this post
//https://stackoverflow.com/questions/16111496/java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the
public class FoodDataBase implements Loadable, Savable, Serializable {
    private List<Food> foods;

    FoodDataBase() {
        foods = new ArrayList<>();

    }

    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public void save() throws IOException {
        FileOutputStream fos = new FileOutputStream("./data/myloFood.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(foods);
        oos.close();
    }

    @Override
    public void load() throws IOException, ClassNotFoundException {
        foods.clear();
        FileInputStream fis = new FileInputStream("./data/myloFood.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Food> tempFoods = (List<Food>) ois.readObject();
        ois.close();
        for (Food food : tempFoods) {
            foods.add(food);
        }
    }

    public void insert(Food food) {
        foods.add(food);
    }
}
