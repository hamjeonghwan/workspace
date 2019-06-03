package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.VO.MemberVO;
import kr.or.ddit.dao.IMemberDao;
import kr.or.ddit.dao.MemderDaoImpl;

public class MemberServiceImpl implements IMemberService {
	// 사용할 DAO의 객체변수를 선언한다
	private IMemberDao memDao;

	public MemberServiceImpl() {
		memDao = new MemderDaoImpl(); // DAO객체 생성

	}
	// 각 메서드에서는 생성된 Dao객체를 이용하여 작업에 맞는 DAO객체의 메서드를 호출한다 
	
	@Override
	public int insertMember(MemberVO mv) {

		return memDao.insertMember(mv);
	}

	@Override
	public int deletMember(String memId) {
		return memDao.deletMember(memId);
	}

	@Override
	public int updateMember(MemberVO mv) {
		return memDao.updateMember(mv);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return memDao.getAllMember();
	}

	@Override
	public boolean chkMemberInfo(String memId) {
		return memDao.chkMemberInfo(memId);
	}

}
