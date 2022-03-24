package singleton1;

public class SingletonClass {
   private int i;
   //객체생성했으면 해당 객체의 주소를 return하고 
   //객체생성 안 했으면 객체 생성하고 그 주소를 return.
   private static SingletonClass INSTANCE; //= null
   public static SingletonClass getInstance() {
	   if (INSTANCE == null) { // 객체 생성 안했으면 객체생성하고 주소
		   INSTANCE = new SingletonClass();
	   }
	   return INSTANCE; // 객체 생성했으면 객체 주소를 리턴
   }
   private SingletonClass () {}
public int getI() {
	return i;
}

public void setI(int i) {
	this.i = i;
}
   
   
}
