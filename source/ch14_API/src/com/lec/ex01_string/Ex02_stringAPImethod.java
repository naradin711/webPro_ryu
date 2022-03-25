package com.lec.ex01_string;

public class Ex02_stringAPImethod {

	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String ("ABCXabc");
		String str3 = "            ja          va           ";
		System.out.println("1. "+str1.concat(str2)); //abcXabcABCxabc µÎ ¹®ÀÚ¿­À» ´õÇÏ´Â °Í.
		System.out.println("2. "+str1.substring(3)); // Xabc ½ÃÀÛÀ§Ä¡ºÎÅÍ ¸¶Áö¸·±îÁö ¹İÈ¯(return)
		System.out.println("3. "+str1.substring(3,5));// Xa ½ÃÀÛ À§Ä¡ºÎÅÍ ÇØ´ç ¼ıÀÚ ¹Ù·Î ¾Õ±îÁö ¹İÈ¯ (return)
		System.out.println("4. "+str1.length());//±ÛÀÚ±æÀÌ 7
		System.out.println("5. "+str1.toUpperCase());// ÇØ´ç ¹®ÀÚ¿­¿¡ ÀÖ´Â ±ÛÀÚ¸¦ ´ë¹®ÀÚ·Î ¹Ù²Û´Ù ABCXABC
		System.out.println("6. "+str1.toLowerCase());// ÇØ´ç ¹®ÀÚ¿­¿¡ ÀÖ´Â ±ÛÀÚ¸¦ ¼Ò¹®ÀÚ·Î ¹Ù²Û´Ù abcxabc
		System.out.println("7. "+str1.charAt(3));// ¼¼¹øÂ° ¹®ÀÚ 'X'
		System.out.println("8. "+str1.indexOf('b')); // b°¡ ¸î¹øÂ°¿¡ ³ª¿À´ÂÁö
		System.out.println("9. "+str1.indexOf('b', 3)); // 3¹øÂ° ºÎÅÍ ½ÃÀÛÇØ¼­ b°¡ ¸î¹øÂ°¿¡ ³ª¿À´ÂÁö
		System.out.println("10. "+str1.indexOf("abc")); // ¹®ÀÚ¿­ÀÇ À§Ä¡
		System.out.println("11. "+str1.indexOf("abc",3)); // 3¹øÂ° ºÎÅÍ ½ÃÀÛÇÏ´Â ¹®ÀÚ¿­ À§Ä¡ 
		System.out.println("12. "+str1.indexOf('z')); // ¾øÀ¸¸é -1
		System.out.println("13. "+str1.lastIndexOf('b')); // ¸¶Áö¸·ÀÇ b À§Ä¡¸¦ ¹İÈ¯ 
		System.out.println("14. "+str1.lastIndexOf('b',3));//3¹øÂ° ºÎÅÍ ¸Ç ¸¶Áö¸·ÀÇ b
		str1 = "abcXabc";
		str2 = new String ("ABCXabc");
		System.out.println("15. "+str1.equals(str2));// ¼­·Î °°Àº ¹®ÀÚ¿­ÀÎ°¡?
		System.out.println("16. "+str1.equalsIgnoreCase(str2)); //´ë¼Ò¹®ÀÚ ±¸ºĞ ¾øÀÌ ºñ±³.
		str1 = "abcXabc";
		str3 = "            ja          va           ";
		System.out.println("17. "+str3.trim()); // ¾Õ µÚ °ø¹éµé¸¸ Àß¶ó³»±â
		System.out.println("18. "+str1.replace('a', '9')); // a¸¦ 9·Î ¸ğµÎ ¼öÁ¤ ¹®ÀÚ¿­µµ °°ÀÌ °¡´É
		System.out.println("19. "+str1.replace("abc", "$")); // abc¸¦ º°·Î ¼öÁ¤ 
		System.out.println("°ø¹é¾ø¾Ö±â "+str3.replace(" ","")); // °ø¹éÀ» ¹®ÀÚ¿­¾øÀ½À¸·Î ´ëÃ¼
		System.out.println("20. "+str1.replaceAll("abc", "z")); // abc¸¦ z
		// Á¤±ÔÇ¥Çö½Ä 
		// ¿¬½ÀÀå
		String str = "¾È³çHello"; // ¿µ¹®ÀÚ ´Ù Á¦°ÅÇÏ°í ½ÍÀ½
		System.out.println(str.replaceAll("[a-zA-z]","")); //¿µ¾î ¾ø¾Ö±â
		System.out.println(str.replaceAll("[°¡-ÆR]","")); // ÇÑ±Û ¾ø¾Ö±â 
		// ¹®ÀÚ¿­ ¸Ş¼Òµå´Â ¹®ÀÚ¿­À» ¼öÁ¤ÇÏÁö ¾ÊÀ½.
		System.out.println("str1 = "+str1);
	}

}




















