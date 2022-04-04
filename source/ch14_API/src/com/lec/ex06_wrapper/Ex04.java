package com.lec.ex06_wrapper;

import java.util.Scanner;

public class Ex04 {
// »ç¿ëÀÚ·ÎºÎÅÍ Á¤¼ö ¹®ÀÚ¿­ "100" À» ¹Ş¾Æ Á¤¼ö·Î ¼öÁ¤ÇØ¼­ Ãâ·ÂÇÏ´Â ÇÁ·Î±×·¥
	public static void main(String[] args) {
       Scanner sc = new Scanner (System.in);
       System.out.print("Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä : ");
       String nStr = sc.nextLine();
       System.out.println("ÀÔ·ÂÇÏ½Å ¹®ÀÚ¿­Àº "+nStr);
       nStr = nStr.trim();//ÁÂ¿ì °ø¹é Á¦°Å
       nStr = nStr.replaceAll("[a-zA-Z¤¡-ÆR]", "");
       int num = Integer.parseInt(nStr);
       System.out.println("º¯ÇüµÈ Á¤¼ö´Â "+num);
       
	}

}
