package org.prog.equalshashcode;

public class OverrideDemo {

    // ParentClass > ChildClass > GrandChildClass
    // ParentClass > ChildClass > GrandChildClass > SuperGrandChildClass
    public static void main(String[] args) {
        ParentClass parentClass = new ParentClass();
        ChildClass childClass = new ChildClass();
        GrandChildClass grandChildClass = new GrandChildClass();
        SuperGrandChildClass superGrandChildClass = new SuperGrandChildClass();

        parentClass.doTheThing();
        childClass.doTheThing();
        grandChildClass.doTheThing();
        superGrandChildClass.doTheThing();
    }
}
