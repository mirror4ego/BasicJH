package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class HttpServletRequest {
	private InputStream in;
	private String method;
	private String uri;
	private Map<String, String> paramMap;

	public String getMethod() {
		return method;
	}

	public String getRequestUri() {
		return uri;
	}

	public Map<String, String> getParamMap() {
		if (paramMap==null) return null;
		return paramMap;
	}

	public String getParameter(String key) {
		return paramMap.get(key);
	}

	
	public HttpServletRequest(InputStream in) throws Exception {
		this.in = in;
		init();
	}
	
	public void setParamMap (String inputparams) throws Exception {
		paramMap = new HashMap<>();
		String[] parameters = inputparams.split("&");
		for (String parameter : parameters) {
			String[] param = parameter.split("=");
			paramMap.put(param[0], URLDecoder.decode(param[1], "UTF-8"));
		}		
	}

	private void init() throws Exception {
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		
		// 첫줄 읽기
		String requestStartLine = br.readLine();
		if (requestStartLine == null) return;
		
		String[] firstArr = requestStartLine.split(" ");
		method = firstArr[0];
		if (firstArr.length > 1) {
			String[] secondArr = firstArr[1].split("\\?");
			uri = secondArr[0];
			if (secondArr.length > 1) {
				setParamMap(secondArr[1]);
			}
		}
		
		// 헤더 부분 읽기(헤드 바디의 경계인 공백까지 읽었음)
		while (true) {
			String line = br.readLine();
			if (line.equals(""))
				break;
		}
		
		// POST 방식일 경우의 처리
		// body
		// a=123&b=222
		if (method.equals("POST")) {
			String bodyParam = "";
			int ch = 0;
			while (br.ready()) {
				ch = br.read();
				bodyParam += (char)ch;
			}
			setParamMap(bodyParam);
		}
	}
}
