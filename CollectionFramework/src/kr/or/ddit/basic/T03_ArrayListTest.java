package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class T03_ArrayListTest {
	// 문제  5명의 사람 이름을 입력하여 ArrayList에 저장하고 
	// 			이중에서 김 씨 성의 이름을 출력하시오 
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
			for(int i = 0; i < 5; i++) {
				String str = s.nextLine();
				list.add(str);
			}
			for(int i = 0; i < 5; i++) {
				String str = list.get(i);
				if(str.charAt(0) == '김') {
					System.out.println(str);
				}
				if(str.substring(0, 1).equals("김"));{
					System.out.println(str);								
				}
				
				if(str.indexOf("김") == 0){
					System.out.println(str);								
				}
				if(str.startsWith("김")) {
					System.out.println(str);								
				}
			}

	}
}
