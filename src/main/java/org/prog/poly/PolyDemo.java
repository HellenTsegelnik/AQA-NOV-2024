package org.prog.poly;

public class PolyDemo {

    public static void main(String[] args) {
        Ford ford = new Ford();
        Mazda mazda = new Mazda();

        drive(ford);
        drive(mazda);
    }

    public static void drive(ICar iCar) {
        iCar.accelerate();
        iCar.accelerate();
        iCar.turnLeft();
        iCar.decelerate();
        iCar.turnRight();
        iCar.decelerate();
    }
}
