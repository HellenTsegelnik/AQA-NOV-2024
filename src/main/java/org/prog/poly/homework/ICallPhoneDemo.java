package org.prog.poly.homework;

public class ICallPhoneDemo {

    public static void main(String[] args) {
        Android android = new Android();
        Iphone iphone = new Iphone();

        work((ICallPhone) android);
        work((ICallPhone) iphone);


    }

    public static void work(ICallPhone iCallPhone){

        iCallPhone.makeACall();
        iCallPhone.scanBiometrics();
        iCallPhone.makePhoto();

    }

}



