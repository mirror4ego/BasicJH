package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/duplication")
public class quiz01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		List<AccountVO> aList = new AccountDAO().selectListId();
		String result = "사용가능";
		for (AccountVO a : aList) {
			System.out.println(a.getId());
			System.out.println(req.getParameter("id"));
			if (a.getId().equals(req.getParameter("id"))){
				result = "중복";
			}
		}
		out.write(result);
		out.close();
	}
}
