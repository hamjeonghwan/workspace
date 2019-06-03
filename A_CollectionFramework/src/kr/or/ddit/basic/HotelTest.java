package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	Map<String, String> map = new HashMap<>();
	Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		/*
		 * HotelTest hotel = new HotelTest(); hotel.hotelStart();
		 */
		new HotelTest().hotelStart();

	}

	public void hotelStart() {

		System.out.println("************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("************************");

		boolean isContinue = true;
		while (isContinue) {
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1. 체크인");
			System.out.println("2. 체크아웃");
			System.out.println("3. 객실상태");
			System.out.println("4. 프로그램 종료");

			int num = s.nextInt();

			switch (num) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				room();
				break;
			case 4:
				System.out.println("************************");
				System.out.println("호텔문을 닫았습니다.");
				System.out.println("************************");
				isContinue = false;
				break;
			}
		}
	}

	public void checkIn() {

		while (true) {
			System.out.println("어느방에 체크인 하시겠습니까?");
			System.out.println("방번호 입력 >> ");
			String roomNum = s.next();
			if (roomNum.equals(map.get("방번호"))) {
				System.out.println(roomNum + "방에는 이미 사람이 있습니다.");
			} else {
				System.out.println("누구를 체크인 하시겠습니까?");
				System.out.println("이름 입력 >> ");
				String name = s.next();

				map.put(roomNum, name);

				break;
			}
		}

	}

	public void checkOut() {
		while (true) {
		
			System.out.println("어느방을 체크아웃 하시겠습니까?");
			System.out.println("방번호 입력 >> ");
			String roomNum = s.next();

				if (map.get(roomNum) == null) {
					System.out.println(roomNum + "방에는 체크인한 사람이 없습니다.");
				} else {
					map.remove(roomNum);
					break;
				}
			}
		

	}

	public void room() {
		Set<String> keySet = map.keySet();

		System.out.println("************************");
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println("방번호 : " + key + ", 투숙객 : " + map.get(key));
		}

		System.out.println("************************");
	}

}
