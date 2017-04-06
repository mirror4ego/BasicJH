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
				this[0].value = val;
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
	
	
	// element추가하기
	return elements;
}

var $ = mlec;