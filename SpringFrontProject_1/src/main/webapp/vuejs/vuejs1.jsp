<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top:50px;
}
.row{
	margin:0px auto;
	width:960px;
}
</style>
<!-- <script type="text/javascript">
$(function(){
	$('#msg').keyup(function(){
		let m=$('#msg').val();
		$('#print').text(m);
	})
})
</script>
 -->
</head>
<body>
  <div class="container">
    <div class="row">
     <!-- 양방향 : 입력값을 받아서 출력하는 역할 수행 -->
      입력: <input type="text" v-model="msg" size="30" class="input-sm">
      <!-- v-model => 멤버변수값을 변경 -->
      <div id="print"> <!--  출력: msg에 저장된 내용을 출력 -->
        {{msg}}
      </div>
    </div>
  </div>
<script>
  new Vue({
	  el:'.container',
	  data:{
		  msg:''
	  }
  })
</script>

<%--
	1. VueJS의 생명주기 =>vue3버전(React와 흡사)
	   beforeCreate
	   created
	   -------- Vue 객체 생성
	   beforeMount
	   mounted
	   -------- 메모리에 저장
	   beforeUpdate
	   updated
	   -------- 수정 단계
	   beforeDestroy
	   destroyed
	   -------- 메모리 해제 (면접문제: 가상돔이 무엇인지?)
	   
	   (가상돔)더블버퍼링 ==> 메모리를 두개 생성하는 방식 (가상 메모리/현실 메모리)
	   StringBuffer ===> String
	   DOM : Document Object Model ; 트리 형태로 저장
	2. 디렉티브
	    => 제어문
	        v-for: 반복문 => 태그 <div v-for="">
	        v-if / v-else
	        v-show 
	    => 이벤트
	        v-on:click=> <button v-on:click="">
	        v-on:change=> 
	    => 양방향 통신 (Vue)/ 단방향 통신 (React)  v-model
	       ------- AngularJS에서 파생 => 
	3. 컴포넌트: 재사용기법
	   Vue.Component('modal',template:'<html>...')
	4. 데이터를 읽어서 출력 (클라이언트 = 서버 통신하는 과정) => axios
	   axios.get('url',{
	              params:{
	                 데이터 전송
	              }
	            }).then(){결과값읽기}
	   => 일반 문자열 / JSON => @RestController
	   => id나 class를 사용하지 않는다 ref=""
	5. 라우터 (화면 변경): Spring에서 화면 변경
	   => 검색, 로그인 처리, 댓글
	6. Vue 생성 
	   <script>
	     => 여러개를 사용할 수 있다!
	     new Vue({
	       el :'.container' ==> 제어 영역: 제어하는 영역이 어디서부터 어디까지인지 확인필. => class=".container" id="#row"
	       data:{
	          => 멤버변수 (Vue에서 제어하는 변수)
	          a:[]  => 배열, 스프링에서 전송할 때 ArrayList을 JSONArray로 변경해서 보내줌
	          b:{}  => VO, JSONObject로 변경해서 보내줌
	          c:true  => boolean
 	          d:''  => String
	          e:0  => 정수/실수
	       }
	       생명주기 함수 이용
	       mounted:function(){}
	       updated:function(){}
	       사용자 정의 함수 => 이벤트
	       methods:{
	           aaa:function(){}
	       }
	       filters: 변환 (날짜 변환, 숫자 변환할때)
	          => 요즘에는 complete 일때 처리?!(?)
	     })ㅣ
	   </script>
	   
	   ==> 데이터 출력
	   {{data에 설정된 변수 사용}}
	   => 한번에 모든 데이터를 출력할때: {{$data}}
	   => <img src="{{poster}}"> ==> 오류!
	      <img :src="poster"> ===> success!
	      : => <input type="text" :value="id"> v-bind: (v-bind는 생략가능하기 때문에 :만 사용한다)
 --%>
</body>
</html>