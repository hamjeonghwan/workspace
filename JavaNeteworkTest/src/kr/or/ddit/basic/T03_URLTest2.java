package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class T03_URLTest2 {
	public static void main(String[] args) throws IOException {
		// URLConnection => 애플리케이션과 URL간의 통신 연결을 위한 추상클래스
		
		// 특정서버의 정보와 파일내용을 출력하는 예제
		URL url = new URL("https://www.naver.com/index.html");
		
		// Header 정보 가져오기 
		
		// URLConnection 객체 구하기
		URLConnection urlConnection = url.openConnection();
		
		System.out.println("Cntent-Type : " + urlConnection.getContentType());
		System.out.println("Encoding : " + urlConnection.getContentEncoding());
		System.out.println("Cotent : " + urlConnection.getContent());
		System.out.println();
		
		Map<String, List<String>> headerMap = urlConnection.getHeaderFields();
		
		Iterator<String> iterator = headerMap.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " : " + headerMap.get(key));
		}
		System.out.println("---------------------------------------------------------");
		
		// 해당 호스트의 페이지 내용 가져오기
		
		// 방법 1=> URLConnection의 getInpStream메서드 이용하기
		
		// 파일을 읽어오기 위한 스트림생성
		InputStream inputStream = urlConnection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8" );
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		// 내용 출력하기
		while(true) {
			String str = bufferedReader.readLine();
			if(str == null) break;
			System.out.println(str);
		}
		bufferedReader.close();
		
		// 방법 2=> URL객체의 OpenStream() 메서드 이용하기
		// 파일을 읽어오기 위한 스트림 생성
		InputStream inputStream2 = url.openStream();
		InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream2, "utf-8");
		BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
		
		
		// 내용 출력하기
		while(true) {
			String str = bufferedReader2.readLine();
			if(str == null) break;
			System.out.println(str);
		}
		bufferedReader2.close();
		
	}
}
