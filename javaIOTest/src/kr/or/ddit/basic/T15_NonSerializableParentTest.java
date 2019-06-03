package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *  부모클래스가 Serializable 인터페이스를 구현하고 있지 않을 경우
 *  부모객체의 필드값 처리방법
 *  1. 부모클래스가 Serializable인터페이스를 구현하도록 해야한다
 *  2. 자식클래스에 writeObject()와 readObject() 메서드를 이용하여 부모객체의 
 *     필드값을 처리할 수 있도록 직접 구현한다  
 * @author pc13
 *
 */
public class T15_NonSerializableParentTest {
	public static void main(String[] args)  throws Exception {

			FileOutputStream fos = new FileOutputStream("d:/D_Other/nonSerializableTest");
	
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				Child child = new Child();
				child.parentNaem = "부모";
				child.childName = "자식";
				oos.writeObject(child);
				oos.flush();
				oos.close();
				fos.close();
				
				FileInputStream fis = new FileInputStream("d:/D_Other/nonSerializableTest");
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				//역직렬화
				Child child2 = (Child)ois.readObject();
				System.out.println("parentName : " + child2.parentNaem);
				System.out.println("childName : " + child2.childName);
				ois.close();
				fis.close();
						
	}
}
/**
 * Serializable을 구현하지 않은 부모클래스 
 * @author pc13
 *
 */
class Parent {
	public String parentNaem;
}
/**
 * 직렬화 될때 자동으로 호출됨
 * (접근 제한자가 private이 아니면 자동 호출되지 않음)
 * Serializable을 구현한 자식 클래스
 * @author pc13
 *
 */
@SuppressWarnings("serial")
class Child extends Parent implements Serializable {
	 public String childName;
	 
	 private void writeObject(ObjectOutputStream out) throws IOException {
		 // ObjectOutputStream 객체의 메서드를 이용하여 부모객체 필드값 처리
		 out.writeUTF(parentNaem);
		 
		 out.defaultWriteObject();
		 
	 }
/**
 *  역직렬화 될떄 자동으로 호출됨
 *  (접근 제한자가 private이 아니면 자동 호출되지 않음)
 * @param in
 * @throws IOException
 * @throws ClassNotFoundException
 */
	 private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		 // ObjectInputStream 객체의 메서드를 이용하여 부모객체 필드값 처리
		 parentNaem = in.readUTF();
		 
		 in.defaultReadObject();
		 
	 }
	 
}
