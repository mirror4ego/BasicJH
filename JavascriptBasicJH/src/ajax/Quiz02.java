package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quiz02")
public class Quiz02 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=utf-8"); 
		PrintWriter out = resp.getWriter();
		String json = "";
		json += "[{\"id\": \"admin\", \"name\": \"관리자\", \"pw\": 4444},"
				+ "{\"id\": \"sul\", \"name\": \"설현\", \"pw\": 3333},"
				+ "{\"id\": \"hong1\", \"name\": \"홍길동\", \"pw\": 2222},"
				+ "{\"id\": \"hong2\", \"name\": \"홍서범\", \"pw\": 1111}]";	
		out.print(json);
		out.close();
	}
}
