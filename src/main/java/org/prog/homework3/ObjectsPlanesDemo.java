package org.prog.homework3;

import org.prog.Plane;

public class ObjectsPlanesDemo {
    public static void main(String[] args ){
     Object o  = new Object();
     Plane plane1 = new Plane();
     Plane plane2= new Plane();

    plane1.airlines="one";
    plane1.destination = "Dubai";
    plane1.flightId = "123";
    plane2.airlines ="one";
    plane2.destination = "Dubai";
    plane2.flightId = "123";

    System.out.println( "one".hashCode());
        System.out.println( "one ".hashCode());
        System.out.println( "Dubai".hashCode());
        System.out.println( "Dubai ".hashCode());
        System.out.println( "123".hashCode());
        System.out.println( "123".hashCode());
   System.out.println(plane1.equals(plane2));
   System.out.println(plane1.hashCode());
   System.out.println(plane2.hashCode());

    System.out.println(plane1.toString());
        System.out.println(plane2.toString());
    }
}
