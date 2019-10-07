package model;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

//loading and saving to/from file was done following this post
//https://stackoverflow.com/questions/16111496/java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the
public class FoodDataBase extends DataBase {
    private List<Food> foods;

    public FoodDataBase() {
        foods = new ArrayList<>();

    }

    public List<Food> getFoods() {
        return foods;
    }

    //effect: return original string as list of space deliminated string


    //saves data in current foods in specified file location
    @Override
    public void save(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        for (Food food : foods) {
            String line = food.getName() + " "
                    + Integer.toString(food.getPrice()) + " "
                    + Integer.toString(food.getCalories()) + " "
                    + Integer.toString(food.getWeight());
            writer.println(line);
        }
        writer.close();
    }

    //loads data from the only read/write file for loading/saving
    @Override
    public void load(String path) throws IOException, ClassNotFoundException {
        foods = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(path));

        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            Food tempFood = new Food();
            tempFood.setName(partsOfLine.get(0));
            tempFood.setPrice(Integer.parseInt(partsOfLine.get(1)));
            tempFood.setCalories(Integer.parseInt(partsOfLine.get(2)));
            tempFood.setWeight(Integer.parseInt(partsOfLine.get(3)));
            foods.add(tempFood);
            //writer.println(line);
        }
        //writer.close(); //note -- if you miss this, the file will not be written at all.
    }

    public void insert(Food food) {
        foods.add(food);
    }
}
