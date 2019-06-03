package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.VO.BoardVO;

public interface IBoardDao {
	public int insertBoard(BoardVO bv);
	
	public int deleteBoard(int bdNum);
	
	public int updateBoard(BoardVO bv);
	
	public List<BoardVO> getSearchList(int bdNum);
	
	public List<BoardVO> getAllBoardList();
	
	public boolean chkBoardInfo(int bdNum);
}
