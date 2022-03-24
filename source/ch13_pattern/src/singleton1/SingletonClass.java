package singleton1;

public class SingletonClass {
   private int i;
   //��ü���������� �ش� ��ü�� �ּҸ� return�ϰ� 
   //��ü���� �� ������ ��ü �����ϰ� �� �ּҸ� return.
   private static SingletonClass INSTANCE; //= null
   public static SingletonClass getInstance() {
	   if (INSTANCE == null) { // ��ü ���� �������� ��ü�����ϰ� �ּ�
		   INSTANCE = new SingletonClass();
	   }
	   return INSTANCE; // ��ü ���������� ��ü �ּҸ� ����
   }
   private SingletonClass () {}
public int getI() {
	return i;
}

public void setI(int i) {
	this.i = i;
}
   
   
}
