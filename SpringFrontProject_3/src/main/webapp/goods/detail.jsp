<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.container {
	margin-top: 50px;
}
.row {
	margin: 0px auto;
	width: 100%;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <table class="table">
        <tr>
          <td width=35% class="text-center" rowspan="6">
            <img :src="goods_detail.poster" style="width:100%">
          </td>
          <td width=65%>
            <strong>{{goods_detail.name}}</strong>
          </td>
        </tr>
        <tr>
          <td width=65%>
            <span style="color:gray">{{goods_detail.sub}}</span>
          </td>
        </tr>
        <tr>
          <td width=65%>
            <span style="color:red">{{goods_detail.discount}}%</span>
            &nbsp;&nbsp;<b>{{goods_detail.price}}</b>
          </td>
        </tr>
        <tr>
          <td width=65%>
            <span style="color:green;font-size: 8px">첫구매가 할인</span>
            &nbsp;<b>{{goods_detail.fp}}</b>
          </td>
        </tr>
        <tr>
          <%--
              this.$refs.account = $('#account')
           --%>
          <td width=65%>
            수량:<select name=account ref="account" v-on:click="change()">
               <option>1</option>
               <option>2</option>
               <option>3</option>
               <option>4</option>
               <option>5</option>
            </select>
            &nbsp;총금액:<span ref="total">{{total|currency}}원</span>
          </td>
        </tr>
        <tr>
          <td width=65%>

            <input type=submit value="장바구니"
              class="btn btn-sm btn-success" id="cartBtn">

          </td>
        </tr>
      </table>
    </div>
  </div>
 <script>
  new Vue({
	  el:'.container',
	  // Controller에서 model통해 보낸 no를 저장시키려고 no:${no}를 줌.
	  data:{
		  no:${no},
		  goods_detail:{},
		  total:0
	  },
	  filters:{
          currency: function(value){
              let num = new Number(value);
              return num.toFixed(0).replace(/(\d)(?=(\d{3})+(?:\.\d+)?$)/g, "$1,")
          }
      },
	  mounted:function(){
		  axios.get("http://localhost/web/goods/detail_vue.do",{
			  params:{
				  no:this.no
			  }
		  }).then(response=>{
			  console.log(response.data)
			  this.goods_detail=response.data
		  })
	  },
	  methods:{
		 change:function(){
			 let count=this.$refs.account.value
			 this.total=this.goods_detail.rp*count
		 }
	  }
  })
 </script>
</body>
</html>