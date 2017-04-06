package ajaxfile;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/ajaxfile/exam02")
public class Exam02 extends HttpServlet {

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
		
		/* exam04.html 에서 사용하는 부분
		String oriFileName1 = mRequest.getOriginalFileName("attachFile1");
		System.out.println("원본파일명 : " + oriFileName1);
		
		String realFileName1 = mRequest.getFilesystemName("attachFile1");
		System.out.println("서버파일명 : " + realFileName1);
		
		String oriFileName2 = mRequest.getOriginalFileName("attachFile2");
		System.out.println("원본파일명 : " + oriFileName2);
		
		String realFileName2 = mRequest.getFilesystemName("attachFile2");
		System.out.println("서버파일명 : " + realFileName2);
		*/
		
		// exam05.html 에서 사용하는 부분
		Enumeration<String> fileNames = mRequest.getFileNames();
		while (fileNames.hasMoreElements()) {
			String fileName = fileNames.nextElement();
			System.out.println("-----------------------------------------");
			System.out.println("파일 파라미터명 : " + fileName);
			System.out.println("원본파일명 : " + mRequest.getOriginalFileName(fileName));
			System.out.println("서버파일명 : " + mRequest.getFilesystemName(fileName));
			System.out.println("-----------------------------------------");
		}
		
	}
}

