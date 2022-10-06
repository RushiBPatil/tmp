package com.baseClassObject;

public class testingClass {

	public static void main(String[] args) {
		String name = "Rushikesh Patil";
		System.out.println("original string is: " + name);
		System.out.println("reversed string is :" + reverse(name));
	}

	public static String reverse(String S) {
		char ch;
		String tmp = "";

		for (int i = 0; i < S.length(); i++) {
			ch = S.charAt(i);
			System.out.println("picked char is " + ch);
			tmp = ch + tmp;
		}
		return tmp;

	}
}
