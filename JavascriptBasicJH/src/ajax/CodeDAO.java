package ajax;

import org.apache.ibatis.session.SqlSession;

public class CodeDAO {
	protected static SqlSession session = null;  
	CodeDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public CodeVO selectOneCode (String code) {
		return session.selectOne("CodeDAO.selectOneCode", code);
	}
}
