package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exam06")
public class Exam06 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("aa");
		resp.setContentType("text/plain; charset=utf-8"); 
		PrintWriter out = resp.getWriter();
		String json = "";
		json += "[{\"name\": \"홍길동\", \"age\": 30}, {\"name\": \"정효순남친\", \"age\": 29}]";	
		out.print(json);
		out.close();
	}
}
