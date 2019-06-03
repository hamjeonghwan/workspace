package kr.or.ddit.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {

	public static void main(String[] args) throws Exception {

		Class<Service> clazz = Service.class;  //Annotation을 사용하는 클래스 객체 생성
		// PrintAnnotation의 static 변수 값 출력하기
		System.out.println(clazz.getAnnotation(PrintAnnotation.class).id);

		// reflection 기능을 이용한 메서드 실행
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		
		for(Method m : declaredMethods) {
			System.out.println(m.getName());  //메서드명 출력
			for(int i=0; i < m.getDeclaredAnnotation(PrintAnnotation.class).count(); i++) { //PrintAnnotation의 count 값 만큼...
				// PrintAnnotation의 value 값 출력 : %, # (줄바꿈 없음)
				System.out.print(m.getDeclaredAnnotation(PrintAnnotation.class).value());
			}
			System.out.println(); //줄바꿈 처리
			m.invoke(new Service());  //reflection기능을 이용한 메서드 실행
		}
	}

}
