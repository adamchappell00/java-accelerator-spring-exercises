package com.example.spring.models;
import java.util.Objects;

public class MenuItem {

    public MenuItem(String name, double price, String description) {
        this.id = serialNumber;
        this.name = name;
        this.price = price;
        this.description = description;
        serialNumber++;
    }

    public MenuItem() {
        this.id = serialNumber;
        serialNumber++;
    }

    private int id;
    private String name;
    private double price;
    private String description;
    private static int serialNumber = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return id == menuItem.id && Double.compare(menuItem.price, price) == 0 && Objects.equals(name, menuItem.name) && Objects.equals(description, menuItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description);
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}