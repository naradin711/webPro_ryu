package com.lec.homework;
// 예제 국어, 영어, 수학 점수를 변수에 할당하고 각 점수를 출력하고 총점, 평균 출력하는 프로그램을 구현 하시오.

public class Example {
        public static void main(String[] args) {
        int kor = 90;
        int mat = 100;
        int eng = 95;
        int sum = kor + mat + eng;
        double avg = sum/3.0;
        System.out.printf("국어는 %d점, 수학은 %d점, 영어는 %d점 입니다.\n", kor, mat, eng);
        System.out.printf("총점은 %d점, 평균은 %.1f", sum, avg);
}     
}