package kr.or.ddit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.VO.BoardVO;
import kr.or.ddit.util.DBUtil2;

public class BoardDaoImpl implements IBoardDao {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = 0;
		
		try {
			conn = DBUtil2.getConnection();
			String sql = "insert into jdbc_board(board_no, board_title, board_writer,"
					+ " board_date, board_content) values(board_seq.nextval, ?, ?, sysdate, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bv.getBoard_title());
			pstmt.setString(2, bv.getBoard_writer());
			pstmt.setString(3, bv.getBoard_content());
			
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int bdNum) {
		int cnt = 0;
		
		try {
			conn = DBUtil2.getConnection();
			String sql = "delete from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bdNum);
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = 0;
		
		try {
			conn = DBUtil2.getConnection();
			String sql = "update jdbc_board set board_title = ?, board_date = sysdate, board_content = ? where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoard_title());
			pstmt.setString(2, bv.getBoard_content());
			pstmt.setInt(3, bv.getBoard_num());
			
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getSearchList(int bdNum) {
		List<BoardVO> bdList = new ArrayList<>();
		int cnt = 0;
		
		try {
			conn = DBUtil2.getConnection();
			String sql = "select * from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bdNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO bdVO = new BoardVO();
				
				bdVO.setBoard_num(rs.getInt(1));
				bdVO.setBoard_title(rs.getString(2));
				bdVO.setBoard_writer(rs.getString(3));
				bdVO.setBoard_date(rs.getString(4));
				bdVO.setBoard_content(rs.getString(5));
				
				bdList.add(bdVO); // 회원정보 한건 추가
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return bdList;
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> bdList = new ArrayList<>();
		
		try {
			conn = DBUtil2.getConnection();
			
			stmt = conn.createStatement();
			
			String sql = "select * from jdbc_board";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO bdVO = new BoardVO();
				
				bdVO.setBoard_num(rs.getInt(1));
				bdVO.setBoard_title(rs.getString(2));
				bdVO.setBoard_writer(rs.getString(3));
				bdVO.setBoard_date(rs.getString(4));
				bdVO.setBoard_content(rs.getString(5));
				
				bdList.add(bdVO); // 회원정보 한건 추가
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return bdList;
	}

	@Override
	public boolean chkBoardInfo(int bdNum) {
		boolean isExist = false;
		
		try {
			conn = DBUtil2.getConnection();
			String sql = "select count(*) from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdNum);
			rs = pstmt.executeQuery();
			int cnt = 0;
			
			if(rs.next()) {
				cnt = rs.getInt(1);
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

	private void disConnect() {
		if(rs!=null) try {rs.close();} catch(SQLException e2) {}
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e2) {}
		if(stmt!=null) try {stmt.close();} catch(SQLException e2) {}
		if(conn!=null) try {conn.close();} catch(SQLException e2) {}
	}
}
