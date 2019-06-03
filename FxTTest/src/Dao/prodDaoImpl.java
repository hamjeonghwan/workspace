package Dao;

import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import VO.LprodVO;
import VO.ProdVO;


public class prodDaoImpl implements prodDao {
	
	
private static prodDao dao;

	
	private SqlMapClient smc;
	
	private prodDaoImpl() {
		try {
		// 1-1. xml문서 읽어오기 
		Reader rd=Resources.getResourceAsReader("SqlMapConfig.xml");
	   //1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성
	 	smc=SqlMapClientBuilder.buildSqlMapClient(rd);
		rd.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//생성자
	
	public static prodDao getInstance() {
		
		if(dao==null) {
			dao=new prodDaoImpl();
		}
	  return dao;	
	}
	

	@Override
	public List<String> LprodName() {
          
		List<String> lpvo=new ArrayList<>();
	
	try { 
		   lpvo=smc.queryForList("allName");
	}catch (SQLException e) {
            e.printStackTrace();
	}
		return lpvo;
	}

	@Override
	public List<String> getAll(String name) {
		 
		  List<String> pd=new ArrayList<>();
         try {
       	    pd =smc.queryForList("getPrdoName",name);  
       	  
         }catch (Exception e) {
           e.printStackTrace();
         }
		
		
		
		return pd;
	}

	@Override
	public ProdVO search(String name) {

		
	
	}

}
