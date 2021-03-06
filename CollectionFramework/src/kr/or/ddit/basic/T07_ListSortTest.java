package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T07_ListSortTest {
	public static void main(String[] args) {
		List<Member> list = new ArrayList<>();
		
		list.add(new Member(1, "한정환", "010-7751-2790"));
		list.add(new Member(2, "전성희", "010-1315-1351"));
		list.add(new Member(5, "정수영", "010-7751-2791"));
		list.add(new Member(9, "방민주씨", "010-7751-2792"));
		list.add(new Member(4, "정지후", "010-7751-2793"));
		list.add(new Member(3, "송진원", "010-7751-2795"));
		
		System.out.println("정렬 전 ");
		for(Member mem : list) {
			System.out.println(mem);	
		}
		System.out.println("========================");
		
		Collections.sort(list); // 정렬하기 
		
		System.out.println("이름의 오름차순으로 정렬 후 ");
		for(Member mem : list) {
			System.out.println(mem);	
		}
		System.out.println("========================");
		// 외부정렬 기준을 이용하여 정렬하기 
		Collections.sort(list, new SortNumDesc());
		
		System.out.println("번호의 내림차순으로 정렬 후 ");
		for(Member mem : list) {
			System.out.println(mem);	
		}
		
	}
}
class Member implements Comparable<Member>{
		// 번호
		private int num; 
		// 이름
		private String name;
		// 전화번호
		private String tel;
		
		public Member(int num, String name, String tel) {
			super();
			this.num = num;
			this.name = name;
			this.tel = tel;
			
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		@Override
		public int compareTo(Member mem) {
			return getName().compareTo(mem.getName());
			
		}
		@Override
		public String toString() {
			return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
		}

}
// 정렬기준의 외부선언을 위해서는 Comparator 인터페이스를 구현하면 된다 
// Member의 번호의 내림차순으로 정렬하기 구현 
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
//		if(mem1.getNum() > mem2.getNum()) {
//			return  -1;
//		} else if (mem1.getNum() == mem2.getNum()) {
//			return 0;
//		} else {
//			return 1;
//		}
		// Wrapper 클래스에서 제공하는 메서드를 이용하는 방법 1
		// 내림차순일 경우에는 -1을 곱해준다 
			return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
		// Wrapper 클래스에서 제공하는 메서드를 이용하는 방법 2
		
		//return new Integer(mem1.getNum()).compareTo(mem2.getNum()) *-1;
	}
		
}