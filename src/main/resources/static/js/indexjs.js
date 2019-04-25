
function byId(id){
    return typeof(id)==="string"?document.getElementById(id):id;
}//封装getElementById();
var index=0;
    timer=null;
    main=byId("main");
    nowbanner=byId("all").getElementsByTagName("div");
    nownav=byId("navigation").getElementsByTagName("div");

function  bannerend() {
       if(timer) clearInterval(timer);
}//清除轮播
function bannerstar() {
    timer = setInterval(function () {
        index++;
        if (index >= nownav.length) {
            index = 0;
        }
            bannernow();
    }, 2000);//自动轮播
}
function bannernow(){
    for(i=0;i<nownav.length;i++){
        nowbanner[i].style.display="none";
        nownav[i].className="nav";//非当前页面格式化
    }//非当前页面格式初始化
    nowbanner[index].style.display="block";
    nownav[index].className="nown";//当前页面格式
}
function opene(){
    main.onmouseover=function(){
        bannerend();//清除轮播
    };
    main.onmouseout=function(){
        bannerstar();//开始轮播
    };

    for(var i=0;i<nownav.length;i++){
        nownav[i].onclick = function(){
            index = this.id;
            bannernow();
        };
        nownav[i].onmouseover = function(){
            index = this.id;
            bannernow();
        };
    }//点击切换
    main.onmouseout();//自动事件
}
opene();
