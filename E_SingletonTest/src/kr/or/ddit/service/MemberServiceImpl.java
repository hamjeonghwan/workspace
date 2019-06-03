package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.IMemberDao;
import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	
	//사용할 DAO의 객체변수를 선언한다.
	private IMemberDao memDao;
	
	private static IMemberService service;
	
	private MemberServiceImpl() {
		memDao = MemberDaoImpl.getInstance(); //DAO객체 생성
	}
	
	public static IMemberService getInstance() {
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	
	//각 메서드에서는 생성된 Dao객체를 이용하여 작업에 맞는 DAO객체의 메서드를 호출한다.
	

	@Override
	public int insertMember(MemberVO mv) {
		return memDao.insertMember(mv);
	}

	@Override
	public int deleteMember(String memID) {
		return memDao.deleteMember(memID);
	}

	@Override
	public int updateMember(MemberVO mv) {
		return memDao.updateMember(mv);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		return  memDao.getAllMemberList();
	}

	@Override
	public boolean chkMemberInfo(String memID) {
		return memDao.chkMemberInfo(memID);
	}

	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		return memDao.getSearchMember(mv);
	}

}
