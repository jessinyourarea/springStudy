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
.container-fluid{
	margin-top:50px;
}
.row{
	margin:0px auto;
	width:100%;
}
</style>
</head>
<body>
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-3" v-for="vo in recipe_list">
	      <div class="thumbnail">
	        <a href="#">
	          <img :src="vo.poster" style="width:100%">
	          <div class="caption">
	            <p style="font-size:10px">{{vo.title}}</p>
	          </div>
	        </a>
	      </div>
	  </div>
    </div>
    <div style="height:10px"></div>
    <div class="row">
      <div class="text-center">
        <ul class="pagination">
		  <li v-if="startPage>1"><a href="#">&lt;</a></li>
		  <li v-for="i in range(startPage, endPage)" :class="i == curpage ? 'active' : ''">
		    <a href="#" @click="setPage(i)">{{ i }}</a>
		  </li>		  
		  <li v-if="endPage<totalpage"><a href="#">&gt;</a></li>
		</ul>
      </div>
    </div>
  </div>
 <script>
   new Vue({
	   el:'.container-fluid',
	   data:{
		   recipe_list:[],
		   curpage:1,
		   totalpage:0,
		   startPage:0,
		   endPage:0
	   },
	   mounted:function(){
		   this.send();
	   },
	   methods:{
		   send:function(){
			   axios.get("http://localhost/web/recipe/list_vue.do",{
				   params:{
					   page:this.curpage
				   }
			   }).then(response=>{
				   this.curpage=response.data.curpage;
				   this.totalpage=response.data.totalpage;
				   this.recipe_list=response.data.list;
				   this.startPage=response.data.startpage;
				   this.endPage=response.data.endPage;
			   })
		   },
		   range:function(start,end){
			  let arr=[]
   			  let length=end-start
			  for(let i=0;i<=length;i++)
			  {
				  arr[i]=start;
				  start++;
			  }
			   return arr;
		   },
		   setPage:function(pageNm){
			   if(pageNm>=1 && pageNm<=this.totalpage)
			   {
				   this.curpage=pageNm;
				   this.send();
			   }
		   }
	   }
   })
 </script> 
</body>
</html>







