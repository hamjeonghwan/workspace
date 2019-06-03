package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class T03_JdbcTest2 {

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "pc13";
			String password = "java";

			// 실제적으로 OracleDriver가 사용되는 부분
			conn = DriverManager.getConnection(url, userId, password);
			
			// Statement 객체를 이용한 자료 추가 방법

			stmt = conn.createStatement();
			
			String sql = "CREATE TABLE NAMECARD ( " +
				        "NO  NUMBER CONSTRAINT PK_NAMECARD PRIMARY KEY, " +
				        "NAME    VARCHAR2(20) NOT NULL, " +
				        "MOBILE  VARCHAR2(20) NOT NULL, " +
				        "AGE CHAR(10) NOT NULL," +
				        "COMPANY VARCHAR2(60))";
			
			  sql = "INSERT INTO NAMECARD (NO, NAME, MOBILE, AGE, COMPANY) "  + " VALUES(10, '상근이', '010-0000-0000', 26, '인재개발원')";
			
			//stmt.executeUpdate(sql);
			//sql = "INSERT INTO lprod2 (COL1, name)" + "VALUES (sysdate,  '전성희')"; 
			
		    
//			int cnt = stmt.executeUpdate(sql);
//			System.out.println("들어갔나요~ : " + cnt);
		sql = " select * from NAMECARD ORDER BY NO ASC";
//			
			 rs = stmt.executeQuery(sql);
//			 
		 while (rs.next()) {
			 int no = rs.getInt("no");
             String name = rs.getString("name");
             String mobile = rs.getString("mobile");
             int AGE = rs.getInt("AGE");
             String company = rs.getString("company");
             
             System.out.println(no + " | " + name + " | " + mobile + " | " + AGE + " | " + company);
             System.out.println("-----------------------------------------------------");
        	}
			 System.out.println("출력 끝이지롱 ");
			
		} catch (SQLException e) {
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
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
		}

	}

}
