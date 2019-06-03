package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class T04_ArrayListTest {

	/*
	 * 문제1) 5명의 별명을 입력하여 ArrayList에 저장하고
	 * 		별명의 길이가 제일 긴 별명을 출력하시오.
	 * 		(단, 각 별명의 길이는 모두 다르게 입력한다.)
	 * 
	 * 문제2) 문제1에서 별명의 길이가 같은 것을 여러개 입력했을 때도 처리하시오.
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<>();
		System.out.println("별명 5개를 입력하시오.");

		for(int i=0; i < 5; i++) {
			String nickname = s.next();
			arr.add(nickname);
		}
		System.out.println(arr.toString());
		
		String nicknameM = arr.get(0);
		
		for(int i=0; i < arr.size(); i++) {
			String nickname = arr.get(i);
			if(nickname.length() > nicknameM.length()) {
				nicknameM = nickname;
			}
		}
		System.out.println(nicknameM);
		
		/*for(int i=0; i < arr.size(); i++) {
			String nickname = arr.get(i);
			if(nicknameM.length() > arr.get(i).length()) {
				nicknameM = arr.get(i);
			}
		}
		System.out.println(nicknameM);*/
		
		/*System.out.println();
		for(int i = 0; i < arr.size(); i++) {
			if(maxLen == arr.get(i).length()) {
				System.out.println();
			}*/
		
		
	}

}
