package Dao;

import java.util.List;

import VO.LprodVO;
import VO.ProdVO;

public interface prodDao {

	public List<String> LprodName();
	
	public List<String> getAll(String name);
	
	public ProdVO  search(String name);
}
