package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
 * 문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 * 		컴퓨터의 숫자는 난수를 이용하여 구한다.
 * 		(스트라이크는 'S', 볼은 'B'로 출력한다.)
 * 		컴퓨터의 난수가 9 5 7 일때 실행 예시)
 * 		숫자 입력 => 3 5 6
 * 		3 5 6 => 1S 0B
 * 		...
 * 		숫자 입력 => 9 5 7
 * 		3 5 6 => 3S 0B
 * 		
 * 		5번째 만에 맞췄군요.
 */
public class T11_BaseBallTest {

	public static void main(String[] args) {
		Set<Integer> baseBall = new HashSet<>();
		Scanner s = new Scanner(System.in);
		int strike = 0;
		int ball = 0;
		int cnt = 0;
		
		while(baseBall.size() < 3) {
			int com = (int)(Math.random() * 10 + 1); //1~10사이의 난수 만들기
			baseBall.add(com);
		}
		
		for(Integer com : baseBall) {
			System.out.println(com);
		}
		
		System.out.println("맞출 숫자 3개를 입력해주세요.");
		int user1 = s.nextInt();
		int user2 = s.nextInt();
		int user3 = s.nextInt();
		
		List<Integer> bblist = new ArrayList<>(baseBall);
//		Iterator it = baseBall.iterator();
		
		
		
		
		
/*
		for(Integer  : bblist) {
			if(com.equals(user1))
		}
		for(int i=0; i < bblist.size(); i++) {
			if(bblist.get(i) == user1 || bblist.get(i) == user2 || bblist.get(i) == user3) {
				if(bblist.get(0) == user1 || bblist.get(1) == user2 || bblist.get(2) == user3) {
					System.out.println( + "S");
				}else {
					System.out.println("1B");
					
				}
			}
		}*/
		
	
		
		
		
		

	}

}






