package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * JDBC드라이버를 로딩하고 Connection객체를 생성하는 메서드로 구성된 클래스
 * 방법2) Properties 이용하기
 */
public class DBUtil2 {
	static Properties prop; //Properties객체 변수 선언
	
	static {
		
		prop = new Properties(); //객체 생성
		File f = new File("res/db.properties");
		
		try {
			FileInputStream fin = new FileInputStream(f);
			prop.load(fin);
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!");
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("파일이 없거나 입출력 오류입니다.");
			e.printStackTrace();
		}
	}

	/**
	 * 커넥션 객체를 요청하는 메서드
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pass"));
					
		}catch(SQLException e) {
			System.out.println("DB연결 실패!!");
			e.printStackTrace();
		}
		return null;

	}

}
