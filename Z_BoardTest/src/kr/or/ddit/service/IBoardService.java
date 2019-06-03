package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.BoardVO;

/**
 * Service객체는 Dao에 설정된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고, 받아온 자료를 Controller에 전
 * 
 * @author pc14
 *
 */
public interface IBoardService {

	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param memID
	 *            삭제할 회원 ID
	 * @return 작업성공:1, 작업실패:0
	 */
	public int insertBoard(BoardVO bv);


	/**
	 * 회원 ID를 매개변수로 받아서 그 회원 정보를 삭제하는 메서드
	 * 
	 * @param memId
	 *            삭제할 회원 ID
	 * @return 작업성공 : 1 작업실패 : 0
	 */
	public int deleteBoard(int num);


	/**
	 * 하나의 MemberVO자료를 이용하여 DB를 update하는 메서드
	 * 
	 * @param mv
	 *            update할 회원정보가 들어있는 MemberVO 객체
	 * @return 작업성공:1, 작업실패:0
	 */
	public int updateBoard(BoardVO bv);


	/**
	 * DB의 mymember테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드
	 * 
	 * @return MemberVO객체를 담고 있는 List객체
	 */
	public List<BoardVO> getAllBoardList();

	/**
	 * 주어진 회원ID가 존재하는지 여부를 알아내는 메서드
	 * 
	 * @param memId
	 *            검색할 회원 ID
	 * @return 해당 회원ID가 있으면 true, 없으면 false
	 */
	public boolean chkBoardInfo(int num);

	/**
	 * 주어진 회원정보를 이용하여 회원을 검색해주는 메서드
	 * @param mv 검색할 회원정보
	 * @return MemberVO객체를 담고 있는 List객체
	 */
	public List<BoardVO> getSearchBoard(BoardVO bv);

}
