package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T03_BytrArrayIOTest {
	public static void main(String[] args) {
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;

		// 스트림 선언 및 객체 생성
		ByteArrayInputStream input = null;
		input = new ByteArrayInputStream(inSrc);
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		// 읽어온 자료를 저장할 변수
		int data;
		
		// read()메서드 => byte 단위로 자료를 읽어와 int형으로 반환한다
		// 						  더이상 읽어올 자료가 없으면 -1을 반환한다
		while((data=input.read()) != -1) {
			output.write(data);
		}
		
		// 출력된 스트림 값들을 배열로 변환해서 반화하는 메서드
		outSrc = output.toByteArray();
		
		System.out.println("inSrc => " + Arrays.toString(inSrc));
		System.out.println("outSrc => " + Arrays.toString(outSrc));
		
		try {
			input.close();
			output.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
