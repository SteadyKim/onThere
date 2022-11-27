

function getShow(){

    document.getElementById("b").style.display = "";
    document.getElementById("a").style.display = "none";
    getJSON();
};

function getJSON() {

//가는날
    var date =new Date($("#startdate").val());
    console.log(date); //날짜형식
    var g = $("#startdate").val() //문자형식 2022-10-23 split 1+2
    console.log(g);

    h = g.split("-");
    var monthday = (h[1]+"-"+h[2]);
    console.log(monthday);

    a = String(date.getFullYear()-1); //2021

    console.log(a);


    var lastdate = a+"-"+monthday;
    console.log(lastdate);

//location
//var code = $("#location").val();
    var value_str = document.getElementById('select_value');
    test = value_str.options[value_str.selectedIndex].value;



    $.ajax({
        type:"get",
        url:"https://yhqcfpgwhd.execute-api.ap-northeast-2.amazonaws.com/result/temp",
        data: {"temp_date_str": lastdate, "temp_region_code": test, "visit_date_str":"20210101", "visit_region_code":"11110"},
//data: {"a":'2022-06-15', "b":102},
        dataType:"json",
        success: function(data){
            console.log("통신성공");
            console.log(data);
            console.log(typeof(data));



            var num = data;
            document.getElementById("lasttemp").innerHTML = num[3];
            document.getElementById("lastyeardate").innerHTML = lastdate;

            //document.getElementById("second").innerHTML = num.temp_region_code;
            //예상관광객 수 보여주기
            //document.getElementById("관광객 수 들어갈 태그의 아이디").innerHTML = num.(예상관광객 수 들어오는 칸);


            // for (i in num) {


            //     // document.getElementById("first").innerHTML = num[i];
            //     // document.getElementById("second").innerHTML = num[i];
            //     //console.log(obj[variable]);
            //     document.getElementById("first").innerHTML = num.a;
            //     document.getElementById("second").innerHTML = num.b;
            // }



        },
        error:function(){
            console.log("통신에러");
        }
    })
}

