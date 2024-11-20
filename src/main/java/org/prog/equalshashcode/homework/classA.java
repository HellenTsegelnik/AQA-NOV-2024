package org.prog.equalshashcode.homework;

public class classA {
    public void doTheThing() {
        System.out.println("It's classA");
    }

    public  void goTo(String from) {
        goTo(from, "current location");
    }

    public  void goTo(String from, String when) {
        goTo(from, when, "nowhere ");
    }

    public  void goTo(String from, String when, String where) {
        goTo(from, when, where);

        System.out.println("Start drive at" + from + when + "to"+where);}}





