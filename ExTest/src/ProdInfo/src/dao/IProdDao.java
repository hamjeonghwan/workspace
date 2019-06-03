package dao;

import java.util.HashMap;
import java.util.List;

import vo.ProdVO;

public interface IProdDao {

	public List<String> getLprod();
	
	public List<String> getProdName(String lPord);
	
	public List<ProdVO> getProd(HashMap hsmap);
	
	
}