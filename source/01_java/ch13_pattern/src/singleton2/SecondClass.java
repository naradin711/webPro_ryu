package singleton2;

public class SecondClass {
	public SecondClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("SecondClass 생성자 실행중");
		System.out.println("싱글톤 객체의 i 값 : "+singletonObject.getI());
		System.out.println("SecondClass 생성자 끝");
	}//여기서 싱글톤 생성자가 끝남.

}
