/**
 *	jquery.js 라이브러리 기능을 일부 구현해본다. 
 */
function mlec(val) {
	
	
	
	
	
	// window.onload 대체하기
	if (typeof (val) == "function") {
		window.onload = val;
		return;
	}

	// val 값을 파싱하여 적절한 작업을 처리
	var ch = val.charAt(0);
	var elements;
	switch (ch) {
	case "#":
		elements = document.querySelector(val);
		break;
	case "<":
		elements = document.createElement(val.substring(1, val.length-1));
		break;
	default:
		elements = document.querySelectorAll(val);
		break;
	}

	// html 함수 추가하기 : innerHTML 대체
	elements.html = function(html) {
		// elements가 배열인 경우 0번째만 다룸;
		if (this.length) {
			if (html) {
				for (var i = 0; i < this.length; i++) {
					this[i].innerHTML = html;
				}
				return this;
			}
			return this[0].innerHTML;
		}
		// elements가 하나인 경우(# 접근)
		else {
			if (html) {
				this.innerHTML = html;
				return this;
			}
			return this.innerHTML;
		}
	};

	// text 함수 추가하기 : innerText 대체
	elements.text = function(text) {
		// elements가 배열인 경우 0번째만 다룸;
		if (this.length) {
			if (text) {
				for (var i = 0; i < this.length; i++) {
					this[i].innerText = text;
				}
				return this;
			}
			return this[0].innerText;
		}
		// elements가 하나인 경우(# 접근)
		else {
			if (text) {
				this.innerText = text;
				return this;
			}
			return this.innerText;
		}
	};

	// val 함수 추가하기 
	elements.val = function(val) {
		// elements가 배열인 경우 0번째만 다룸;
		if (this.length) {
			if (val) {
				this[0].value = val;
				return this;
			}
			return this[0].value;
		}
		// elements가 하나인 경우(# 접근)
		else {
			if (val) {
				this.value = val;
				return this;
			}
			return this.value;
		}
	};

	// attr 함수 추가하기
	elements.attr = function(k, v) {
		if (this.length) {
			// 여러개의 속성값을 한번에 넘겨받았을 경우 처리
			if (typeof (k) == "object") {
				for ( var key in k) {
					this[0].setAttribute(key, k[key]);
				}
				return this;
			}
			if (v) {
				this[0].setAttribute(k, v);
				return this;
			}
			return this[0].getAttribute(k);
		} else {
			if (typeof (k) == "object") {
				for ( var key in k) {
					this.setAttribute(key, k[key]);
				}
				return this;
			}
			if (v) {
				this.setAttribute(k, v);
				return this;
			}
			return this.getAttribute(k);
		}
	};

	// css함수 추가하기 : style 속성
	elements.css = function(k, v) {
		if (this.length) {
			// 여러개의 속성값을 한번에 넘겨받았을 경우 처리
			if (typeof (k) == "object") {
				for (var key in k) {
					for (var i = 0; i < this.length; i++) {
						this[i].style[key] = k[key];
					}
				}
				return this;
			}
			if (v) {
				for (var i = 0; i < this.length; i++) {
					this[i].style[k] = v;
				}
				return this;
			}
			return this[0].style[k];
		} else {
			if (typeof (k) == "object") {
				for ( var key in k) {
					this.style[key] = k[key];
				}
				return this;
			}
			if (v) {
				this.style[k] = v;
				return this;
			}
			return this.style[k];
		}
	};
	
	// appendChild
	elements.append = function(tag) {
		if (this.length) {
			if (tag) {
				for (var i = 0; i < this.length; i++) {
					this[i].appendChild(tag);
				}
			}
		}
		else {
			if (tag) {
				this.appendChild(tag);
			}
		}
		return this;
	};
	
	// event
	elements.on = function(type, listener, useCapture) {
		if (this.length) {
			if (useCapture) {
				for (var i = 0; i < this.length; i++) {
					this[i].addEventListener(type, listener, useCapture);
				}
			} else {
				for (var i = 0; i < this.length; i++) {
					this[i].addEventListener(type, listener);
				}
			}
		}
		else {
			if (useCapture) {
				this.addEventListener(type, listener, useCapture);
			} else {
				this.addEventListener(type, listener);
			}
		}
		return this;
	};
	
	elements.click = function(listener, useCapture) {
		this.on("click", listener, useCapture)
	};
	elements.keyup = function(listener, useCapture) {
		this.on("keyup", listener, useCapture)
	};
	
	
	// element추가하기
	return elements;
}

var $ = mlec;

// ajax 추가...
var xhr; // 전역변수 빼기, 콜백함수에서 사용하기 위해서
$.ajax = function (options) {
	/*
	 * 	options : ajax 에서 필요로 하는 값들
	 * 
	 *  options.type : GET, POST 방식 지정
	 *  options.dataType : json, xml 등 응답 데이터의 처리 지정
	 *  options.url : 호출할 서버 페이지
	 *  options.data : 서버 페이지에서 사용할 파라미터 객체({})
	 *  options.success : 서버에서의 응답결과를 처리할 콜백함수
	 */
	
	xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				
				var result = xhr.reponseText;
				switch (options.dataType) {
				case "json": 
					result = JSON.parse(xhr.responseText);
					break;
				case "xml": 
					result = xhr.responseXML
					break;
				case "text": 
					result = xhr.responseText
					break;
				}
				options.success(result);
			}
		}
	};
	
	// method 처리
	var method = options.type ? options.type : "GET";
	if (method != "GET" && method != "POST") {
		method = "GET";
	}
	
	// url 처리(파라미터까지 처리)
	// GET 방식일 경우 options.data를 options.url에 추가
	// POST 방식일 경우 options.data를 send에 추가
	// 객체가 가지고 있는 데이터를 파라미터 형태의 문자열로 변경
	var params = "";
	// 사용자가 데이터를 옵션에 추가했는지 확인
	if (options.data) {
		for (var key in options.data) {
			if(params == "") {
				param += key + "=" + options.data[key];			
			} else {
				param += "&" + key + "=" + options.data[key];
			}
		}
		 
	}
	var url = options.url;
	if (method == "GET" && params != ""){
		url += "?" + params;
	}
	xhr.open(method, url, true);
	
	// POST
	// header Content-Type
	// application/x-www-form-urlencoded
	if (method == "POST" && params != ""){
		xhr.setRequestHeader(
			"Content-Type", "application/x-www-form-urlencoded");	
	}
	
	xhr.send(method == "POST" ? params : null);
};