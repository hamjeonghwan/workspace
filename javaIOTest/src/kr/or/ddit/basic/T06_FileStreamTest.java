package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 파일 출력 예제
 * @author pc13
 *
 */
public class T06_FileStreamTest {
	public static void main(String[] args) {
		
		FileOutputStream fout = null;
		
		
		
			try {
				// 출력용 OutputStream객체 생성
				fout = new FileOutputStream("d:/D_Other/out.txt");
				for(char ch='a'; ch<='z'; ch++) {
					fout.write(ch);
				}
				System.out.println("파일에 쓰기작업 완료...");
				
				// 파일쓰기 작업 완료 후 스트림 닫기
				fout.close();
				
				//===================================
				
				// 저장된 파일 내용을 읽어와 화면에 출력하기
				FileInputStream fin = new FileInputStream("d:/D_Other/out.txt");
				int c;
				while((c=fin.read())!=-1) {
					// 읽어온 자료 출력하기
					System.out.print((char)c);
				}
				System.out.println();
				System.out.println("출력 끝...");
				fin.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("파일이 없습니다...");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("알수 없는 오류 발생...");
				e.printStackTrace();
			}
		
	}
}
