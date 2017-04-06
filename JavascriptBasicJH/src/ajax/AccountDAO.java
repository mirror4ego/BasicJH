package ajax;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


public class AccountDAO {
	protected static SqlSession session = null;  
	AccountDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public List<AccountVO> selectListId () {
		return session.selectList("DAO.AccountDAO.selectId");
	}
}
