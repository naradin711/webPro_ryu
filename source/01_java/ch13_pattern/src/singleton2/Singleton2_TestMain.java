package singleton2;

public class Singleton2_TestMain {
	public static void main(String[] args) {
		FirstClass firstObj = new FirstClass();
        // instance�� �������.
		SecondClass secObj = new SecondClass();
		SingletonClass singObj = SingletonClass.getInstance();
		System.out.println("�����Լ����� �̱����� ��ü i�� : "+singObj.getI());
	}
   
}
