package service;

import java.util.HashMap;
import java.util.List;

import vo.ProdVO;

public interface IProdService {

	public List<String> getLprod();

	public List<String> getProdName(String lPord);

	public List<ProdVO> getProd(HashMap hsmap);

}
