package model;

import java.io.IOException;

public interface DataBase  {
    void load() throws IOException, ClassNotFoundException;
    void save() throws IOException;
}
