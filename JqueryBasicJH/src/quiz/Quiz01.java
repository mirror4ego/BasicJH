package quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/quiz01")
public class Quiz01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String result = "";
		
		List<Quiz01VO> qList = new Quiz01DAO().selectList();
		int count = 0; // 총 게시글 수
		int page = 0; // 총 페이지 수
		for (Quiz01VO qv : qList) {
			count++;
			if (count % 5 == 1) {
				page++;
				result += "<div class='page2'>";
				result += "<table>";
			}
			String title = qv.getTitle();
			Date regDate = qv.getRegDate();	
			result += "<tr>"
					+ "<th>" + title + "</th>"
					+ "</tr>"
					+ "<tr>"
					+ "<td>" + regDate + "</td>"
					+ "</tr>";
			if (count % 5 == 0 || count == qList.size()) {
				result += "</table>";
				result += "</div>";
			}
		}
		out.println(result);
		out.close();
	}
}
