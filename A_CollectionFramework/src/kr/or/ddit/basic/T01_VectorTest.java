package kr.or.ddit.basic;

import java.util.Vector;

public class T01_VectorTest {
	
	public static void main(String[] args) {
		//Vector => List계열 클래스
		
		Vector v1 = new Vector();
		
		System.out.println("처음 크기 : " + v1.size());
		
		//Vector는 add()메서드를 이용하여 데이터를 추가할 수 있다.
		v1.add("add");
		v1.add(1111);
		v1.add(new Integer(123));
		v1.add('a');
		v1.add(true);
		v1.add(3.14);
		
		System.out.println("현재 크기: " + v1.size());
		
		//Vector는 addElement()메서드를 이용하여 추가할 수도 있는데
		//이 메서드는 기본적으로 add()메서드와 같은 기능을 수행한다.
		
		v1.addElement("ccc");
		System.out.println("v1 => " + v1.toString());
		
		//add(index, 데이터) =>벡터의 index번째에 '데이터'를 끼워넣는다.
		//=> index는 0부터 시작한다.
		v1.add(1, "kkk");
		System.out.println("v1 => " + v1.toString());
		
		//set(index, 데이터) => 벡터의 index번째에 '데이터'를 덮어쓴다.
		//					 => 반환값 : 원래의 데이터
		String temp = (String)v1.set(0, "zzz");
		System.out.println("set명령 후 v1 => " + v1);
		System.out.println("원래의 데이터 : " + temp);
		
		//remove(index) => 벡터의 index번째 자료를 삭제한다.
		//				=> 자료가 삭제되면 index번째 다음번째 이후의 데이터들이
		//				=> 앞으로 자동으로 당겨져서 채워진다.
		//				=> 반환값 : 삭제된 데이터
		
		//remove(삭제할 데이터) => '삭제할 데이터'를 찾아 삭제한다.
		//						=> 만약 '삭제할 데이터'가 여러개이면 앞에서부터 삭제한다.
		//						=> 삭제할 데이터가 '정수형'이거나 'char형'일 경우에는
		//						=> 삭제할 데이터를 객체로 변환해서 사용해야 한다.
		
		v1.remove(0);
		System.out.println("삭제 후 : " + v1);
		System.out.println();
		
		temp = (String)v1.remove(0);
		System.out.println("삭제된 자료 : " + temp);
		System.out.println("삭제 후 : " + v1);
		System.out.println();
		
		v1.add(123);
		v1.remove(true);
		System.out.println("삭제 후 : " + v1);
		System.out.println();
		
		v1.remove(new Integer(123));
		System.out.println("삭제 후 123: " + v1);
		System.out.println();
		
		v1.remove(new Character('a'));
		System.out.println("삭제 후 : " + v1);
		System.out.println();
		
		v1.remove(3.14);
		System.out.println("삭제 후 : " + v1);
		System.out.println();
		 
		//get(index) => index번째 자료를 반환한다.
		int data = (int)v1.get(0);
		System.out.println("0번째 자료 : " + data);
		System.out.println("---------------------------");
		
		System.out.println("---------------벡터 사이즈 및 용량 메서드 예제");
		
		Vector v = new Vector(5); //용량이 5인(사이즈0) 벡터 생성
		v.add("홍길동");
		v.add("박찬호");
		v.add("3");
		print(v);
		
		v.trimToSize(); //벡터의 용량을 현재 벡터 사이즈로 줄인다.
		System.out.println("=== after trimToSize ===");
		print(v);
		
		v.ensureCapacity(5); // 현재 용량이 최소용량보다 작다면, 신규용량 = 현재용량 * 2,
							 // 그래도 최송용량보다 작다면 신규용량 = 최소용량으로 설정된다.
		System.out.println("=== after ensureCapacity(5) ===");
		print(v);
		
		v.setSize(7); //현재용량이 설정 사이즈보다 작으면 신규용량 = 현재용량 * 2,
					  //그래도 설정사이즈보다 작으면 신규용량 = 설정용량으로 설정된다.
		System.out.println("=== after setSize(7) ===");
		print(v);
		
		v.clear();
		System.out.println("=== after clear() ===");
		print(v);
	}

	private static void print(Vector v) {
		System.out.println(v);
		System.out.println("size : " + v.size());
		System.out.println("capacity : " + v.capacity());
		
	}
	
}



















