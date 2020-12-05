package com.company;

import java.util.UUID;

public class Car {
    private final UUID id;
    private final Brand brand;
    private final int year;
    private final int mileage;
    private final int price;

    public Car(Brand brand, int year, int mileage, int price) {
        id = UUID.randomUUID();
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return "\n\nID: " + id
                + "\n" + brand + " " + year
                + "\nMileage: " + mileage
                + "\n" + price + "$";
    }
}
