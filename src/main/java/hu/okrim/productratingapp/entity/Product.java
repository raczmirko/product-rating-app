package hu.okrim.productratingapp.entity;

public class Product {
    private int id;
    private String brand;
    private String name;
    private String category;
    private boolean isDrink;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isDrink() {
        return isDrink;
    }

    public void setDrink(boolean drink) {
        isDrink = drink;
    }
}
