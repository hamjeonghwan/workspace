package kr.or.ddit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//싱글턴패턴으로
	private static IBoardDao dao;
	
	private BoardDaoImpl() {} //생성자
	
	public static IBoardDao
	
	getInstance() {
		if(dao == null) {
			dao = new BoardDaoImpl();
		}
		
		return dao;
	}
	

	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = 0;
		try {
			conn = DBUtil2.getConnection();
			String sql = "insert into jdbc_board (board_no, board_title, board_writer, board_date, board_content)"
					+ " values(board_seq.nextVal, ?, ?, sysdate, ?)";
			
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
	public int deleteBoard(int num) {
		int cnt = 0; //삭제된 데이터 건 수
		
		try {
			conn = DBUtil2.getConnection();
			String sql = "delete from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
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
			String sql = "update jdbc_board" +  
					 " set board_title = ? " + 
					 " ,board_content = ? " + 
					 " where board_no = ? ";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoard_title());
			pstmt.setString(2, bv.getBoard_content());
			pstmt.setInt(3, bv.getBoard_no());
			
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> boardList = new ArrayList<>();
		
		
		try {
			conn = DBUtil2.getConnection();
			stmt = conn.createStatement();
			
			String sql = "select * from jdbc_board";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				BoardVO boardVO = new BoardVO();
				
				boardVO.setBoard_no(rs.getInt("board_no"));
				boardVO.setBoard_title(rs.getString("board_title"));
				boardVO.setBoard_writer(rs.getString("board_writer"));
				boardVO.setBoard_date(rs.getString("board_date"));
				boardVO.setBoard_content(rs.getString("board_content"));
				
				boardList.add(boardVO); //회원정보 1건 추가
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return boardList;
	}

	@Override
	public boolean chkBoardInfo(int num) {
		boolean isExist = false;
		try {
			conn = DBUtil2.getConnection();
			String sql = "select count(*) as cnt from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
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
		//  사용했던 자원 반납
		if(rs!=null)try{ rs.close(); }catch(SQLException ee){}
		if(stmt!=null)try{ stmt.close(); }catch(SQLException ee){}
		if(pstmt!=null)try{ pstmt.close(); }catch(SQLException ee){}
		if(conn!=null)try{ conn.close(); }catch(SQLException ee){}
		
	}


	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		List<BoardVO> boardList = new ArrayList<>();
		
		conn = DBUtil2.getConnection();
		
		String sql = "select * from jdbc_board where 1=1 " ;
		if(bv.getBoard_no() != 0) {
			sql += " and board_no = ? ";
		}
		if(bv.getBoard_title() != null && !bv.getBoard_title().equals("")) {
			sql += " and board_title = ? ";
		}
		if(bv.getBoard_writer() != null && !bv.getBoard_writer().equals("")) {
			sql += " and board_writer = ? ";
		}
		if(bv.getBoard_content() != null && !bv.getBoard_content().equals("")) {
			sql += " and board_content like '%' || ? || '%' ";
		}
		
		try{
		pstmt = conn.prepareStatement(sql);
		
		int index=1;
		if(bv.getBoard_no() != 0) {
			pstmt.setInt(index++, bv.getBoard_no());
		}
		if(bv.getBoard_title() != null && !bv.getBoard_title().equals("")) {
			pstmt.setString(index++, bv.getBoard_title());
		}
		if(bv.getBoard_writer() != null && !bv.getBoard_writer().equals("")) {
			pstmt.setString(index++, bv.getBoard_writer());
		}
		if(bv.getBoard_content() != null && !bv.getBoard_content().equals("")) {
			pstmt.setString(index++, bv.getBoard_content());
		}
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			BoardVO boardVO = new BoardVO();
			
			boardVO.setBoard_no(rs.getInt("board_no"));
			boardVO.setBoard_title(rs.getString("board_title"));
			boardVO.setBoard_writer(rs.getString("board_writer"));
			boardVO.setBoard_content(rs.getString("board_content"));
			
			boardList.add(boardVO); //회원정보 1건 추가
		}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return boardList;
	}


	
}
