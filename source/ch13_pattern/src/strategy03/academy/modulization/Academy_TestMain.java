package strategy03.academy.modulization;

public class Academy_TestMain {
	public static void main(String[] args) {
		Student st1 = new Student("30301", "������", "���дܰ�");
		Student st2 = new Student("20301", "������", "����ܰ�");
		Lecturer gs1 = new Lecturer("E01", "������", "����");
		Lecturer gs2 = new Lecturer("M03", "��â��", "����");
		Staff s1 = new Staff("S01", "������", "�ѹ���");
		Person [] pp = {st1, st2, gs1, gs2, s1};
		System.out.println("�����ð��̴� �� ���սô�.");
		for(Person p : pp) {
			p.job();
		}
		System.out.println("�������� �� �������.");
		for(Person p : pp) {
			p.get();
		}
		System.out.println("�ñ��ϸ� ����Ʈ.");
		for(Person p : pp) {
			p.print();
		}
	}

}
