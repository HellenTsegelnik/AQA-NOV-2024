package org.prog.poly.homework;

public class Android implements ICallPhone {

    @Override
    public void makePhoto() { System.out.println(" Android make a photo");

    }

    @Override
    public void scanBiometrics() { System.out.println( " Android scan biometrics");

    }

    @Override
    public void makeACall() { System.out.println( "Android make a call");

    }
}
