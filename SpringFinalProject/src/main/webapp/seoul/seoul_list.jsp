<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading">Gallery Title Goes Here</header>
          <ul class="nospace clear">
            <li class="one_quarter first"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
          </ul>
          <figcaption>Gallery Description Goes Here</figcaption>
        </figure>
      </div>
      <nav class="pagination">
        <ul>
          <li vkdf><a href="#">&laquo; Previous</a></li>
          <li><a href="#">1</a></li>
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
		 type:${type},
		 title:'${title}'
		 seoul_list:[],
		 page_info:[],
		 curpage:1,
		 totalpage:0,
		 start:0,
		 end:0
	 },
	 mounted:function(){

	 },
	 axios.get('http://localhost/web/seoul/seoul_pgee_info_vue,'{
		 params:{
			 
		 }
	 })
	 ,
	 range:function(){
		 
	 },
	 pageChange:function(){
		 
	 }
})
</script>
</body>
</html>