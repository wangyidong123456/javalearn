define("question:widget/ask/pc-exp/ask-img",function(i){var e=i("common:widget/lib/jquery/jquery"),t=(i("common:widget/js/ui/dialog/dialog"),i("common:widget/js/logic/category/category"),i("common:widget/js/util/log/log"),i("question:widget/read-opt/img-preview/preview")),o=e(".q-img-ul"),n=e(".q-img-con"),g=o.width(),l=n.width();l>=g&&(e(".q-img-prev-wp").remove(),e(".q-img-next-wp").remove()),e(".q-img-next").on("click",function(){var i=o.position().left;o.animate(g+i>=2*l?{left:"-"+(l-i)+"px"}:{left:"-"+(g-l)+"px"})}),e(".q-img-prev").on("click",function(){var i=o.position().left;o.animate(-l>=i?{left:i+l+"px"}:{left:"0px"})}),new t({$el:".q-img-li",imgAttr:"data-src"}),e(".replyask-box .ikqb_img_alink").click=null,new t({$el:".replyask-box .ikqb_img_alink",imgAttr:"href"})});