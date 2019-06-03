package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T02_JdbcTest {
	/*
	 * 문제1) 사용자로부터 lprod_id값을 입력받아 입력한 값보다 lprod_id가 큰 자료들을 출력하시오.
	 * 
	 * 문제2) lprod_id값을 2개 입력 받아서 두 값 중 작은 값부터 큰 값 사이의 자료를 출력하시오.
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner s = new Scanner(System.in);

		System.out.println("id값을 입력하시오.");
//		int idNum = s.nextInt();
		
		int idNum1 = s.nextInt();
		int idNum2 = s.nextInt();
		
		
		int max, min;
		if(idNum1 > idNum2) {
			max = idNum1;
			min = idNum2;
		}else {
			max = idNum2;
			min = idNum1;
		}

//		혹은
		/*max = Math.max(idNum1, idNum2);
		min = Math.min(idNum1, idNum2);*/
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "pc14";
			String password = "java";
			

			conn = DriverManager.getConnection(url, userId, password);
			stmt = conn.createStatement();
			//String sql = "select * from lprod"; // 실행할 SQL문
//			String sql = "select * from lprod where lprod_id > " + idNum; // 실행할 SQL문
			String sql = "select * from lprod where lprod_id >= " + min + "and lprod_id <= " + max; // 실행할 SQL문
			
			rs = stmt.executeQuery(sql);

			System.out.println("실행한 쿼리문 : " + sql);
			System.out.println("=== 쿼리문 실행 결과 ===");

			while (rs.next()) {
				
			//	if(rs.getInt("lprod_id") >= idNum) {
				
				System.out.println("lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("lprod_gu : " + rs.getString("lprod_gu"));
				System.out.println("lprod_nm : " + rs.getString("lprod_nm"));
				System.out.println("=======================================");
				
			//	}
				
			}

			System.out.println("출력 끝...");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e2) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e2) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e2) {
				}
		}

	}

}
