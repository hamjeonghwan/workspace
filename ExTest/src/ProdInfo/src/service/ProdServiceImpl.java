package service;

import java.util.HashMap;
import java.util.List;

import dao.IProdDao;
import dao.ProdDaoImpl;
import vo.ProdVO;

public class ProdServiceImpl implements IProdService {
	
	private IProdDao prodDao;
	
	private static IProdService service;
	
	private ProdServiceImpl() {
		prodDao = ProdDaoImpl.getInstance();
	}
	
	public static IProdService getInstance() {
		if(service == null) {
			service = new ProdServiceImpl();
		}
		
		return service;
	}
	
	@Override
	public List<String> getLprod() {
		return prodDao.getLprod();
	}

	@Override
	public List<String> getProdName(String lPord) {
		return prodDao.getProdName(lPord);
	}

	@Override
	public List<ProdVO> getProd(HashMap hsmap) {
		return prodDao.getProd(hsmap);
	}

}
