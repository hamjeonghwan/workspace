package dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.ProdVO;

public class ProdDaoImpl implements IProdDao {
	
	private static ProdDaoImpl dao;
	
	private SqlMapClient smc;
	
	private ProdDaoImpl() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static IProdDao getInstance() {
		if(dao == null) {
			dao = new ProdDaoImpl();
		}
		return dao;
	}

	@Override
	public List<String> getLprod() {
		List<String> lProdList = new ArrayList<>();
		
		try {
			lProdList = smc.queryForList("getLprod");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lProdList;
	}

	@Override
	public List<String> getProdName(String lPord) {
		List<String> ProdNameList = new ArrayList<>();
		
		try {
			ProdNameList = smc.queryForList("getProdName", lPord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ProdNameList;
	}

	@Override
	public List<ProdVO> getProd(HashMap hsmap) {
		List<ProdVO> prodList = new ArrayList<>();
		
		try {
			prodList = smc.queryForList("getProd", hsmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return prodList;
	}
	
	
}
