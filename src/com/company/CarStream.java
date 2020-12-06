package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class CarStream {

    public static void main(String[] args) {
        final CarGenerator carGenerator = new CarGenerator();

        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Car temp = carGenerator.generate();
            cars.add(temp);
        }
        System.out.println("These are all the generated cars: " + cars + "\n\n");

        List<Car> filteredCarsByBrand = cars.stream()
                .filter(car -> car.getBrand().equals(Brand.Tesla) || car.getBrand().equals(Brand.Audi))
                .collect(Collectors.toList());
        System.out.println("\n\nThese are Tesla and Audi cars:" + filteredCarsByBrand);

        List<Car> filteredCarsByYear = filteredCarsByBrand.stream()
                .filter(car -> car.getYear() < 2018)
                .collect(Collectors.toList());
        System.out.println("\n\nThese are Tesla and Audi cars that were created before 2018:" + filteredCarsByYear);

        List<Car> filteredCarsByMileage = filteredCarsByYear.stream()
                .filter(car -> car.getMileage() < 40_000)
                .collect(Collectors.toList());
        System.out.println("\n\nThese are Tesla and Audi cars that were created before 2018 and have a mileage of less than 40,000:" + filteredCarsByMileage);

        List<Car> sortedCarsByPrice = filteredCarsByMileage.stream()
                .sorted(Comparator.comparingInt(Car::getPrice).reversed())
                .collect(Collectors.toList());
        System.out.println("\n\nThese are Tesla and Audi cars that were created before 2018 and have a mileage of less than 40,000 (sorted by price (max-min):" + sortedCarsByPrice);

        final Map<UUID, Car> cheapestCars = new LinkedHashMap<>();
        final int size = (sortedCarsByPrice.size() > 3) ? sortedCarsByPrice.size() - 4 : 0;
        for (int i = sortedCarsByPrice.size() - 1; i > size; i--) {
            Car tempCar = sortedCarsByPrice.get(i);
            UUID id = tempCar.getId();
            cheapestCars.put(id, tempCar);
        }

        System.out.println("\n\nThese are the three cheapest cars: " + cheapestCars.values());
    }
}
