

function getShow(){

    document.getElementById("b").style.display = "";
    document.getElementById("a").style.display = "none";

};

function getJSON() {

  var data1 = {


    labels:
        //"2019", "2020", "2021", "2022"
        graphlabel
    ,
    datasets: [
        {
            label: '관광객 수',
            data:
                //0, 0, 0, 0 으로 두면 여기에 데이터 들어옴 (?)
                // 화면 확인하기 위한 임시 값
                graphobj



            ,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)'

            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)'

            ],
            borderWidth: 1
        }
    ]
};

var options = {
    animation: {
        animateScale: true
    },
    responsive: false,
    scales: {
        yAxes: [
            {
                ticks: {
                    beginAtZero: true
                }
            }
        ]
    },
    maintainAspectRatio :false,
    plugins:{
        legend: {
             display: false
           },
    }
};

var ctx = document.getElementById("myChart").getContext('2d');
var myBarChart = new Chart(ctx, {
    type: 'bar',
    data: data1,
    options: options
});

  //검색날짜
  var date =new Date($("#startdate").val());
  let today = new Date;

  //유저입장 검색을 하고있는 날짜 기준 10일 뒤
  afterten = today.setDate(today.getDate() + 10);
  //afterten = today.toISOString().substring(0,10);


  g = $("#startdate").val() //문자형식 2022-10-23 split 1+2
  var come = $("#enddate").val()

  h = g.split("-");
  var monthday = (h[1]+"-"+h[2]);

  d = String(date.getFullYear()); //올해
  a = String(date.getFullYear()-1); //2021 작년
  b = String(date.getFullYear()-2);
  c = String(date.getFullYear()-3);

  var lastdate = a+"-"+monthday;

  //location
  //var code = $("#location").val();
  var value_str = document.getElementById('select_value');
  test = value_str.options[value_str.selectedIndex].value;
  //var local =  value_str.options[value_str.selectedIndex].value2;

  var local = $("#select_value > option:selected").attr("value2")

  var visit_code = $("#select_value > option:selected").attr("value3")

  var graphobj=[];
  var graphlabel=[];


  $.ajax({
  type:"get",
  url:"https://aygix7ub7k.execute-api.ap-northeast-2.amazonaws.com/beta/result",
  data: {"date_str": g, "temp_region_code": test, "visit_region_code": visit_code},
  dataType:"json",
  success: function(data){
      console.log("통신성공");
      console.log(data);


      var num = data;
      document.getElementById("lasttemp").innerHTML = num[3];
      document.getElementById("lastyeardate").innerHTML = lastdate;
      //sdocument.getElementById("godate").innerHTML = g;
      //document.getElementById("comedate").innerHTML = come;
      document.getElementById("selectedlocal").innerHTML = local;
      document.getElementById("selectedlocal2").innerHTML = local;
      document.getElementById("selectedday").innerHTML = g;
      //document.getElementById("tourcount").innerHTML = num[18]+" 명";


      //올해 기온 함수
      if (date > afterten){
        document.getElementById("thistemp").innerHTML = "SORRY";
        document.getElementById("this-date").innerHTML = "* 기온 정보가 없습니다.";
      }
      else{
        document.getElementById("thistemp").innerHTML = num[3];
        document.getElementById("this-date").innerHTML = g;
      }



      num1 = num[6]*1;
      num2 = num[10]*1;
      num3 = num[14]*1;
      num4 = num[18]*1;
      avg_visit = (num1+num2+num3)/3;

      res = num4.toLocaleString('en-US');
      document.getElementById("tourcount").innerHTML = res+" 명";


      if(avg_visit <  num4){
        document.getElementById("compltxt").innerHTML = "복잡";
      }
      else if(avg_visit >  num4){
        document.getElementById("compltxt").innerHTML = "원활";
      }

      graphlabel=[]

      graphobj=[num[6],num[10],num[14],num[18]]
      console.log(graphobj)
      data1.datasets[0].data = graphobj

      graphlabel=[c,b,a,d]
      data1.labels = graphlabel
      myBarChart.update();





  },
  error:function(){
      console.log("통신에러");
  }
})
}


