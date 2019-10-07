package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class DataBase  {
    abstract void load(String path) throws IOException, ClassNotFoundException;
    abstract void save(String path) throws IOException;
    protected ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
