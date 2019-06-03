package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class T03_ArrayListTest {
	/*
	 * 문제) 5명의 사람 이름을 입력하여 ArrayList에 저장하고
	 * 		이 중에서 '김'씨 성의 이름을 출력하시오.
	 * 		(단, 입력은 Scanner를 이용하여 입력 받는다.)
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<>();
		
		System.out.println("이름 5개를 입력하세요.");
		for(int i=0; i < 5; i++) {
		String name = s.next();
		arr.add(name);
		}
		System.out.println(arr.toString());
	
		for(int i=0; i < arr.size(); i++) {
			String name = arr.get(i);
			
			if(name.charAt(0) == '김') {
				System.out.println(name);
			}
			
			if(name.substring(0, 1).equals("김")) {
				System.out.println(name);
			}
			
			if(name.indexOf("김") == 0) {
				System.out.println(name);
			}
			
			if(name.startsWith("김")) {
				System.out.println(name);
			}
		}
		
		
		
		
		
	}

}
