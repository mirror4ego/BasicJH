window.onload = getMyLocation;

function getMyLocation() {
	// 위치정보 지원 여부 확인
	if (navigator.geolocation) {
		console.log("위치정보 지원함");
		
		navigator.geolocation.getCurrentPosition(
				displayLocation, displayError);
	}
	else {
		console.log("위치정보 지원하지 않음")
	}
}

// 위치정보 조회 성공시 호출 콜백함수
function displayLocation(position) {
	// 위도 
	var latitude = position.coords.latitude;
	// 경도
	var longitude = position.coords.longitude;
	
	// 위치를 보여줄 객체 조회
	var location = document.getElementById("location");
	location.innerHTML = 
		"당신의 위치 : 위도(" + latitude + "), 경도(" + longitude + ")";
	
	// 두 지점간의 거리를 km로 반환
	var km = computeDistance(position.coords, ourCoords);
	var distance = document.getElementById("distance");
	distance.innerHTML = "강남역까지의 거리 : " + km + "km";
	
	// 지도관련 함수 호출
	showMap(position.coords);
	
}

var map = null;

function showMap(coords) {
	// 위치 정보 객체 생성
	var latAndLng = new google.maps.LatLng(
							coords.latitude, coords.longitude);
	var mapOptions = {
		zoom: 10,  // 0 - 21까지 설정, 클수록 확대
		center: latAndLng,  // 지도의 중심 좌표 설정
		//ROADMAP(도로),  SATELLITE(위성), HYBRID
		mapTypeId: google.maps.MapTypeId.ROADMAP  
	};
	// 지도를 표시할 영역
	var mapDiv = document.getElementById("map");
	// 지도 객체 생성(화면상에 생성된 맵 객체를 보여줄 영역과 생성할 때 사용할 옵션)
	map = new google.maps.Map(mapDiv, mapOptions);
}

// 위치정보 조회 실패시 호출 콜백함수
function displayError(error) {
	var errorTypes = 
		["알려지지 않은 에러 발생", "권한 거부", "위치 정보를 찾지 못함", "요청 응답시간 초과"];
	
	var errHtml = errorTypes[error.code];
	
	console.log(errorTypes[error.code]);
	if (error.code == 0 || error.code == 2) {
		console.log(error.message);
		errHtml += "<br />" + error.message;  
	}
	
	var location = document.getElementById("location");
	location.innerHTML = errHtml;
}

//http://maps.googleapis.com/maps/api/geocode/xml?address=강남역&language=ko&sensor=false
var ourCoords = {
	latitude: 37.4979420,
	longitude: 127.0276210
}

/**
 *  출발지와 목적지의 거리를 km로 반환
 *  구면 코사인 법칙 : 구면 삼각법
 */
function computeDistance(startCoords, destCoords) {
	var startLatRads  = degreesToRadians(startCoords.latitude );
	var startLongRads = degreesToRadians(startCoords.longitude);
	var destLatRads   = degreesToRadians(destCoords.latitude  );
	var destLongRads  = degreesToRadians(destCoords.longitude );

	var Radius = 6371; // radius of the Earth in km
	var distance = Math.acos(
			       		Math.sin(startLatRads) * Math.sin(destLatRads) + 
			       		Math.cos(startLatRads) * Math.cos(destLatRads) *
			       		Math.cos(startLongRads - destLongRads)
			       ) * Radius;

	return distance;
}
/**
 *  1(라디안) = 180 / Math.PI, 1(degree) = Math.PI / 180
 *  반지름이 1일 경우 원의 전체 둘레 : 2 * Math.PI
 */
function degreesToRadians(degrees) {
	radians = (degrees * Math.PI) / 180;
	console.log(degrees  + " - " + (degrees * Math.PI) + " - " + radians);
	return radians;
}













