package ajax;

import java.util.ArrayList;
import java.util.List;

public class Quiz02DAO {
	
	public List<Quiz02VO> selectList () {
		List<Quiz02VO> list = new ArrayList<Quiz02VO>();
		
		Quiz02VO quiz1 = new Quiz02VO();
		quiz1.setId("admin");
		quiz1.setName("관리자");
		quiz1.setPw("4444");
		list.add(quiz1);
		
		Quiz02VO quiz2 = new Quiz02VO();
		quiz2.setId("sul");
		quiz2.setName("설현");
		quiz2.setPw("3333");
		list.add(quiz2);
		
		Quiz02VO quiz3 = new Quiz02VO();
		quiz3.setId("hong1");
		quiz3.setName("홍길동");
		quiz3.setPw("2222");
		list.add(quiz3);
		
		Quiz02VO quiz4 = new Quiz02VO();
		quiz4.setId("hong2");
		quiz4.setName("홍서범");
		quiz4.setPw("1111");
		list.add(quiz4);
		return list;
	}
	
	public Quiz02VO selectOne (String id) {
		List<Quiz02VO> list = new ArrayList<Quiz02VO>();
		
		
		Quiz02VO quiz1 = new Quiz02VO();
		quiz1.setId("admin");
		quiz1.setName("관리자");
		quiz1.setPw("4444");
		list.add(quiz1);
		
		Quiz02VO quiz2 = new Quiz02VO();
		quiz2.setId("sul");
		quiz2.setName("설현");
		quiz2.setPw("3333");
		list.add(quiz2);
		
		Quiz02VO quiz3 = new Quiz02VO();
		quiz3.setId("hong1");
		quiz3.setName("홍길동");
		quiz3.setPw("2222");
		list.add(quiz3);
		
		Quiz02VO quiz4 = new Quiz02VO();
		quiz4.setId("hong2");
		quiz4.setName("홍서범");
		quiz4.setPw("1111");
		list.add(quiz4);
		
		
		
		return quiz4;
	}
}
