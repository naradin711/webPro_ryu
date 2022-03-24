package singleton2;

public class Singleton2_TestMain {
	public static void main(String[] args) {
		FirstClass firstObj = new FirstClass();
        // instance가 들어있음.
		SecondClass secObj = new SecondClass();
		SingletonClass singObj = SingletonClass.getInstance();
		System.out.println("메인함수에서 싱글톤의 객체 i값 : "+singObj.getI());
	}
   
}
