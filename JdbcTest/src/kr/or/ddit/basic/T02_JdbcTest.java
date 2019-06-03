package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T02_JdbcTest {
// 문제1) 사용자로 부터 lprod_id 값을 입력받아 입력한 값보다 lprod_id 가 큰 자료들을 출력하시오
	
// 문제2) lprod_id 값을 2개 입력 받아서 두 값중 작은 값 부터 큰 값 사이의 자료를 출력하시오
	
	
	public static void main(String[] args) {
Connection conn = null;
		
		Statement stmt = null;
		ResultSet rs = null;	 
		Scanner s = new Scanner(System.in);
		System.out.println("id값을 입력해주세여");

		int num1 =s.nextInt();
		int num2  =s.nextInt();
		s.close();
		
		int min;
		int max;
		
		
		if(num1 > num2) {
			max = num1;
			min = num2;
		} else {
			max =num2;
			min = num1;
		}
		
		
		try {		
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 
			 String url ="jdbc:oracle:thin:@localhost:1521/xe";
			 String userId = "pc13";
			 String password = "java";
			 
			 // 실제적으로 OracleDriver가 사용되는 부분
			 conn = DriverManager.getConnection(url, userId, password);  
			 
			 stmt = conn.createStatement();
			 
			 //	String sql ="select * from lprod" +  " where lprod_id >=" + min + "and lprod_id <=" + max;	
			 
			 String sql ="select * from lprod "  + " where lprod_id between " + min + " and " + max;	
			 
			 rs = stmt.executeQuery(sql);
		
			 System.out.println("실행한 쿼리문 : " + sql);
			 System.out.println("******출력*****");
			 

			 while (rs.next()) {
				 
					// if(rs.getInt("lprod_id") > id){
						 System.out.println("lprod_id : " + rs.getInt("lprod_id"));
						 System.out.println("lprod_gu : " + rs.getString(2));
						 System.out.println("lprod_nm : " + rs.getString(3));
					// }
				 
//					 System.out.println("lprod_id : " + rs.getInt(1));
//					 System.out.println("lprod_gu : " + rs.getString(2));
//					 System.out.println("lprod_nm : " + rs.getString(3));
				 }
				 System.out.println("=================================================");
			
			 System.out.println("출력 끝이지롱 ");
	}catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		// 6. 종료(동시에 자원 반납)
		if(rs != null ) 
			try {
				rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			} 
		if(stmt != null ) 
			try {
				stmt.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			} 
		if(conn != null ) 
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			} 
	}
	
	}
	
}
