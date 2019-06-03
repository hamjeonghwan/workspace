package kr.or.ddit.dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {
	
	private SqlMapClient smc;
	
	private static IBoardDao dao;
	
	private BoardDaoImpl() {
		try {
			//1-1. xml 문서 읽어오기
			Reader rd = Resources.getResourceAsReader("sqlMapconfig.xml");
	
			//1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
	
			rd.close();
		}catch(Exception e) {
		
		}
	} //생성자
	
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
			Object obj = smc.insert("insertBoard", bv);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return cnt;
	}


	@Override
	public int deleteBoard(int num) {
		int cnt = 0; //삭제된 데이터 건 수
		
		try {
			cnt = (int)smc.delete("deleteBoard", num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = 0;
		try {
			cnt = (int)smc.update("updateBoard", bv);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = smc.queryForList("getAllBoardList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public boolean chkBoardInfo(int num) {
		boolean isExist = false;
		try {
			Object obj = smc.queryForObject("getSelectBoard", num);
			if(obj!=null) {
				isExist = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return isExist;
	}
	
	

	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = smc.queryForList("getSearchBoard", bv);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return boardList;
	}


	
}
