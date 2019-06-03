package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.IBoardDao;
import kr.or.ddit.dao.BoardDaoImpl;
import kr.or.ddit.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	
	//사용할 DAO의 객체변수를 선언한다.
	private IBoardDao boardDao;
	
	private static IBoardService service;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance(); //DAO객체 생성
	}
	
	public static IBoardService getInstance() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	//각 메서드에서는 생성된 Dao객체를 이용하여 작업에 맞는 DAO객체의 메서드를 호출한다.
	

	@Override
	public int insertBoard(BoardVO bv) {
		return boardDao.insertBoard(bv);
	}

	@Override
	public int deleteBoard(int num) {
		return boardDao.deleteBoard(num);
	}

	@Override
	public int updateBoard(BoardVO bv) {
		return boardDao.updateBoard(bv);
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		return boardDao.getAllBoardList();
	}

	@Override
	public boolean chkBoardInfo(int num) {
		return boardDao.chkBoardInfo(num);
	}

	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		return boardDao.getSearchBoard(bv);
	}

}
