package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class T03_JdbcTest {
	// lprod_id : 101, lprod_gu : N101, lprod_nm : 농산물
	// lprod_id : 102, lprod_gu : N102, lprod_nm : 수산물
	// lprod_id : 103, lprod_gu : N103, lprod_nm : 축산물
	// 자료추가

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		// PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "pc13";
			String password = "java";

			// 실제적으로 OracleDriver가 사용되는 부분
			conn = DriverManager.getConnection(url, userId, password);
			// Statement 객체를 이용한 자료 추가 방법

			stmt = conn.createStatement();

			//String sql = "INSERT INTO lprod (lprod_id, LPROD_GU, LPROD_NM) " + " VALUES (101,  'N101',  '농산물')";
			String sql = "create table lprod2 ( COL1 DATE, COL2 DATE)";
			
			// executeUpdata() 메서드는 실행에 필요한 레코드를 반환한다

			int cnt = stmt.executeUpdate(sql);
			System.out.println("첫번째 반환값 : " + cnt);

			sql = "INSERT INTO lprod (lprod_id, LPROD_GU, LPROD_NM) " + " VALUES (102,  'N102',  '수산물')";

			// executeUpdata() 메서드는 실행에 필요한 레코드를 반환한다

			cnt = stmt.executeUpdate(sql);
			System.out.println("두번째 반환값 : " + cnt);

			sql = "INSERT INTO lprod (lprod_id, LPROD_GU, LPROD_NM) " + " VALUES (103,  'N103',  '축산물')";

			// executeUpdata() 메서드는 실행에 필요한 레코드를 반환한다

			cnt = stmt.executeUpdate(sql);
			System.out.println("세번째 반환값 : " + cnt);

			// String sql ="select * from lprod" + " where lprod_id >=" + min + "and
			// lprod_id <=" + max;

			// String sql ="select * from lprod " + " where lprod_id between " + min + " and
			// " + max;
			// String sql = "INSERT INTO lprod (lprod_id, LPROD_GU, LPROD_NM)" + " VALUES
			// (?, ?, ?)";
			// pstmt = conn.prepareStatement(sql);
			// 쿼리문의 물음표 자리에 들어가 데이터를 셋팅한다
			// 형식 pstmt.set 자료형 이름 (물음표순번, 데이터)
			// 1번부터 시작한다
			// System.out.println("실행한 쿼리문 : " + sql);
			//
			// pstmt.setInt(1, 101);
			// pstmt.setString(2, "N101");
			// pstmt.setString(3, "농산물");
			//
			// int cnt = pstmt.executeUpdate();
			// System.out.println("첫번째 반환값 : " + cnt);
			//
			// pstmt.setInt(1, 102);
			// pstmt.setString(2, "N102");
			// pstmt.setString(3, "수산물");
			//
			// cnt = pstmt.executeUpdate();
			// System.out.println("두번째 반환값 : " + cnt);
			//
			// pstmt.setInt(1, 103);
			// pstmt.setString(2, "N103");
			// pstmt.setString(3, "축산물");
			//
			// cnt = pstmt.executeUpdate();
			// System.out.println("세번째 반환값 : " + cnt);

			// String sql1 = "select * from lprod ";
			// rs = stmt.executeQuery(sql1);

			// while (rs.next()) {
			// System.out.println("lprod_id : " + rs.getInt("lprod_id"));
			// System.out.println("lprod_gu : " + rs.getString(2));
			// System.out.println("lprod_nm : " + rs.getString(3));
			// }
			// System.out.println("=================================================");
			//
			System.out.println("출력 끝이지롱 ");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 6. 종료(동시에 자원 반납)
			// if(rs != null )
			// try {
			// rs.close();
			// } catch (SQLException e2) {
			// e2.printStackTrace();
			// }
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
