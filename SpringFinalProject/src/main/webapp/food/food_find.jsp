<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<link href="../layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">

<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.images:hover{
	cursor: pointer;
}
</style>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <div class="content"> 
      <div id="gallery">
        <figure>
           <header class="heading inline">
              <select class="input-sm" v-model="column">
                <option value="all">전체</option>
                <option value="name">업체명</option>
                <option value="address">주소</option>
                <option value="type">음식종류</option>
              </select>
              <input type=text ref="fd" class="input-sm" size=20 v-model="fd">
              <input type=button class="btn btn-sm btn-primary"
               value="검색" @click="find()">
            </header>          
            <ul class="nospace clear">
            <li v-for="vo,index in food_list" :class="index%4==0?'one_quarter first':'one_quarter'"><img :src="vo.poster" :title="vo.name" class="images" @click="foodDetail(vo.fno,true)"></li>
          </ul>
        </figure>
      </div>
      <nav class="pagination">
        <ul>
          <li v-if="startPage>1"><a href="#" v-on:click="prev()">&laquo; Previous</a></li>
          <li v-for="p in range(startPage,endPage)" :class="p==curpage?'current':''"><a href="#" v-on:click="pageChange(p)">{{p}}</a></li>
          <li v-if="endPage<totalpage"><a href="#" @click="next()">Next &raquo;</a></li>
        </ul>
      </nav>
    </div>
    <div id="dialog" title="맛집 상세보기" v-if="isShow">
      <table class="table">
        <tr>
          <td class="text-center" v-for="image in posters">
            <img :src="image" style="width:100%;">
          </td>
        </tr>
      </table>
      <table class="table">
        <tr>
          <td colspan="2">
           <h3>{{food_detail.name}}&nbsp;<span style="color:orange">{{food_detail.score}}</span></h3>
          </td>
        </tr>
        <tr>
          <td width=25%>전화</td>
          <td width=75%>{{food_detail.phone}}</td>
        </tr>
        <tr>
          <td width=25%>주소</td>
          <td width=75%>{{food_detail.address}}</td>
        </tr>
        <tr>
          <td width=25%>음식종류</td>
          <td width=75%>{{food_detail.type}}</td>
        </tr>
        <tr v-if="food_detail.price!='no'">
          <td width=25%>가격대</td>
          <td width=75%>{{food_detail.price}}</td>
        </tr>
        <tr v-if="food_detail.time!='no'">
          <td width=25%>영업시간</td>
          <td width=75%>{{food_detail.time}}</td>
        </tr>
        <tr v-if="food_detail.parking!='no'">
          <td width=25%>주차</td>
          <td width=75%>{{food_detail.parking}}</td>
        </tr>
        <tr v-if="food_detail.menu!='no'">
          <td width=25%>메뉴</td>
          <td width=75%>
            <ul>
              <li v-for="m in menus">{{m}}</li>
            </ul>
          </td>
        </tr>
      </table>
    </div> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
<script>
  new Vue({
	  el:'.container',
	  data:{
		  column:'all',
		  fd:'',
		  food_list:[],
		  food_detail:{},
		  page_list:{},
		  curpage:1,
		  totalpage:0,
		  startPage:0,
		  endPage:0,
		  isShow:false,
		  posters:[],
		  menus:[]
		  
	  },
	  // callback == 자동호출함수
	  mounted:function(){
		  this.dataSend()
		  
	  },
	  // 사용자 정의 함수 (예: 이벤트처리, range, 공통 사용 부분 등)
	  methods:{
		  dataSend:function(){
			  axios.get("http://localhost/web/food/food_find_vue.do",{
				  params:{
					  column:this.column,
					  fd:this.fd,
					  page:this.curpage
				  }
			  }).then(res=>{
				  console.log(res.data)
				  this.food_list=res.data
			  })
			  axios.get("http://localhost/web/food/page_vue.do",{
				  params:{
					  column:this.column,
					  fd:this.fd,
					  page:this.curpage
				  }
			  }).then(res=>{
				  console.log(res.data)
				  this.page_list=res.data
				  this.curpage=this.page_list.curpage
				  this.totalpage=this.page_list.totalpage
				  this.startPage=this.page_list.startPage
				  this.endPage=this.page_list.endPage
				  
			  })
		  },
		  find:function(){
			  this.curpage=1
			  this.dataSend()
		  },
		  range:function(start,end){
			  let arr=[]
			  let length=end-start
			  for(let i=0;i<=length;i++){
				  arr[i]=start
				  start++
			  }
			  return arr
		  },
		  pageChange:function(page){
			  this.curpage=page
			  this.dataSend()
		  },
		  prev:function(){
				// this.curpage=this.startpage>1?this.startpage-1:this.startpage
				this.curpage=this.startPage-1
				this.dataSend()
			},
		  next:function(){
				// this.curpage=this.endpage<totalpage?this.endpage+1:this.endpage
				this.curpage=this.endPage+1
				this.dataSend()
		  },
		  foodDetail:function(fno,bool){
			  this.isShow=bool
			  axios.get("http://localhost/web/food/food_detail_vue.do",{
				  params:{
					  fno:fno
				  }
			  }).then(res=>{
				  console.log(res.data)
				  this.food_detail=res.data
				  this.posters=this.food_detail.poster.split("^")
				  if(this.food_detail.menu!='no')
				  {
					  this.menus=this.food_detail.menu.split("원")
				  }
				  $('#dialog').dialog({
					  autoOpen:false,
					  modal:true,
					  width:700,
					  height:600
				  }).dialog("open")
			  }).catch(error=>{
				  console.log(error.response)
			  })
		  }
	  }
  })
</script>
</body>
</html>












