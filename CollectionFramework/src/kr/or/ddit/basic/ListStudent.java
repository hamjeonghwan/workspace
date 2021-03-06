package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListStudent {
	public static void main(String[] args) {

		List<Members> liste = new ArrayList<>();
		liste.add(new Members("20131", "한정환", 100, 100, 100));
		liste.add(new Members("20071", "전성희", 100, 100, 100));
		liste.add(new Members("20130", "정지후", 90, 60, 100));
		liste.add(new Members("20136", "김재권", 50, 60, 80));
		liste.add(new Members("20139", "송진원", 60, 60, 60));
		
		
		System.out.println("정렬 전 ");
		for (Members memb : liste) {
			System.out.println(memb);
		}
		System.out.println("================================================");

		Collections.sort(liste); // 정렬하기

		System.out.println("학번 오름차순으로 정렬 후 ");
		for (Members memb : liste) {
			System.out.println(memb);
		}
		System.out.println("================================================");

		Collections.sort(liste, new SortRankDesc());

		System.out.println("총점 내림차순으로 정렬 후 ");
		for (Members memb : liste) {
			System.out.println(memb);
		}
		System.out.println("================================================");
//		for(int i=0; i< liste.size(); i++) {
//			if()
//		}
	}
}

class Members implements Comparable<Members> {

	// 학번
	private String num;
	// 이름
	private String name;
	// 국어점수
	private int num1;
	// 수학점수
	private int num2;
	// 영어점수
	private int num3;
	
	@SuppressWarnings("unused")
	private int sum;

	public int getSum() {
		return num1 + num2 + num3;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Members(String num, String name, int num1, int num2, int num3) {
		super();
		this.num = num;
		this.name = name;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getNum3() {
		return num3;
	}

	public void setNum3(int num3) {
		this.num3 = num3;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		int sum = num1 + num2 + num3;
		
		return " [학번=" + num + ", name=" + name + ", 수학=" + num1 + ", 국어=" + num2 + ", 영어=" + num3 + ", 총점 ="
				+ sum + " ]";
	}

	@Override
	public int compareTo(Members memb) {
		return getNum().compareTo(memb.getNum());
	}
}

class SortRankDesc implements Comparator<Members> {

	@Override
	public int compare(Members memb1, Members memb2) {
		return Integer.compare(memb1.getSum(), memb2.getSum()) * 1;
	}
}
