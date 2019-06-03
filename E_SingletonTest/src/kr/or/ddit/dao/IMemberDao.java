package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.MemberVO;

public interface IMemberDao {
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param memID 삭제할 회원 ID
	 * @return 작업성공:1, 작업실패:0
	 */
	public int insertMember(MemberVO mv);

	/**
	 * 회원 ID를 매개변수로 받아서 그 회원 정보를 삭제하는 메서드
	 * 
	 * @param memId
	 *            삭제할 회원 ID
	 * @return 작업성공 : 1 작업실패 : 0
	 */
	public int deleteMember(String memID);
	
	
	/**
	 * 하나의 MemberVO자료를 이용하여 DB를 update하는 메서드
	 * @param mv update할 회원정보가 들어있는 MemberVO 객체
	 * @return 작업성공:1, 작업실패:0
	 */
	
	public int updateMember(MemberVO mv);
	
	/**
	 * DB의 mymember테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드
	 * @return MemberVO객체를 담고 있는 List객체
	 */
	
	public List<MemberVO> getAllMemberList();
	
	/**
	 * 주어진 회원ID가 존재하는지 여부를 알아내는 메서드
	 * @param memId 검색할 회원 ID
	 * @return 해당 회원ID가 있으면 true, 없으면 false
	 */
	
	public boolean chkMemberInfo(String memID);
	

	/**
	 * 주어진 회원정보를 이용하여 회원을 검색해주는 메서드
	 * @param mv 검색할 회원정보
	 * @return MemberVO객체를 담고 있는 List객체
	 */
	public List<MemberVO> getSearchMember(MemberVO mv);



	
}











