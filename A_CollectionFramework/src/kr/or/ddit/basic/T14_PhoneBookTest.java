package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class T14_PhoneBookTest {
	static Scanner s = new Scanner(System.in);
	static Map<String, Phone> pmap = new HashMap<>();
	// static Set<Phone> set = new HashSet<Phone>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("===============================================");
		System.out.println("전화번호 관리 프로그램(파일로 저장되지 않음)");
		System.out.println("===============================================");

		boolean isContinue = true;
		while (isContinue) {
			System.out.println(" 메뉴를 선택하세요.");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("0. 프로그램 종료");

			int num = s.nextInt();

			switch (num) {
			case 1:
				add();
				break;
			case 2:
				change();
				break;
			case 3:
				remove();
				break;
			case 4:
				select();
				break;
			case 5:
				list();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				isContinue = false;
				break;
			}
		}
	}

	public static void add() {
		// Scanner s = new Scanner(System.in);

		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.println("이름 >> ");
		String name = s.next();
		
		if(pmap.get(name) != null) {
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return;
		}

		System.out.println("전화번호 >> ");
		String pNum = s.next();

		s.nextLine(); //버퍼 정리 역할을 위해 호출
		System.out.println("주소 >> ");
		String address = s.nextLine();

		pmap.put(name, new Phone(name, pNum, address));

	}

	public static void change() {
		System.out.println("변경할 전화번호의 이름을 입력하세요.");
		System.out.println("이름 >> ");
		String name = s.nextLine();

		System.out.println(pmap.get(name));
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.println("이름 >> ");
		String changeName = s.nextLine();

		System.out.println("전화번호 >> ");
		String pNum = s.nextLine();

		System.out.println("주소 >> ");
		String address = s.nextLine();

		pmap.remove(name);
		pmap.put(changeName, new Phone(changeName, pNum, address));

	}

	public static void remove() {
		System.out.println("삭제할 전화번호의 이름을 입력하세요.");
		System.out.println("이름 >> ");
		String name = s.nextLine();

		pmap.remove(name);
	}

	public static void select() {
		System.out.println("검색할 전화번호의 이름을 입력하세요.");
		System.out.println("이름 >> ");
		String name = s.nextLine();
		
		System.out.println("이름\t전화번호\t주소");
		System.out.println(pmap.get(name));

	}

	public static void list() {

		Set<String> keySet = pmap.keySet();
		int num = 1;

		System.out.println("=======================================");
		System.out.println("번호\t이름\t전화번호\t주소");
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Phone p = pmap.get(key);
			System.out.println(num + "\t" + p.getName() + "\t" + p.getpNum() + "\t" + p.getAddress() );
			num++;
		}

		System.out.println("=======================================");
	}

}

class Phone {
	String name;
	String address;
	String pNum;

	public Phone(String name, String pNum, String address) {
		super();
		this.name = name;
		this.pNum = pNum;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return pNum + "\t" + address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

}
