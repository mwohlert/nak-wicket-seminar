package de.nordakademie.business.product;

public class Product {

    private final String brand;
    private final String model;
    private final String color;
    private final Double kilometers;
    private final Double price;
    private final Double ps;

    public Product(final String brand, final String model, final String color, final Double kilometers, final Double price, final Double ps) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.kilometers = kilometers;
        this.price = price;
        this.ps = ps;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Double getKilometers() {
        return kilometers;
    }

    public Double getPrice() {
        return price;
    }

    public Double getPs() {
        return ps;
    }
}
