package ajaxfile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/ajaxfile/exam01")
public class Exam01 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upload = "C:/java86/workspace/jquery-basic/WebContent/upload";
		MultipartRequest mRequest = new MultipartRequest(
				request, 
				upload, 
				1024 * 1024 * 100 , 
				"utf-8", 
				new DefaultFileRenamePolicy());
		String msg = mRequest.getParameter("msg");
		System.out.println("일반데이터(msg) : " + msg);
		
		String oriFileName = mRequest.getOriginalFileName("attachFile");
		System.out.println("원본파일명 : " + oriFileName);
		
		String realFileName = mRequest.getFilesystemName("attachFile");
		System.out.println("서버파일명 : " + realFileName);
		
//		PrintWriter out = response.getWriter();
//		out.close();
		
		
	}
}

