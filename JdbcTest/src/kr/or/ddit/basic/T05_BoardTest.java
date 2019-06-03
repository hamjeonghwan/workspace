package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;

/*
 *  기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
 */

public class T05_BoardTest {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Scanner s = new Scanner(System.in);
	
	
	public void main() {
		boolean isExist = true;
		while(isExist) {
			System.out.println("------------------------------------");
			System.out.println("\t\t게시판");
			System.out.println("------------------------------------");
			System.out.println("  1. 전체 목록 출력");
			System.out.println("  2. 새 글 작성");
			System.out.println("  3. 수정");
			System.out.println("  4. 삭제");
			System.out.println("  5. 검색");
			System.out.println("  0. 종료");
			System.out.println();
			System.out.print("번호 선택 >> ");
			int num = Integer.parseInt(s.nextLine());
			switch(num) {
				case 1:
					printTitle();
					break;
				case 2:
					newWrite();
					break;
				case 3:
					modify();
					break;
				case 4:
					delete();
					break;
				case 5:
					search();
					break;
				case 0:
					System.out.println(" << 게시판을 닫습니다. >> ");
					System.out.println();
					isExist = false;
					break;
				default:
					System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
					System.out.println();
					break;
			}
		}
	}

	private void search() {
		boolean chk = false;
		int num = 0;
		
		do {
			System.out.print("검색할 글 번호를 입력 >> ");
			num = Integer.parseInt(s.nextLine());
			System.out.println();
			
			chk = chkNumber(num);
			
			if(!chk) {
				System.out.println("없는 글 번호입니다. 다시 입력해주세요.");
			}
			
		}while(!chk);
		
		try {
			conn = DBUtil2.getConnection();
			String sql = "select * from jdbc_board where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			System.out.println("-------------------------------------------");
			System.out.println("번호\t제목\t\t작성자\t작성날짜");
			System.out.println("-------------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("board_no") + ".\t" + rs.getString("board_title") + "\t\t" +
						rs.getString("board_writer") + "\t" + rs.getDate("board_date"));
				System.out.println("   < 내용 > " + rs.getString("board_content"));
			}
			System.out.println();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
	}

	private void modify() {
		printTitle();
		boolean chk = false;
		int num = 0;
		
		do {
			System.out.print("수정할 글 번호를 입력 >> ");
			num = Integer.parseInt(s.next());
			s.nextLine();
			System.out.println();
			
			chk = chkNumber(num);
			
			if(!chk) {
				System.out.println("없는 글 번호입니다. 다시 입력해주세요.");
			}
			
		}while(!chk);
		
		System.out.print("수정할 제목 입력 >> ");
		String title = s.nextLine();
		System.out.print("수정할 내용 입력 >> ");
		String content = s.nextLine();
		
				
		try {
			conn = DBUtil2.getConnection();
			
			String sql = "update jdbc_board set board_title = ?, board_content = ?, board_date = sysdate"
					+ " where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("수정이 완료되었습니다.");
			}else {
				System.out.println("수정에 실패하였습니다.");
			}
						
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}

	private boolean chkNumber(int num) {
		boolean chk = false;
		
		try {			
			conn = DBUtil2.getConnection();
			
			String sql = "select count(*) as cnt from jdbc_board where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
			if(cnt > 0) {
				chk = true;
			}
						
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return chk;
		
	}

	private void delete() {
		printTitle();
		boolean chk = false;
		int num = 0;
		
		do {
		System.out.print("삭제할 글 번호를 입력 >> ");
		num = Integer.parseInt(s.next());
		s.nextLine();
		System.out.println();
		
		chk = chkNumber(num);
		
		if(!chk) {
			System.out.println("없는 글 번호입니다. 다시 입력해주세요.");
		}
		
		}while(!chk);
		
		try {
			
			conn = DBUtil2.getConnection();
			
			String sql = "delete from jdbc_board where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("삭제가 성공적으로 이루어졌습니다.");
			}else {
				System.out.println("삭제가 실패되었습니다.");
			}
			System.out.println();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}

	private void printTitle() {

		try {
			
			conn = DBUtil2.getConnection();
			
			String sql = "select * from jdbc_board";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("-------------------------------------------");
			System.out.println("번호\t제목\t\t작성자\t작성날짜");
			System.out.println("-------------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("board_no") + ".\t" + rs.getString("board_title") + "\t\t" +
						rs.getString("board_writer") + "\t" + rs.getDate("board_date"));
			}
			System.out.println();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
	}

	private void newWrite() {
		System.out.print("작성자 이름 입력 >> ");
		String writer = s.nextLine();
		System.out.print("제목 입력 >> ");
		String title = s.nextLine();
		System.out.print("내용 입력 >> ");
		String content = s.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			
			String sql = "insert into jdbc_board (board_no, board_title, board_writer, board_date, board_content)"
					+ " values(board_seq.nextVal, ?, ?, sysdate, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("글이 정상적으로 등록되었습니다.");
			}else {
				System.out.println("등록이 실패했습니다.");
			}
			System.out.println();
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}
	
	private void disConnect() {
		if(rs!=null)try{ rs.close(); }catch(SQLException ee){}
		if(stmt!=null)try{ stmt.close(); }catch(SQLException ee){}
		if(pstmt!=null)try{ pstmt.close(); }catch(SQLException ee){}
		if(conn!=null)try{ conn.close(); }catch(SQLException ee){}
	}

	public static void main(String[] args) {
		T05_BoardTest b = new T05_BoardTest();
		b.main();
	}

}
