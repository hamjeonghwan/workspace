package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	
		boolean isContinue = true;
		while(isContinue) {
			System.out.println("=======================================");
			System.out.println("Lotto 프로그램");
			System.out.println("---------------------------------------");

			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");

			System.out.println("=======================================");
			
			int num = s.nextInt();

			switch(num){
			case 1: 
				Buy();
				break;
			case 2:
				System.out.println("감사합니다.");
				isContinue = false;
				break;
			}
		}
	}
	
	public static void Buy() {
		Scanner s = new Scanner(System.in);
		int ticket;
		
		System.out.println("Lotto 구입 시작");
		System.out.println("금액 입력 : ");
		
		int money = s.nextInt();
		ticket = money / 1000;
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		
		for(int i = 1 ; i <= ticket; i++) {
			Set<Integer> lotto = new HashSet<>();
			
			while(lotto.size() < 6) {
				int num = (int)(Math.random() * 45 + 1); 
				lotto.add(num);
			}
			System.out.println("로또번호" + i + " : " + lotto);
		}
		System.out.println("");
		System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + (money % 1000) + "원입니다.");
		
	}

}







