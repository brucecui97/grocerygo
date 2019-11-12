package model;

public class Customer implements ItemObserver {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Item item) {
        System.out.println("It's great to hear " + item.getName() + " with price " + item.getPrice() + "$ is now in stock");
    }
}
