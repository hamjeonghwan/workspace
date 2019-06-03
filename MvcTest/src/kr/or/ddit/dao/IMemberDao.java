package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.VO.MemberVO;

// 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여 service에 전달하는 DAO의 interface

public interface IMemberDao {
	
	public int insertMember(MemberVO mv);
	/**
		MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	 	@param mv DB에 insert할 자료가 저장된 MemberVO객체
	 	@return DB작업이 성공하면 1이상의 값이 반환되고 실패하면 0이 반환된다
	 * 
	 */
	public int deletMember(String memId);
	/**
	 * 회원 ID를 매개변수로 받아서 그 회원 정보를 삭제하는 메서드
	 * 	@param memId 삭제할 회원 ID
	 *  @return  작업성공 : 1 작업실패 : 0
	 */
	public int updateMember(MemberVO mv);
	/**
	 * 하나의 MemberVO 자료를 이용하여 DB를 update 하는 메서드
	 * @param mv update할 회원정보가 들어가 있는 MemberVO객체
	 * @return 작업성공 : 1 작업실패 : 0
	 */
	public List<MemberVO> getAllMember();
	/**
	 * DB의 mymember테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드
	 * @return MemberVO객체를 담고 있는 List객체
	 */
	public boolean chkMemberInfo(String memId);
	/**
	 * 주어진 회원ID가 존재하는지 여부를 알아내는 메서드
	 * @param memId 검색할 ID
	 * @return 해당회원 ID가 있으면 true 없으면 false
	 */
}
