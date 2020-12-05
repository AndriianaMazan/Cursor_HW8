package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final CarGenerator gen = new CarGenerator();

        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Car temp = gen.generate();
            cars.add(temp);
        }
        System.out.println("These are all the generated cars: " + cars + "\n\n");

        List<Car> filteredCars;
        Map<UUID, Car> cheapestCars = new LinkedHashMap<>();

        filteredCars = cars.stream()
                .filter(car -> car.getBrand().equals(Brand.Tesla) || car.getBrand().equals(Brand.Audi))
                .collect(Collectors.toList());
        System.out.println("\n\nThese are Tesla and Audi cars:" + filteredCars);

        filteredCars = filteredCars.stream()
                .filter(car -> car.getYear() < 2018)
                .collect(Collectors.toList());
        System.out.println("\n\nThese are Tesla and Audi cars that were created before 2018:" + filteredCars);

        filteredCars = filteredCars.stream()
                .filter(car -> car.getMileage() < 40_000)
                .collect(Collectors.toList());
        System.out.println("\n\nThese are Tesla and Audi cars that were created before 2018 and have a mileage of less than 40,000:" + filteredCars);

        filteredCars = filteredCars.stream()
                .sorted(Comparator.comparingInt(Car::getPrice).reversed())
                .collect(Collectors.toList());
        System.out.println("\n\nThese are Tesla and Audi cars that were created before 2018 and have a mileage of less than 40,000 (sorted by price (max-min):" + filteredCars);

        final int size = (filteredCars.size() > 3) ? filteredCars.size() - 4 : 0;
        for (int i = filteredCars.size() - 1; i > size; i--) {
            Car tempCar = filteredCars.get(i);
            UUID id = tempCar.getId();
            cheapestCars.put(id, tempCar);
        }

        System.out.println("\n\nThese are the three cheapest cars: " + cheapestCars.values());
    }
}
