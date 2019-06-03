package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/*
 * db.Properties 파일의 내용으로 DB정보를 설정하는 방법
 * 방법2) ResourceBundle 객체 이용하기
 * 
 */
public class DBUtil3 {
	static ResourceBundle bundle;  // Properties객체변수 선언
	
	static {
		
		bundle =  ResourceBundle.getBundle("db");
		
		File f =new File("res/db.Properties");
		
		try {
			Class.forName(bundle.getString("driver"));
			
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
			return DriverManager.getConnection(bundle.getString("url"), 
															   bundle.getString("user"), 
															   bundle.getString("pass"));
		}catch(SQLException e) {
			System.out.println("DB연결 실패!!");
			e.printStackTrace();
		}
		return null;

	}

}
