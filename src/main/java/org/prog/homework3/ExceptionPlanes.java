package org.prog.homework3;

import org.prog.Plane;

public class ExceptionPlanes {
    public static void main(String[] args) {
        Plane plane1 = new Plane(null);
        Plane plane2 = new Plane(null);

        try {
            comparePlanes(plane1, plane2);
        } catch (NullPointerException e) {
            System.out.println(" Flight Id is missing");
        } finally {
            System.out.println(" Works anyway");
        }
    }

    public static void comparePlanes(Plane p1, Plane p2) {
        if (p1.getFlightId() == null || p2.getFlightId() == null) {
            throw new NullPointerException();

        }
        System.out.println(" Planes can be compared ");
    }

    static class Plane {
        public String FlightId;

        public Plane(String getFlightId) {
            this.getFlightId = getFlightId;
        }

        public String getFlightId() {
            return flightId;
        }
    }

}



