package quiz;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

import util.ConnectionFactory;
import util.ConnectionPool;

public class CreateVO {
	public static void main(String[] args) {
		outer: while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("VO를 생성할 테이블명(종료 : exit) : ");
			String tableName = sc.nextLine();
			if (tableName.matches("exit")) {
				System.out.println("종료합니다");
				System.exit(0);
			}
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ConnectionPool.getConnection();
				String sql = "select * from " + tableName;
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();

				ResultSetMetaData rsmd = rs.getMetaData();
				int colCnt = rsmd.getColumnCount();
				if (colCnt == 0) {
					break outer;
				}

				File f = new File("result/");
				if (f.exists() == false) {
					f.mkdirs();
				}

				String[] tName = tableName.split("_");
				PrintWriter pw = new PrintWriter("result/" + tName[1] + ".java");
				System.out.println("public class " + tName[1] + " {");
				pw.println("public class " + tName[1] + " {");

				for (int i = 1; i <= colCnt; i++) {
					String cTypeName = rsmd.getColumnTypeName(i);
					String cName = rsmd.getColumnName(i);
					makeTOP(pw, cTypeName, cName);
				}
				
				System.out.println();
				pw.println();
				
				for (int i = 1; i <= colCnt; i++) {
					String cTypeName = rsmd.getColumnTypeName(i);
					String cName = rsmd.getColumnName(i);
					makeSetGet(pw, cTypeName, cName);
				}
				System.out.print("}");
				pw.print("}");
				pw.close();

				System.out.println();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConnection(pstmt, null);
				ConnectionPool.releaseConnection(con);
			}
		}

	}

	public static void makeTOP(PrintWriter pw, String cTypeName, String cName) {
		cName = cName.replaceAll("_", "");
		cName = cName.toLowerCase();

		switch (cTypeName) {
		case "VARCHAR2":
		case "CHAR":
			System.out.println("\tprivate String " + cName + ";");
			pw.println("\tprivate String " + cName + ";");
			break;
		case "NUMBER":
			System.out.println("\tprivate int " + cName + ";");
			pw.println("\tprivate int " + cName + ";");
			break;
		case "DATE":
			System.out.println("\tprivate Date " + cName + ";");
			pw.println("\tprivate Date " + cName + ";");
			break;
		}

	}

	public static void makeSetGet(PrintWriter pw, String cTypeName, String cName) {
		cName = cName.replaceAll("_", "");
		String cName1 = cName.substring(0, 1) + cName.substring(1).toLowerCase();
		String cName2 = cName.toLowerCase();
		switch (cTypeName) {
		case "VARCHAR2":
		case "CHAR":
			System.out.println("\tpublic String get" + cName1 + "{");
			System.out.println("\t\treturn " + cName2);
			System.out.println("\t}");
			System.out.println("\tpublic void set" + cName1 + "(String " + cName2 + ") {");
			System.out.println("\t\tthis." + cName2 + " = " + cName2 + ";");
			System.out.println("\t}");

			pw.println("\tpublic String get" + cName1 + "{");
			pw.println("\t\treturn " + cName2);
			pw.println("\t}");
			pw.println("\tpublic void set" + cName1 + "(String " + cName2 + ") {");
			pw.println("\t\tthis." + cName2 + " = " + cName2 + ";");
			pw.println("\t}");
			break;
		case "NUMBER":
			System.out.println("\tpublic int get" + cName1 + "{");
			System.out.println("\t\treturn " + cName2);
			System.out.println("\t}");
			System.out.println("\tpublic void set" + cName1 + "(int " + cName2 + ") {");
			System.out.println("\t\tthis." + cName2 + " = " + cName2 + ";");
			System.out.println("\t}");

			pw.println("\tpublic int get" + cName1 + "{");
			pw.println("\t\treturn " + cName2);
			pw.println("\t}");
			pw.println("\tpublic void set" + cName1 + "(int " + cName2 + ") {");
			pw.println("\t\tthis." + cName2 + " = " + cName2 + ";");
			pw.println("\t}");
			break;
		case "DATE":
			System.out.println("\tpublic Date get" + cName1 + "{");
			System.out.println("\t\treturn " + cName2);
			System.out.println("\t}");
			System.out.println("\tpublic void set" + cName1 + "(Date " + cName2 + ") {");
			System.out.println("\t\tthis." + cName2 + " = " + cName2 + ";");
			System.out.println("\t}");

			pw.println("\tpublic Date get" + cName1 + "{");
			pw.println("\t\treturn " + cName2);
			pw.println("\t}");
			pw.println("\tpublic void set" + cName1 + "(Date " + cName2 + ") {");
			pw.println("\t\tthis." + cName2 + " = " + cName2 + ";");
			pw.println("\t}");
			break;
		}
		System.out.println();
		pw.println();
	}
}
