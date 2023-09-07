<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
	margin:0px auto;
}
</style>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
    <h2 class="sectiontitle">맛집 상세보기</h2>
      <div class="row">
      <table class="table">
        <tr>
          <td class="text-center" v-for="image in posters">
            <img :src="image" style="width:100%">
          </td>
        </tr>
      </table>
      </div>
      <div class="row">
        <div class="col-sm-8">
          <table class="table">
            <tr>
              <td colspan=2>
                <h4>{{food_detail.name}}&nbsp;<span style="color:orange">{{food_detail.score}}</span></h4>
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
          <td width=75%>{{food_detail.menu}}
          </td>
        </tr>
        <tr>
          <td colspan=2 class="text-right">
           <a :href="'../food/food_list.do?cno='+food_detail.cno" class="btn btn-xs btn-danger">목록</a>
          </td>
        </tr>
         </table>
         <div style="height:20px"></div>
         <table class="table">
           <tr>
             <td>
               <table class='table' v-for="rvo in reply_list">
                 <tr>
                   <td class="text-left">
                     〓{{rvo.name}}&nbsp;({{rvo.dbday}})
                   </td>
                   <td class="text-right">
                     <span v-if="sessionId==rvo.id">
                     <button class="btn btn-xs btn-primary" @click=replyUpdate()>수정</button>
                     <button class="btn btn-xs btn-succcess" @click=replyDelete()>삭제</button>
                     </span>
                   </td>
                 </tr>
                 <tr>
		             <td>
		               <textarea rows="5" cols="60" ref="msg" v-model="msg" style="float:left">{{rvo.msg}}</textarea>
		               <button style="float:left;background-color:blue;color:white;width:100px;height:100px">댓글 수정</button>
		             </td>
		         </tr>
                 <tr>
                   <td colspan="2">
                     <pre style="white-space:pre-wrap;background-color:white;border:none;">{{rvo.msg}}</pre>
                   </td>
                 </tr>
               </table>
             </td>
           </tr>
         </table>
         <table class="table" v-if="sessionId!=null">
           <tr>
             <td>
               <textarea rows="5" cols="60" ref="msg" v-model="msg" style="float:left"></textarea>
               <button style="float:left;background-color:blue;color:white;width:100px;height:100px">댓글쓰기</button>
             </td>
           </tr>
         </table>
        </div>
        <div class="col-sm-4">
        
        </div>
      </div>      
  </main>
</div>
<script>
 let foodDetail=new Vue({
	 el:'.container',
	 data:{
		 fno:${fno},
		 food_detail:{},
		 poters:[],
		 reply_list:[],
		 sessionId:null,
		 msg:'',
		 isShow:false,
		 no:0
	 },
	 mounted:function(){
		 axios.get("http://localhost/web/food/food_house_detail_vue.do",{
			 params:{
				 fno:this.fno
			 }
		 }).then(res=>{
			 // 결과값 받기
			 console.log(res.data)
			 this.food_detail=res.data
			 this.posters=this.food_detail.poster.split("^");
			 
		 }).catch(error=>{
			 // 오류 처리
			 console.log(error.res)
		 })
		 
		 // 댓글 읽어오기
	 },
	 methods:{
		 replyRead:function(){
			axios.get("../reply/reply_read_vue.do",{
				params:{
					fno:this.fno
				}
			}).then(res=>{
				console.log(res.data)
				this.reply_list=res.data
			}).catch(error=>{
				console.log(error.data)
			})
		 },
		 replyWrite:function(){
			 if(this.msg===""){
				 this.$refs.msg.focus()
				 return
			 }
			 axios.post("../reply/reply_insert_vue.do",null,{
				 params:{
					 fno:this.fno,
					 msg:this.msg
				 }
			 }).then(res=>{
				 console.log(res.data)
				 this.reply_list=res.data
			 }).catch(error=>{
				 console.log(error.res)
			 })
		 },
		 replyDelete:function(no){
			 axios.get('../reply/reply_delete_vue.do',{
				 params:{
					 no:no,
					 fno:this.fno
				 }
			 }).then(res=>{
				 console.log(res.data)
				 this.reply_list=res.data
			 }).catch(error=>{
				 console.log(error.res)
			 })
		 }
	 }
 })
</script>
</body>
</html>














