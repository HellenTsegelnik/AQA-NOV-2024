package org.prog.poly;

public class Mazda implements ICar {
    @Override
    public void turnRight() {
        System.out.println("Mazda is turning Right");
    }

    @Override
    public void turnLeft() {
        System.out.println("Mazda is turning Left");
    }

    @Override
    public void accelerate() {
        System.out.println("Mazda is accelerating");
    }

    @Override
    public void decelerate() {
        System.out.println("Mazda is decelerating");
    }
}
