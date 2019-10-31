package ui;

import exceptions.SortingOptionNotAvailableException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SortingOptionNotAvailableException {
        Grocerygo app = new Grocerygo();
        app.startInteraction();
    }
}



