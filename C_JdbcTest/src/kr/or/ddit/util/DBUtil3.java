package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/*
 * JDBC드라이버를 로딩하고 Connection객체를 생성하는 메서드로 구성된 클래스
 * 방법3) ResourceBundle 객체 이용하기
 */
public class DBUtil3 {
	static ResourceBundle bundle; //ResourceBundle 객체 변수 선언
	
	static {
		
		bundle = ResourceBundle.getBundle("db"); //객체 생성
		
		try {
			
			Class.forName("driver");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!");
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
					bundle.getString("url"),
					bundle.getString("user"),
					bundle.getString("pass"));
					
		}catch(SQLException e) {
			System.out.println("DB연결 실패!!");
			e.printStackTrace();
		}
		return null;

	}

}
