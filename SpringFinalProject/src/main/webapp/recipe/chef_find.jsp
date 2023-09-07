<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link href="../layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <table class="table">
      <tr>
        <td width=30% class="text-center" rowspan="2">
          <img :src="chef_info.poster" style="width:50px" class="img-circle">
        </td>
        <td width=70% colspan="4"><h4 style="color:orange">{{chef_info.chef}}</h4></td>
      </tr>
      <tr>
        <td class="text-center">
          <img src="../recipe/mem1.png">&nbsp;{{chef_info.mem_cont1}}
        </td>
        <td class="text-center">
          <img src="../recipe/mem2.png">&nbsp;{{chef_info.mem_cont2}}
        </td>
        <td class="text-center">
          <img src="../recipe/mem3.png">&nbsp;{{chef_info.mem_cont3}}
        </td>
        <td class="text-center">
          <img src="../recipe/mem4.png">&nbsp;{{chef_info.mem_cont4}}
        </td>
      </tr>
    </table>
    <div class="content"> 
      <div id="gallery">
        <figure>
          <header class="heading inline">
            <input type="text" value="검색" ref="fd">
            <input type="button" value="검색" class="btn btn-sm btn-primary">
          </header>
          <ul class="nospace clear" v-if="count==0">
            <li v-for="vo,index in recipe_list" 
            :class="index%4==0?'one_quarter first':'one_quarter'"><a href="#"><img :src="vo.poster" :title=""></a></li>
          </ul>
          <ul class="nospace clear" v-else>
            <li v-for="vo,index in recipe_list" 
            :class="index%4==0?'one_quarter first':'one_quarter'"><a href="#"><img :src="vo.poster" :title=""></a></li>
          </ul>
          <figcaption>Gallery Description Goes Here</figcaption>
        </figure>
      </div>
      <!-- ################################################################################################ --> 
      <!-- ################################################################################################ -->
      <nav class="pagination">
        <ul>
          <li ><a href="#">&laquo; Previous</a></li>
          <li v-for="i in range(startPage,endPage)"><a href="#">1</a></li>
          <li><a href="#">Next &raquo;</a></li>
        </ul>
      </nav>
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
<script>
  new Vue({
	  el:'.container',
	  data:{
		  chef_info:{},
		  recipe_list:[],
		  page_info:{},
		  curpage:1,
		  totalpage:0,
		  startPage:0,
		  endPage:0,
		  chef:'${chef}',
		  fd:'all',
		  count:0
	  },
	  // EL, JSTL = 자바스크립트에서 사용 가능
	  mounted:function(){
		  axios.get('http://localhost/web/recipe/chef_info_vue.do',{
			  params:{
				  chef:this.chef
			  }
		  }).then(res=>{
			  console.log(res.data)
			  this.chef_info=res.data
		  }).catch(error=>{
			  console.log(error.res)
		  })
		  
		  // -------페이지 변경 시 || 검색 시 같은 메소드 호출=> 함수화하자!
		  // 1. 쉐프의 레시피 가져오기
		  // 2. 페이지 읽어오기
		  this.dataRecv()
	  },
	  methods:{
		  // 공통 메소드 : 스프링, 자바, Front => 반복 코딩 제거
		  dataRecv:function(){
			  // 레시피 읽기
			  axios.post('http://localhost/web/recipe/chef_find_vue.do',null,{
				  params:{
					  page:this.curpage,
					  fd:this.fd,
					  chef:this.chef
				  }
			  }).then(res=>{
				  console.log(res.data)
				  this.recipe_list=res.data
				  
			  }).catch(error=>{
				  console.log(error.res)
			  })
			  
			  // 페이지 정보 읽기
			  axios.get('http://localhost/web/recipe/page_info_vue.do',{
				  params:{
					  page:this.curpage,
					  fd:this.fd,
					  chef:this.chef
				  }
			  }).then(res=>{
				  console.log(res.data)
				  this.page_info=res.data
				  this.curpage=this.page_info.curpage
				  this.totalpage=this.page_info.totalpage
				  this.startPage=this.page_info.startPage
				  this.endPage=this.page_info.endPage
				  this.count=this.page_info.count
				  /*
				  this.curpage=res.data.curpage
				  this.totalpage=res.data.totalpage
				  this.startPage=res.data.startPage
				  this.endPage=res.data.endPage
				  this.count=res.data.count
				  */
			  }).catch(error=>{
				  console.log(error.res)
			  })
		  },
		  range:function(start, end){
			  let arr=[]
			  let leng=end-start
			  for(let i=0;i<=leng;i++)
		      {
				  arr[i]=start
				  start++
		      }
			  return arr
		  },
		  find:function(){
			  this.curpage=1
			  this.dataRecv()
		  },
		  pageChange:function(){
			  this.curpage=page
			  this.dataRecv()
		  },
		  prev:function(){
			  this.curpage=this.startPage-1
			  this.dataRecv()
		  },
		  next:function(){
			  this.curpage=this.endPage+1
			  this.dataRecv()
		  }
	  }
	  
  })
</script>
</body>
</html>