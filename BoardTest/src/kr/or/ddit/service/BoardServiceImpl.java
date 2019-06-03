package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.VO.BoardVO;
import kr.or.ddit.dao.BoardDaoImpl;
import kr.or.ddit.dao.IBoardDao;

public class BoardServiceImpl implements IBoardServe {
	
	private IBoardDao bdDao;
	
	public BoardServiceImpl() {
		bdDao = new BoardDaoImpl();
	}

	@Override
	public int insertBoard(BoardVO bv) {
		return bdDao.insertBoard(bv);
	}

	@Override
	public int deleteBoard(int bdNum) {
		return bdDao.deleteBoard(bdNum);
	}

	@Override
	public int updateBoard(BoardVO bv) {
		return bdDao.updateBoard(bv);
	}

	@Override
	public List<BoardVO> getSearchList(int bdNum) {
		return bdDao.getSearchList(bdNum);
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		return bdDao.getAllBoardList();
	}

	@Override
	public boolean chkBoardInfo(int bdNum) {
		return bdDao.chkBoardInfo(bdNum);
	}

}
