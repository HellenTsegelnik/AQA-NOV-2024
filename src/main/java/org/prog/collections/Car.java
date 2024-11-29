package org.prog.collections;
import org.prog.collections.CarOwners;
class Car{
    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return model;
    }
}

class Owner {
    private String name;
    private Set<Car> cars = new HashSet<>();

    public Owner(String name) {
        this.name = name;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public String toString() {
        return name + " : " + cars;
    }
}






