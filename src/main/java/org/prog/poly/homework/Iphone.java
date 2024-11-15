package org.prog.poly.homework;

public class Iphone implements ICallPhone {

         @Override
          public void makeACall() { System.out.println( "Iphone make a call");

         }

          @Override
          public void scanBiometrics() {

            System.out.println(" Iphone scan biometrics");}


    @Override
    public void makePhoto() { System.out.println(" Iphone make a photo");

    }
}
