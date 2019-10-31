package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NonFoodDataBase extends DataBase {
    private List<NonFood> nonFoods;

    public NonFoodDataBase() {
        nonFoods = new ArrayList<>();
    }

    public void setNonFoods(List<NonFood> nonFoods) {
        this.nonFoods = nonFoods;
    }

    @Override
    public void save(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        for (NonFood nonFood : nonFoods) {
            String line = nonFood.getName() + " "
                    + Integer.toString(nonFood.getPrice());
            writer.println(line);
        }
        writer.close();
    }

    //loads data from the only read/write file for loading/saving
    @Override
    public void load(String path) throws IOException {
        nonFoods = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(path));

        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            NonFood tempNonFood = new NonFood();
            tempNonFood.setName(partsOfLine.get(0));
            tempNonFood.setPrice(Integer.parseInt(partsOfLine.get(1)));
            nonFoods.add(tempNonFood);
        }
    }

    public List<NonFood> getNonFoods() {
        return nonFoods;
    }


}
