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
  <div id="slider" class="clear"> 
    <div class="flexslider basicslider">
      <ul class="slides">
        <li><a href="#"><img class="radius-10" src="../images/demo/slides/back1.jpg" style="width:978px;height:400px"></a></li>
        <li><a href="#"><img class="radius-10" src="../images/demo/slides/back2.jpg" style="width:978px;height:400px"></a></li>
        <li><a href="#"><img class="radius-10" src="../images/demo/slides/back3.jpg" style="width:978px;height:400px"></a></li>
      </ul>
    </div>
  </div>
</div>

<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <ul class="nospace group btmspace-80">
      <li class="one_third first">
        <article class="service"><i class="icon fa fa-ambulance"></i>
          <h6 class="heading"><a href="#">Lorem Ipsum Dolor</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
          <footer><a href="#">Read More &raquo;</a></footer>
        </article>
      </li>
      <li class="one_third">
        <article class="service"><i class="icon fa fa-h-square"></i>
          <h6 class="heading"><a href="#">Lorem Ipsum Dolor</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
          <footer><a href="#">Read More &raquo;</a></footer>
        </article>
      </li>
      <li class="one_third">
        <article class="service"><i class="icon fa fa-hospital-o"></i>
          <h6 class="heading"><a href="#">Lorem Ipsum Dolor</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
          <footer><a href="#">Read More &raquo;</a></footer>
        </article>
      </li>
    </ul>
    <h2 class="sectiontitle">믿고 보는 맛집 리스트</h2>
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
	        <li v-for="vo,index in cate_list" v-if="index>=0 && index<12">
	          <figure><img class="radius-10 btmspace-10" :src="vo.poster" :title="vo.subject">
	            <figcaption><a :href="'../food/food_list.do?cno='+vo.cno">{{vo.title }}</a></figcaption>
	          </figure>
	        </li>
      </ul>
    </div>
    <h2 class="sectiontitle">지역별 인기 맛집</h2>
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
	        <li v-for="vo,index in cate_list" v-if="index>=12 && index<18">
	          <figure><img class="radius-10 btmspace-10" :src="vo.poster" :title="vo.subject">
	            <figcaption><a :href="'../food/food_list.do?cno='+vo.cno">{{vo.title }}</a></figcaption>
	          </figure>
	        </li>
      </ul>
    </div>
    <h2 class="sectiontitle">메뉴별 인기 맛집</h2>
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
	        <li v-for="vo,index in cate_list" v-if="index>=18 && index<30">
	          <figure><img class="radius-10 btmspace-10" :src="vo.poster" :title="vo.subject">
	            <figcaption><a :href="'../food/food_list.do?cno='+vo.cno">{{vo.title }}</a></figcaption>
	          </figure>
	        </li>
      </ul>
    </div>
    <h2 class="sectiontitle">Lorem Ipsum Dolor</h2>
    <ul class="nospace group">
      <li class="one_half first">
        <article><img class="imgl radius-10" src="../images/demo/100x100.gif" alt="">
          <h6 class="heading"><a href="#">Lorem Ipsum Dolor</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
        </article>
      </li>
      <li class="one_half">
        <article><img class="imgl radius-10" src="../images/demo/100x100.gif" alt="">
          <h6 class="heading"><a href="#">Lorem Ipsum Dolor</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
        </article>
      </li>
    </ul>
        <h2 class="sectiontitle">Lorem Ipsum Dolor</h2>
    <!-- ################################################################################################ -->
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
        <li>
          <figure><img class="radius-10 btmspace-10" src="../images/demo/320x185.png" alt="">
            <figcaption><a href="#">Lorem Ipsum Dolor Sit Amet</a></figcaption>
          </figure>
        </li>
        <li>
          <figure><img class="radius-10 btmspace-10" src="../images/demo/320x185.png" alt="">
            <figcaption><a href="#">Lorem Ipsum Dolor Sit Amet</a></figcaption>
          </figure>
        </li>
        <li>
          <figure><img class="radius-10 btmspace-10" src="../images/demo/320x185.png" alt="">
            <figcaption><a href="#">Lorem Ipsum Dolor Sit Amet</a></figcaption>
          </figure>
        </li>
        <li>
          <figure><img class="radius-10 btmspace-10" src="../images/demo/320x185.png" alt="">
            <figcaption><a href="#">Lorem Ipsum Dolor Sit Amet</a></figcaption>
          </figure>
        </li>
        <li>
          <figure><img class="radius-10 btmspace-10" src="../images/demo/320x185.png" alt="">
            <figcaption><a href="#">Lorem Ipsum Dolor Sit Amet</a></figcaption>
          </figure>
        </li>
      </ul>
    </div>
    <!-- ################################################################################################ -->
    <h2 class="sectiontitle">최신 방문 맛집</h2>
    <!-- ################################################################################################ -->
    <ul class="nospace group">
      <li class="one_half first">
        <article><img class="imgl radius-10" src="../images/demo/100x100.gif" alt="">
          <h6 class="heading"><a href="#">Lorem Ipsum Dolor</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
        </article>
      </li>
      <li class="one_half">
        <article><img class="imgl radius-10" src="../images/demo/100x100.gif" alt="">
          <h6 class="heading"><a href="#">Lorem Ipsum Dolor</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
        </article>
      </li>
    </ul>
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>

<script>
 new Vue({
	 el:'.container',
	 data:{
		 cate_list:[]
	 },
	 mounted:function(){
		 axios.get("http://localhost/web/food/category_vue.do")
		 .then(response=>{
			 console.log(response.data)
			 this.cate_list=response.data
		 })
	 }
 })
</script>

</body>
</html>