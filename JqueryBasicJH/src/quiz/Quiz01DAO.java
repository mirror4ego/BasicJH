package quiz;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.MyAppSqlConfig;

public class Quiz01DAO {
	protected static SqlSession session = null;  
	Quiz01DAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public List<Quiz01VO> selectList () {
		return session.selectList("Quiz01DAO.selectList");
	}
}
