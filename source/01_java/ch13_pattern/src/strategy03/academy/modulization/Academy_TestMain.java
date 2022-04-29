package strategy03.academy.modulization;

public class Academy_TestMain {
	public static void main(String[] args) {
		Student st1 = new Student("30301", "서지수", "수학단과");
		Student st2 = new Student("20301", "유지애", "영어단과");
		Lecturer gs1 = new Lecturer("E01", "박정현", "영어");
		Lecturer gs2 = new Lecturer("M03", "임창정", "수학");
		Staff s1 = new Staff("S01", "유아인", "총무부");
		Person [] pp = {st1, st2, gs1, gs2, s1};
		System.out.println("업무시간이니 다 일합시다.");
		for(Person p : pp) {
			p.job();
		}
		System.out.println("월말에는 돈 드려야죠.");
		for(Person p : pp) {
			p.get();
		}
		System.out.println("궁금하면 프린트.");
		for(Person p : pp) {
			p.print();
		}
	}

}
