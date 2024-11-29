package org.prog.collections;
import org.prog.collections.Car;
public class CarOwners {
    public static void main(String[] args) {
        // Create owners and cars
        Owner jane = new Owner("Jane");
        Owner john = new Owner("John");
        Owner Bill = new Owner("Bill");
        Owner Sarah = new Owner("Sarah");

        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        Car car4 = new Car("Car4");
        Car car5 = new Car("Car5");

        // Assign cars to owners
        jane.addCar(car1);
        jane.addCar(car2);
        jane.addCar(car3);
        john.addCar(car4);
        Bill.addCar(car1);
        Bill.addCar(car5);
        Sarah.addCar(car4);

        // Find and print owners who share cars
        Map<Car, Set<Owner>> sharedCars = new HashMap<>();
        for (Owner owner : Arrays.asList(jane, john, Bill, Sarah)) {
            for (Car car : owner.cars) {
                sharedCars.computeIfAbsent(car, c = new HashSet<>()).add(owner);
            }
        }

        for (Map.Entry<Car, Set<Owner>> entry : sharedCars.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println(entry.getValue());
            }
        }
    }
}


