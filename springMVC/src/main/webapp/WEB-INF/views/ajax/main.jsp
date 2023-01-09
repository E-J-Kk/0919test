<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.6.3.min.js"></script>
<script type="text/javascript">
	function callStr(){
		$.ajax({
			url: "callString.do",
			success: function(data){
				$("div").html(data);
			}
		});
	}
	
	function selectBidx(){
		var bidx = $("#bidx").val();
		$.ajax({
			url:"findBidx.do",
			data:"bidx="+bidx,
			success:function(data){
				console.log(data);
			}
		});
	}
</script>
</head>
<body>
	<h2>ajax 예제 메인페이지</h2>
	
	<button onclick="callStr()">String</button>
	<hr>
		test1 : <input type="text" id="test1">
		test2 : <input type="text" id="test2">
		<button>click!!!</button>
		<!-- 위 버튼 클릭 시 두 텍스트를 하나의 문자열로 만들어 출력하는 ajax기능을 구현하시오.  -->
	<hr>
		글번호 : <input type="number" id="bidx">
		<button onclick="selectBidx()">조회</button>
	<hr>
	
	<div></div>
</body>
</html>