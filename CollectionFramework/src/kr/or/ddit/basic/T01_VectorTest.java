package kr.or.ddit.basic;

import java.util.Vector;

public class T01_VectorTest {
	// Vector => List 계열 클래스
	public static void main(String[] args) {
		Vector v1 = new Vector();
		System.out.println("처음 크기 : " + v1.size());

		// Vector는 add() 메서드를 이용하여 데이터를 추가할 수 있다.
		v1.add("aaa");
		v1.add(1111);
		v1.add(new Integer(123));
		v1.add('a');
		v1.add(true);
		v1.add(3.14);
		System.out.println("현재크기 : " + v1.size());

		// Vector는 addElement()메서드를 이용하여 추가할 수도 있는데
		// 이메서드는 기본적으로 add()메서드와 같은 기능을 수행한다

		v1.addElement("ccc");
		System.out.println("v1 => " + v1.toString());

		// add(index, 데이터) => 백터의 index번째에 데이터를 끼워넣는다
		// => index는 0부터 시작한다

		v1.add(1, "kkk");
		System.out.println("v1 => " + v1.toString());

		// set(index, 데이터) => 백터의 index번째의 값을 주어진 데이터로 덮어쓴다
		// => 반환값 : 원래의 데이터
		String temp = (String) v1.set(0, "zzz");
		System.out.println("set 명령 후 v1 = > " + v1);
		System.out.println("원래의 데이터 :  " + temp);
		System.out.println();

		// remove(index) => 백터의 index번째 자료를 삭제한다
		// => 자료가 삭제되면 index번째 다음번쨰 이후의 데이터들이
		// => 앞으로 자동으로 당겨져서 채워진다
		// => 반환값 : 삭제된 데이터

		// remove(삭제할 데이터) => 삭제할 데이터를 찾아서 삭제한다
		// => 만약 삭제할 데이터가 여러개이면 앞에서부터 삭제한다
		// => 삭제할 데이터가 정수형이거나 char형일 경우에는
		// => 삭제할 데이터를 객체로 변환해서 사용해야 한다

		v1.remove(0);
		System.out.println("삭제 후 : " + v1);
		System.out.println();

		temp = (String) v1.remove(0);
		System.out.println("삭제된 자료 : " + temp);
		System.out.println("삭제 후 : " + v1);
		System.out.println();

		v1.add(123);
		v1.remove(true);
		System.out.println("삭제 후 : " + v1);
		System.out.println();

		v1.remove(new Integer(123));
		System.out.println("삭제 후 : " + v1);
		System.out.println();

		v1.removeElement(new Character('a'));
		System.out.println("삭제 후 : " + v1);
		System.out.println();

		v1.remove(3.14);
		System.out.println("삭제 후 : " + v1);
		System.out.println();

		// get(index) => index번째 자료를 반환한다
		int data = (int) v1.get(0);
		System.out.println("0번째 자료 : " + data);
		System.out.println("=========================");

		System.out.println("============백터사이즈 및 용량 메서드 예제");

		Vector v = new Vector(5);

		v.add("전성희");
		v.add("한정환");
		v.add("3");
		print(v);

		v.trimToSize();
		System.out.println("==after trimToSize==");
		print(v);

		v.ensureCapacity(5); // 현재 용량이 최소용량보다 작다면 신규용량 = 현재용량 * 2
									// 그래도 최소용량보다 작다면 신규용량 = 최소용량으로 설정된다

		System.out.println("==ensureCapacity(5)==");
		print(v);

		v.setSize(7); // 현재용량이 설정 사이즈보다 작으면 신규용량 = 현재용량 * 2
						// 그래도 설정사이즈 보다 작으면 신규용량 = 최소용량으로 설정된다

		System.out.println("==after setSize(7)==");
		print(v);

		v.clear();
		System.out.println("==after clear()==");
		print(v);

	}

	private static void print(Vector v) {
		System.out.println(v);
		System.out.println("Size : " + v.size());
		System.out.println("capacity : " + v.capacity());
	}
}
