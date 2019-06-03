package kr.or.ddit.member.dao;

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

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.DBUtil2;

public class MemberDaoImpl implements IMemberDao {
	
	private static IMemberDao dao;
	
	private SqlMapClient smc;
	
	private MemberDaoImpl() {
		try {
			//1-1. xml 문서 읽어오기
			Reader rd = Resources.getResourceAsReader("sqlMapconfig.xml");
		
			//1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		
			rd.close();
		}catch(Exception e) {
			
		}
	} //생성자
	
	public static IMemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}
	

	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("memberTest.insertMember", mv);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}


	@Override
	public int deleteMember(String memID) {
		int cnt = 0; //삭제된 데이터 건 수
		
		try {
			cnt = (int)smc.delete("memberTest.deleteMember", memID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;
		
		try {
			cnt = (int)smc.update("memberTest.updateMember", mv);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memList = new ArrayList<>();
		
		try {
			memList = smc.queryForList("getAllMemberList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public boolean chkMemberInfo(String memID) {
		boolean isExist = false;
		try {
			Object obj = smc.queryForObject("getSelectMember", memID);
			if(obj!=null) {
				isExist = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return isExist;
	}


	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<>();
		
		try {
			memList = smc.queryForList("getSearchMember", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return memList;
	}


	
}
