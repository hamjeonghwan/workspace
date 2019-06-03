package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

public class Board {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in); 
	
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 게 시 판 ===");
		System.out.println("  1. 전체목록");
		System.out.println("  2. 새글작성");
		System.out.println("  3. 수정");
		System.out.println("  4. 삭제");
		System.out.println("  5. 검색");
		System.out.println("  0. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	public void start(){
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 전체목록
					displayBoardAll();
					break;
				case 2 :  // 새글작성
					insertBoard();
					break;
				case 3 :  // 글 수정
					updateBoard();
					break;
				case 4 :  // 글 삭제
					deleteBoard();
				case 5 :  // 글 검색
					searchBoard();
					break;
				case 0 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=6);
	}
	
	private void searchBoard() {
		boolean chk = false;
		int num = 0;
		
		do {
			System.out.print("검색할 글 번호를 입력 >> ");
			num = Integer.parseInt(scan.nextLine());
			System.out.println();
			
			chk = chkBoardInfo(num);
			
			if(!chk) {
				System.out.println("없는 글 번호입니다. 다시 입력해주세요.");
			}
			
		}while(!chk);
		
		try {
			conn = DBUtil.getConnection();
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

	private void deleteBoard() {
		displayBoardAll();
		boolean chk = false;
		int num = 0;
		System.out.println();
		do {
		System.out.println("삭제 할 글의 번호를 입력하세요 >> ");
		num = scan.nextInt();
		scan.nextLine();
		System.out.println();
		
		chk = chkBoardInfo(num);
		
		if(!chk) {
			System.out.println("없는 글 번호입니다. 다시 입력해주세요.");
		}
		
		}while(!chk);
		
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				System.out.println(num + "번 글 삭제 성공");
			}else {
				System.out.println(num + "번 글 삭제 실패");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
	}

	/**
	 * 회원정보를 수정하기 위한 메서드
	 */
	private void updateBoard() {
		displayBoardAll();
		boolean chk = false;
		int num = 0; //회원아이디
		
		do {
			System.out.println("수정할 글의 번호를 입력하세요 >> ");
			num= scan.nextInt();
			
			chk = chkBoardInfo(num);
			if(chk==false) {
				System.out.println(num + "번은 없는 게시글입니다.");
				System.out.println("수정할 자료가 없으니 다시 입력해 주세요.");
			}
		}while(chk == false);
		
		System.out.println("수정할 내용을 입력하세요.");
		System.out.println("수정할 제목 >> ");
		String title = scan.next();
		
		System.out.println("수정할 내용 >> ");
		String content = scan.next();
		
		scan.nextLine(); //버퍼 지우기
	
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update jdbc_board" +  
						 " set board_title = ? " + 
						 " ,board_content = ? " + 
						 " where board_no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(num + " 번의 글을 수정했습니다.");
			}else {
				System.out.println(num + " 번의 글을 수정하는데 실패하였습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
	}

	/**
	 * 회원정보를 등록하는 메서드
	 */
	private void insertBoard() {
		boolean chk = false;
		
		System.out.println("작성할 새 글의 정보를 입력하세요.");
		
		System.out.println("제목 >> ");
		String title = scan.next();
		
		System.out.println("작성자 >> ");
		String writer = scan.next();
		
		
		scan.nextLine(); //버퍼 지우기
		System.out.println("내용 >> ");
		String content = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into jdbc_board (board_no, board_title, board_writer, board_date, board_content)"
					+ " values(board_seq.nextVal, ?, ?, sysdate, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(title + " 글이 성공적으로 작성되었습니다!");
			}else {
				System.out.println(title + " 글 작성 실패!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}

	private boolean chkBoardInfo(int num) {
		boolean isExist = false;
		try {
			conn = DBUtil.getConnection();
			String sql = "select count(*) as cnt from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if(cnt > 0) {
				isExist = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return isExist;
	}

	private void displayBoardAll() {
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from jdbc_board";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println();
			System.out.println("-------------------------------------------");
			System.out.println("번호\t제목\t\t작성자\t작성날짜");
			System.out.println("-------------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("board_no") + ".\t" + rs.getString("board_title") + "\t" +
						rs.getString("board_writer") + "\t" + rs.getDate("board_date"));
			}
			System.out.println("-----------------------------");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}

	/**
	 * 자원 반납 (close)를 위한 메서드
	 */
	private void disConnect() {
		//  사용했던 자원 반납
		if(rs!=null)try{ rs.close(); }catch(SQLException ee){}
		if(stmt!=null)try{ stmt.close(); }catch(SQLException ee){}
		if(pstmt!=null)try{ pstmt.close(); }catch(SQLException ee){}
		if(conn!=null)try{ conn.close(); }catch(SQLException ee){}
		
	}

	public static void main(String[] args) {
		Board memObj = new Board();
		memObj.start();
	}

}






