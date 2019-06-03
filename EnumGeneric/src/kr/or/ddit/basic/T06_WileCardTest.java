package kr.or.ddit.basic;

import java.util.Arrays;

// 와일드카드 타입 예제 
public class T06_WileCardTest {
	// 모든 과정등록
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + "수강생 : " + Arrays.toString(course.getstudents()));
	}

	// 학생 과정등록
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + "수강생 : " + Arrays.toString(course.getstudents()));
	}

	// 직장인 과정등록
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + "수강생 : " + Arrays.toString(course.getstudents()));
	}

	public static void main(String[] args) {
		Course<Person> personCoures = new Course("일반인과정", 5);
		personCoures.add(new Person("일반인1"));
		personCoures.add(new Worker("직장인1"));
		personCoures.add(new Student("학생1"));
		personCoures.add(new HighStudent("고등학생1"));

		Course<Worker> workerCoures = new Course("직장인과정", 5);
		workerCoures.add(new Worker("직장인"));

		Course<Student> studentCoures = new Course("학생과정", 5);
		studentCoures.add(new Student("학생1"));
		studentCoures.add(new HighStudent("고등학생1"));

		Course<HighStudent> highStudentCoures = new Course("고등학생과정", 5);
		highStudentCoures.add(new HighStudent("고등학생1"));

		System.out.println("===========================================");
		registerCourse(personCoures);
		registerCourse(workerCoures);
		registerCourse(studentCoures);
		registerCourse(highStudentCoures);

		System.out.println();
		System.out.println("===========================================");

		// registerCourseStudent(personCoures);
		// registerCourseStudent(workerCoures);
		registerCourseStudent(studentCoures);
		registerCourseStudent(highStudentCoures);

		System.out.println();
		System.out.println("===========================================");

		registerCourseWorker(personCoures);
		registerCourseWorker(workerCoures);
		// registerCourseWorker(studentCoures);
		// registerCourseWorker(highStudentCoures);

		System.out.println();
		System.out.println("===========================================");

	}
}

class Course<T> {
	private String name; // 코스명
	private T[] students; // 수강생 배열

	public Course(String name, int capacity) {
		this.name = name;
		// 타입 파라미터로 배열을 생성시 오브젝트 배열을 생성후, 타입파라미터 배열로 캐스팅 처리해야함
		students = (T[]) (new Object[capacity]);
	}

	public String getName() {
		return name;
	}

	public T[] getstudents() {
		return students;
	}

	public void add(T t) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}
}

class Person {
	String name; // 이름

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "이름 : " + name;
	}
}

// 직장인
class Worker extends Person {

	public Worker(String name) {
		super(name);
	}
}

class Student extends Person {

	public Student(String name) {
		super(name);
	}
}

class HighStudent extends Student {

	public HighStudent(String name) {
		super(name);
	}
}