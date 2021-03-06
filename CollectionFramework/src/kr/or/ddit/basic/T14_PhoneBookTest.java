package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Phone {

	private String tel;

	private String addr;

	public Phone(String tel, String addr) {
		super();
		this.setTel(tel);
		this.setAddr(addr);
	}

	@Override
	public String toString() {
		return tel + "\t" + addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}

public class T14_PhoneBookTest {

	static Map<String, Phone> Phonemap = new HashMap<>();

	static int num = 1;

	public static void main(String[] args) {
		System.out.println("===============================================");
		System.out.println("전화번호 관리 프로그램(파일로 저장되지 않음)");
		System.out.println("===============================================");
		boolean isContinue = true;
		while (isContinue) {
			Scanner s = new Scanner(System.in);

			System.out.println("메뉴를 선택하세요.");
			System.out.println(" 1. 전화번호 등록 ");
			System.out.println(" 2. 전화번호 수정 ");
			System.out.println(" 3. 전화번호 삭제");
			System.out.println(" 4. 전화번호 검색");
			System.out.println(" 5. 전화번호 전체 출력");
			System.out.println(" 0. 프로그램 종료");

			int phoneSelect = s.nextInt();

			switch (phoneSelect) {
			case 1:
				PhoneSet();
				break;

			case 2:
				PhoneUpdate();
				break;

			case 3:
				PhoneDelete();
				break;

			case 4:
				PhoneS();
				break;

			case 5:
				PhoneView();
				break;

			case 0:
				System.out.println("감사합니다.");
				isContinue = false;
				break;
			}
		}
	}

	private static void PhoneView() {

		System.out.println(" =======================================");
		System.out.println("번호 \t이름 \t 전화번호 \t \t주소 ");
		Set<String> keySet = Phonemap.keySet();

		Iterator<String> it = keySet.iterator();

		while (it.hasNext()) {
			String key = it.next();
			System.out.println(num++ + "\t" + key + "\t" + Phonemap.get(key));

		}

		System.out.println(" =======================================");
	}

	private static void PhoneS() {
		Scanner s = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요");
		System.out.println("이름  >>> ");
		String phoneName = s.nextLine();

		if (Phonemap.get(phoneName) == null) {
			System.out.println("이름이 없져요");
		} else {
			System.out.println(Phonemap.get(phoneName));

		}

	}

	private static void PhoneDelete() {
		System.out.println("모든 정보를 삭제 합니다 ");
		Phonemap.clear();

	}

	private static void PhoneUpdate() {
		Scanner s = new Scanner(System.in);
		System.out.println("수정할 이름  >>> ");
		String phoneName = s.nextLine();
		if (Phonemap.get(phoneName) == null) {
			System.out.println("수정할 이름이 없져요");
		} else {
			System.out.println("전화번호 >>> ");
			String phoneNum = s.nextLine();

			System.out.println("주소 >>> ");
			String phoneaddr = s.nextLine();

			Phonemap.put(phoneName, new Phone(phoneNum, phoneaddr));
		}
	}

	private static void PhoneSet() {

		Scanner s = new Scanner(System.in);
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");

		System.out.println("이름  >>> ");
		String phoneName = s.nextLine();
		
		if(Phonemap.get(phoneName) != null) {
			System.out.println(phoneName + "씨는 이미 등록된 사람입니다");
			return;
		}
		System.out.println("전화번호 >>> ");
		String phoneNum = s.nextLine();

		System.out.println("주소 >>> ");

		String phoneaddr = s.nextLine();

		Phonemap.put(phoneName, new Phone(phoneNum, phoneaddr));

	}
}
