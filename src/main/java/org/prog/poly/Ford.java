package org.prog.poly;

public class Ford implements ICar {
    @Override
    public void turnRight() {
        System.out.println("Ford turns Right");
    }

    @Override
    public void turnLeft() {
        System.out.println("Ford turns Left");
    }

    @Override
    public void accelerate() {
        System.out.println("Ford is accelerating");
    }

    @Override
    public void decelerate() {
        System.out.println("Ford is decelerating");
    }
}
