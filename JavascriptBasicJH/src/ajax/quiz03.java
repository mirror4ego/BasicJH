package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quiz03")
public class quiz03 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=utf-8"); 
		String code = req.getParameter("code");
		System.out.println(code);
		CodeVO cv = new CodeDAO().selectOneCode(code);
		String result = "";
		if (cv != null) {
			result = cv.getName();
		}
		System.out.println(result);
		PrintWriter out = resp.getWriter();
		out.print(result);
		out.close();
	}
}
