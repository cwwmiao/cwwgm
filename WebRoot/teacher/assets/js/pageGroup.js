var currentPage=1;
function genPageList(pageCount,pageSize){
	   maxPageNum=Math.ceil(pageCount/pageSize);
	   if(maxPageNum < 5)
		   page_icon(1,maxPageNum, 1);
	   else
		   page_icon(1, 5, 1);
   }
   
   function page_icon(start_page,end_page,eq){
	    var ul_html = '<li > <a href="#">上一页</a> </li>';
	    for(var i=start_page; i<=end_page; i++){
	        ul_html += '<li><a href="#">'+i+'</a></li>';
	    }
	    ul_html+='<li> <a href="#">下一页</a> </li>';
	    eq=eq-start_page;
	    $("#pageGro ul").html(ul_html);
       var p_class = $("li");
       $("li").attr("class", "paginate_button previous");
       $("li").attr("aria-controls", "dataTables-example");

       $("li").attr("tabindex", "0");
	    // $("#pageGro ul li").eq(eq).addClass("on");
	}

   $("#pagelist").on("click","a",function(){
   	console.log("当前页");
   		console.log(currentPage);
       var pageList=$("#pageGro li");
		if(this.innerHTML=='上一页'){
			if(currentPage-2>=0) {
                show(currentPage - 2);
                currentPage=currentPage - 1;
            }
		}
		if(this.innerHTML=='下一页'){
			if(currentPage<pageList.length-2) {
                show(currentPage)
                currentPage=currentPage + 1;
            }
		}
		if(this.innerHTML!='上一页'&&this.innerHTML!='下一页') {
            pageNum = this.innerHTML * 1;
            currentPage = pageNum;
            show(pageNum - 1);
        }

       //$("#pageGro ul li").removeClass("on");
       //$(this).addClass("on");
   });

