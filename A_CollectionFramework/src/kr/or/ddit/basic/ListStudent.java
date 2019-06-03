package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListStudent {

	// 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는
	// Student클래스를 만든다.
	// 생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
	//
	// 이 Student객체들은 List에 저장하여 관리한다.
	// List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
	// 총점의 역순으로 정렬하는 부분을 프로그램 하시오.
	// (총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
	// (학번 정렬기준은 Student클래스 자체에서 제공하도록 하고,
	// 총점 정렬기준은 외부클래스에서 제공하도록 한다.)

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();

		studentList.add(new Student("2019090", "전성희", 99, 99, 100));
		studentList.add(new Student("2019038", "한정환", 99, 89, 100));
		studentList.add(new Student("2019086", "정수영", 99, 99, 70));
		studentList.add(new Student("2019051", "방민주", 89, 99, 100));
		studentList.add(new Student("2019057", "장서익", 99, 72, 96));
		studentList.add(new Student("2019075", "이해솔", 99, 96, 94));
		


		for(Student stu : studentList) {
			int rank = 1;
			for(Student stu2 : studentList) {
				if(stu.getSum() < stu2.getSum()) {
					rank++;
				}
			}
			stu.setRank(rank);
		}
		
		System.out.println("정렬 전");
		for (Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println("=======================================================");
		
		Collections.sort(studentList);
		
		System.out.println("학번의 오름차순으로 정렬 후");
		for (Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println("=======================================================");

		Collections.sort(studentList, new SortSumDesc());
		System.out.println("총점의 내림차순으로 정렬 후");
		for (Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println("=======================================================");

	}
	
	
}

class SortSumDesc implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {
		if (stu1.getSum() == stu2.getSum()) {
			return Integer.compare(Integer.parseInt(stu1.getNum()), Integer.parseInt(stu2.getNum())) * -1;
		}
		return Integer.compare(stu1.getSum(), stu2.getSum()) * -1;
	}
	
	
}

class Student implements Comparable<Student> {
	private String num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank;
	


	public Student(String num, String name, int kor, int eng, int math) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor + eng + math;

	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "[학번: " + num + " 이름: " + name + "] 국어: " + kor + ", 영어: " + eng + ", 수학: " + math + ", 총점: " + sum + ", 등수: " + rank;
	}

	@Override
	public int compareTo(Student stu) {
		return getNum().compareTo(stu.getNum());
	}

}