function getJSON2() {


    $('#myChart').remove();
    $('#graphcontainer').append('<canvas class="graph-container" id="myChart" width="300" height="250"></canvas>');
    canvas = document.querySelector('#myChart');



    var data1 = {


      labels:
          //"2019", "2020", "2021", "2022"
          graphlabel
      ,
      datasets: [
          {
              label: '관광객 수',
              data:
                  //0, 0, 0, 0 으로 두면 여기에 데이터 들어옴 (?)
                  // 화면 확인하기 위한 임시 값
                  graphobj



              ,
              backgroundColor: [
                  'rgba(255, 99, 132, 0.2)',
                  'rgba(54, 162, 235, 0.2)',
                  'rgba(255, 206, 86, 0.2)',
                  'rgba(75, 192, 192, 0.2)'

              ],
              borderColor: [
                  'rgba(255,99,132,1)',
                  'rgba(54, 162, 235, 1)',
                  'rgba(255, 206, 86, 1)',
                  'rgba(75, 192, 192, 1)'

              ],
              borderWidth: 1
          }
      ]
  };

  var options = {
      animation: {
          animateScale: true
      },
      responsive: false,
      scales: {
          yAxes: [
              {
                  ticks: {
                      beginAtZero: true
                  }
              }
          ]
      },
      maintainAspectRatio :false,
      plugins:{
          legend: {
               display: false
             },
      }
  };

  var ctx = document.getElementById("myChart").getContext('2d');
  var myBarChart = new Chart(ctx, {
      type: 'bar',
      data: data1,
      options: options
  });

    //가는날
    var date =new Date($("#dayselect").val());
    let today = new Date;

    //유저입장 검색을 하고있는 날짜 기준 10일 뒤
    afterten = today.setDate(today.getDate() + 10);
    //afterten = today.toISOString().substring(0,10);

    g = $("#dayselect").val() //문자형식 2022-10-23 split 1+2

    h = g.split("-");
    var monthday = (h[1]+"-"+h[2]);

    d = String(date.getFullYear()); //올해
    a = String(date.getFullYear()-1); //2021 작년
    b = String(date.getFullYear()-2);
    c = String(date.getFullYear()-3);

    var lastdate = a+"-"+monthday;

    //location
    //var code = $("#location").val();
    var value_str = document.getElementById('select_value');
    test = value_str.options[value_str.selectedIndex].value;
    //var local =  value_str.options[value_str.selectedIndex].value2;

    var local = $("#select_value > option:selected").attr("value2")

    var visit_code = $("#select_value > option:selected").attr("value3")

    var graphobj=[];
    var graphlabel=[];


    $.ajax({
    type:"get",
    url:"https://aygix7ub7k.execute-api.ap-northeast-2.amazonaws.com/beta/result",
    data: {"date_str": g, "temp_region_code": 108, "visit_region_code": visit_code},
    dataType:"json",
    success: function(data){
        console.log("통신성공");
        console.log(data);




        var num = data;
        document.getElementById("lasttemp").innerHTML = num[3];
        document.getElementById("lastyeardate").innerHTML = lastdate;
        document.getElementById("selectedday").innerHTML = g;
        //document.getElementById("tourcount").innerHTML = num[18]+" 명";

        //올해 기온 함수
        if (date > afterten){
            document.getElementById("thistemp").innerHTML = "SORRY";
            document.getElementById("this-date").innerHTML = "* 기온 정보가 없습니다.";
        }
        else{
            document.getElementById("thistemp").innerHTML = num[3];
            document.getElementById("this-date").innerHTML = g;
        }


        num1 = num[6]*1;
        num2 = num[10]*1;
        num3 = num[14]*1;
        num4 = num[18]*1;
        avg_visit = (num1+num2+num3)/3;

        res = num4.toLocaleString('en-US');
        document.getElementById("tourcount").innerHTML = res+" 명";


        if(avg_visit <  num4){
            document.getElementById("compltxt").innerHTML = "복잡";
        }
        else if(avg_visit >  num4){
            document.getElementById("compltxt").innerHTML = "원활";
        }


        graphlabel=[]

        graphobj=[num[6],num[10],num[14],num[18]]
        console.log(graphobj)
        data1.datasets[0].data = graphobj

        graphlabel=[c,b,a,d]
        data1.labels = graphlabel
        myBarChart.update();





    },
    error:function(){
        console.log("통신에러");
    }
  })
  }

