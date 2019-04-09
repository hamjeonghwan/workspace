package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// 문제 Set을 이용하여 숫자 야구 게임을 작성하시오
//	 컴퓨터의 숫자는 난수를 이용하여 구한다 
// 		S, B, 
// 컴퓨터의 난수가 9 5 7 일때 실행예시
// 	숫자 입력 = > 3 5 6
// 3 5 6 = > 1S 0B 

public class T11_BaseBallTest {
	public static void main(String[] args) {

		Set<Integer> baseBall = new HashSet<Integer>();
		while (baseBall.size() < 3) {
			int num = (int) (Math.random() * 9 + 1);
			baseBall.add(num);
		}
		Iterator<Integer> it = baseBall.iterator();

		// for(int j =1; j <= 100; j++) {
		// int rnd = (int)(Math.random() * );
		// }
		List<Integer> baseBallList = new ArrayList<>(baseBall);
		System.out.println(baseBallList);
		int s = 0;
		int b = 0;
		int c = 0;
		Scanner sr = new Scanner(System.in);
		boolean game = true;
		while (game) {

			System.out.println("**Base Ball Game**");

			
				System.out.println("숫자 입력 :");
				int num = sr.nextInt();
				
		
			
			game = false;
		}
		
	}
}
