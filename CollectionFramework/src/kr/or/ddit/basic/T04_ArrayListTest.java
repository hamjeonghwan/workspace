package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class T04_ArrayListTest {
		// 문제 5명의 벌명을 입력하여 ArrayList에 저장하고 
		// 별명의 길이가 제일 긴 별명을 출력하시오
		// 문제 위에 문제에서 별명의 길이가 같은 것도 출력하게 하시오
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
			
			System.out.println("별명을 입력하세요(5개)");
			for(int i = 0; i < 5; i++) {
				String str = s.nextLine();
				list.add(str);
			}
			
			String sr = list.get(0);
			
			for(int i = 0; i < 5; i++) {
				String str = list.get(i);
					if(sr.length() < list.get(i).length()) {
						sr = list.get(i);	
			}
	
	}
			System.out.println(sr);
			
			int len = list.get(0).length();
			for(int i = 0; i < list.size(); i++) {

			
			}
	}
}

