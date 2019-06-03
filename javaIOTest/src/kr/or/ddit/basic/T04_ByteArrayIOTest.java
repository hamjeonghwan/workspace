package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04_ByteArrayIOTest {
	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;
		// 자료를 읽을 때 사용할 배열
		byte[] temp = new byte[4];

		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream outPut = new ByteArrayOutputStream();

		try {
			// available() => 읽어 올 수 있는 byte수를 반환
			while (input.available() > 0) {
				// temp배열을 크기만큼 자료를 읽어와 temp배열에 저장한다
				//input.read(temp);
				// temp배열을 크기만큼 출력한다
				//outPut.write(temp);
				//System.out.println(Arrays.toString(temp));
				// 실제 읽어온 byte수를 반환환다
				int len = input.read(temp);
				// temp배열의 내용중에서 0번째 부터 len개수만큼 출력한다
				outPut.write(temp, 0 , len);

				System.out.println("temp : " + Arrays.toString(temp));

			}
			System.out.println();
			outSrc = outPut.toByteArray();
			System.out.println("inSrc => " + Arrays.toString(inSrc));
			System.out.println("outSrc => " + Arrays.toString(outSrc));
			
			input.close();
			outPut.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
