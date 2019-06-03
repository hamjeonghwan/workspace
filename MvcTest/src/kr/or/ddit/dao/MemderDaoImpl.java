package kr.or.ddit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.VO.MemberVO;
import kr.or.ddit.util.DBUtil2;

public class MemderDaoImpl implements IMemberDao {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0; // 등록된 데이터 건수
		
		try {
			conn = DBUtil2.getConnection();

			String sql = "insert into mymember (mem_id, mem_name, mem_tel, mem_addr)" + " values(?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMem_id());
			pstmt.setString(2, mv.getMem_name());
			pstmt.setString(3, mv.getMem_tel());
			pstmt.setString(4, mv.getMem_addr());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int deletMember(String memId) {
		int cnt = 0; // 삭제된 건수
		try {

			conn = DBUtil2.getConnection();
		
			String sql = "delete from mymember where mem_id= ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			 cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;
		
		try {
			conn = DBUtil2.getConnection();

			String sql = "update mymember " + " set mem_name = ? " + " ,mem_tel = ? " + " ,mem_addr = ? "
					+ " where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMem_name());
			pstmt.setString(2, mv.getMem_tel());
			pstmt.setString(3, mv.getMem_addr());
			pstmt.setString(4, mv.getMem_id());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> memList = new ArrayList<>();
		try {
			conn = DBUtil2.getConnection();

			stmt = conn.createStatement();

			String sql = "select * from mymember";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberVO memVO = new MemberVO();

				memVO.setMem_id(rs.getString("mem_id"));
				memVO.setMem_name(rs.getString("mem_name"));
				memVO.setMem_tel(rs.getString("mem_tel"));
				memVO.setMem_addr(rs.getString("mem_addr"));

				memList.add(memVO); // 회원정보 한건 추가하기

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return memList;
	}

	@Override
	public boolean chkMemberInfo(String memId) {
		boolean isExist = false;

		try {
			conn = DBUtil2.getConnection();

			String sql = "select count(*) from mymember where mem_id = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			int cnt = 0;

			if (rs.next()) {
				cnt = rs.getInt(1);
			}

			if (cnt > 0) {
				isExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return isExist;
	}

	private void disConnect() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException ee) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException ee) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException ee) {
			}
	}

}
