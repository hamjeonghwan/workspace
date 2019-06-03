package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class T14_HotelTest {
	static Map<String, Hotel> Hotelmap = new HashMap<>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean isContinue = true;
		System.out.println("===============================================");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("===============================================");
		System.out.println();
		while (isContinue) {
			System.out.println("===============================================");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인 \t 2.체크아웃 \t 3.객실상태 \t 4.업무종료");
			System.out.println("===============================================");
			System.out.println("메뉴 선택 >>> ");
			int HotelSelect = s.nextInt();

			switch (HotelSelect) {
			case 1:
				HotelSet();
				break;

			case 2:
				HotelOut();
				break;

			case 3:
				HotelView();
				break;

			case 4:
				System.out.println("호텔 문을 닫았습니다.");
				isContinue = false;
				break;
			}
		}
	}

	private static void HotelView() {
		Set<String> keySet = Hotelmap.keySet();

		Iterator<String> it = keySet.iterator();

		while (it.hasNext()) {
			String key = it.next();
			System.out.println("방번호 : " + key + ", 투숙객 : " + Hotelmap.get(key) + "\n");

		}
	}

	private static void HotelOut() {
		Scanner s = new Scanner(System.in);
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.println("방번호 입력 >>>");
		String hotelNum = s.nextLine();

		if (Hotelmap.get(hotelNum) == null) {
			System.out.println("체크아웃 할 방이 없습니다");
		} else {
			Hotelmap.remove(hotelNum);
			System.out.println("체크아웃 되었습니다.");
		}
	}

	private static void HotelSet() {
		Scanner s = new Scanner(System.in);
		System.out.println("어느방에 체크인 하시겠습니까?\n방번호 입력 >>>");
		String hotelNum = s.nextLine();

		System.out.println("누구를 체크인 하시겠습니까?");
		String hotelName = s.nextLine();

		if (Hotelmap.get(hotelNum) != null) {
			System.out.printf("%s방에는 이미 사람이 있습니다.\n", hotelNum);
			return;
		}
		Hotelmap.put(hotelNum, new Hotel(hotelName));
		System.out.println(hotelNum + "방에는 체크인 한 사람이 없습니다 ");
		System.out.println("체크인 되었습니다.");

	}
}

class Hotel {
	private String name;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hotel(String name) {
		super();
		this.name = name;
	}
}