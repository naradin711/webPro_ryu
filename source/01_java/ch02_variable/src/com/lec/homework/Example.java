package com.lec.homework;
// ���� ����, ����, ���� ������ ������ �Ҵ��ϰ� �� ������ ����ϰ� ����, ��� ����ϴ� ���α׷��� ���� �Ͻÿ�.

public class Example {
        public static void main(String[] args) {
        int kor = 90;
        int mat = 100;
        int eng = 95;
        int sum = kor + mat + eng;
        double avg = sum/3.0;
        System.out.printf("����� %d��, ������ %d��, ����� %d�� �Դϴ�.\n", kor, mat, eng);
        System.out.printf("������ %d��, ����� %.1f", sum, avg);
}     
}