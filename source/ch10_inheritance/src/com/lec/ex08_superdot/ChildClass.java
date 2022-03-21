package com.lec.ex08_superdot;
//super.  = �� �θ� Ŭ������
//super() = �� �θ� Ŭ������ ������ �Լ�.
public class ChildClass extends ParentClass { // ParentClass - i, method()
    private int i = 99;
    public ChildClass() {
    	System.out.println("ChildClass ������");
    }
    @Override
    public void method() {	
        System.out.println("ChildClass�� method");
    	super.method(); // ���� �θ� Class���� method�� ������.
    	System.out.println("ChildClass���� super�� i= "+super.getI()+", Child Ŭ������ i= "+i );
    }
    public int getI( ) {
    	return i;
    }
}
