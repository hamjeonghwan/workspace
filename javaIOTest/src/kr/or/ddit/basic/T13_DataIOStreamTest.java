package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 기ㅏ본타입 입출력 보조 스트림 예제
 * 
 * @author pc13
 *
 */

public class T13_DataIOStreamTest {
	public static void main(String[] args) {

		try {
			FileOutputStream fout = new FileOutputStream("d:/D_Other/test.dat");
			DataOutputStream dout = new DataOutputStream(fout);

			dout.writeInt(17);
			dout.writeFloat(3.14f);
			dout.writeDouble(3.14);
			dout.writeBoolean(true);
			System.out.println("출력완료..");
			dout.close();

			FileInputStream fin = new FileInputStream("d:/D_Other/test.dat");
			DataInputStream din = new DataInputStream(fin);

			System.out.println("정수형 자료 : " + din.readInt());
			System.out.println("실수형(Float) 자료 : " + din.readFloat());
			System.out.println("실수형(Double) 자료 : " + din.readDouble());
			System.out.println("논리형 자료 : " + din.readBoolean());

			din.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
