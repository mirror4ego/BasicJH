package kr.co.mlec.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.member.MemberVO;
import kr.co.mlec.member.SearchVO;

public class MemberMapper {

	private static SqlSession sqlMapper;

	public MemberMapper() throws Exception {
		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();

		// System.out.println(sqlMapper);
//		 test01();
//		 test02();
//		 insertMember();
//		 updateMember();
//		 deleteMember();
//		 selectForeach();
		 dynamicSelect();
	}

	/*
	 * 결과값이 하나인 Object타입
	 */
	public void test01() throws Exception {
		
//		int s = sqlMapper.selectOne("getMemberInfo4");
		System.out.printf(sqlMapper.selectOne("getMemberInfo4"));
	
		
//		MemberVO param = new MemberVO();
//		param.setName("sbc");
//		param.setEmail("sbc@yahoo.co.kr");
//		String id = sqlMapper.selectOne("kr.co.mlec.member.dao.MemberMapper.getMemberInfo3", param);
//		System.out.println("id : " + id);
		
		
		// MemberVO memberInput = new MemberVO();
		// MemberVO memberOutput = new MemberVO();
		// memberInput.setEmail("sbc@yahoo.co.kr");
		// memberInput.setName("sbc");
		// memberOutput =
		// sqlMapper.selectOne("kr.co.mlec.member.dao.MemberMapper.getMemberInfo2",
		// memberInput);
		// System.out.println(memberOutput.getId());
		// System.out.println(memberOutput.getEmail());
		// System.out.println(memberOutput.getAddrs());
		// System.out.println(memberOutput.getName());

		// MemberVO member = sqlMapper.selectOne(
		// "kr.co.mlec.member.dao.MemberMapper.getMemberInfo1",
		// "member-1");
		// System.out.println(member.getId());
		// System.out.println(member.getEmail());
		// System.out.println(member.getAddrs());
		// System.out.println(member.getName());
		
		
		/*
		 * Connection con = null; PreparedStatement pstmt = null;
		 * 
		 * try { Class.forName("oracle.jdbc.driver.OracleDriver"); con =
		 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
		 * "hr", "hr"); String sql = "select id, name, email, addr" +
		 * "  from mybatis_member       " + " where id = ? "; pstmt =
		 * con.prepareStatement(sql); pstmt.setString(1, "member-1"); ResultSet
		 * rs = pstmt.executeQuery(); if(rs.next()) { MemberVO member = new
		 * MemberVO(); member.setAddr(rs.getString("addr"));
		 * member.setId(rs.getString("id"));
		 * member.setEmail(rs.getString("email"));
		 * member.setName(rs.getString("name")); } } catch (Exception e) {
		 * e.printStackTrace(); } finally { if (pstmt != null) { try {
		 * pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } } if
		 * (con != null) { try { con.close(); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 * 
		 * } }
		 */

	}

	private void test02() throws Exception {
//		List<MemberVO> list = sqlMapper.selectList("kr.co.mlec.member.dao.MemberMapper.getMemberList1");
		List<MemberVO> list = sqlMapper.selectList("kr.co.mlec.member.dao.MemberMapper.getMemberList2");
		for (MemberVO member : list) {
			System.out.println("id : " + member.getId());
			System.out.println("joinDate : " + member.getJoinDate());
		}
	}

	private void insertMember() throws Exception {
		MemberVO param = new MemberVO();
		param.setId("member-5");
		param.setName("kiki");
		param.setAddr("seoul");
		param.setEmail("member-5@a.com");
		sqlMapper.insert("kr.co.mlec.member.dao.MemberMapper.insertMember", param);
		sqlMapper.commit();
		System.out.println("입력되었습니다.");
	}

	private void updateMember() throws Exception {
		MemberVO param = new MemberVO();
		param.setId("member-5");
		param.setEmail("my@b.com");
		sqlMapper.insert("kr.co.mlec.member.dao.MemberMapper.updateMember", param);
		sqlMapper.commit();
		System.out.println("수정되었습니다.");
	}

	private void deleteMember() throws Exception {
		MemberVO param = new MemberVO();
		param.setId("member-5");
		sqlMapper.insert("kr.co.mlec.member.dao.MemberMapper.deleteMember", param);
		sqlMapper.commit();
		System.out.println("삭제되었습니다.");
	}

	private void selectForeach() throws Exception {
		MemberVO param = new MemberVO();
		param.setName("sbc");
		param.setAddrs(new String[]{"seoul", "pusan"});
		List<MemberVO> list = sqlMapper.selectList("kr.co.mlec.member.dao.MemberMapper.getMemberIteratorList", param);
		for (MemberVO member : list) {
			System.out.println("ID : " + member.getId());
			System.out.println("Name : " + member.getName());
			System.out.println("Email : " + member.getEmail());
			System.out.println("Addr : " + member.getAddr());
			System.out.println("JoinDate : " + member.getJoinDate());
		}
	}

	private void dynamicSelect() throws Exception {
//		MemberVO param = new MemberVO();
//		param.setName("s");
//		param.setEmail("y");
//		List<MemberVO> list = sqlMapper.selectList("kr.co.mlec.member.dao.MemberMapper.getMemberIncludeList", param);
//		int cnt = sqlMapper.selectOne("kr.co.mlec.member.dao.MemberMapper.getMemberIncludeListCount", param);
//		System.out.println("총 개수 : "+ cnt);
//		for (MemberVO member : list) {
//			System.out.println("ID : " + member.getId());
//			System.out.println("Name : " + member.getName());
//			System.out.println("Email : " + member.getEmail());
//			System.out.println("Addr : " + member.getAddr());
//		}
		
		MemberVO param = new MemberVO();
		SearchVO sv = new SearchVO();
		sv.setSearchType("name");
		sv.setSearchWord("s");
		List<MemberVO> list = sqlMapper.selectList("kr.co.mlec.member.dao.MemberMapper.getDynamicMemberList2", sv);
		for (MemberVO member : list) {
			System.out.println("ID : " + member.getId());
		}
	}

	public static void main(String[] args) {
		try {
			new MemberMapper();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
