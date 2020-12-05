package com.company;

import java.util.Random;

public class CarGenerator {
    private Brand brand;
    private int year;
    private int mileage;
    private int price;

    public Car generate() {
        final Random random = new Random();
        brand = Brand.values()[(int) (Math.random() * 5)];
        year = (int) (2008 + Math.random() * 13);
        mileage = (int) (Math.random() * 500_000);
        price = (int) (2000 + Math.random() * 300_000);
        return new Car(brand, year, mileage, price);
    }
}
