package singleton2;

public class FirstClass {
   public FirstClass( ) {
	  SingletonClass singletonObject = SingletonClass.getInstance();
	  System.out.println("�̱��� ��ü�� i�� : "+ singletonObject.getI());
	  singletonObject.setI(777);
	  System.out.println("�̱��� ��ü�� i�� ���� ��: "+ singletonObject.getI());
	  singletonObject.setI(211);
	  System.out.println("�̱��� ��ü�� i�� ���� ��: "+ singletonObject.getI());
   } 
}
