function addressKindChange2 (e){
    var seoul = ["선택", "종로구", "중구", "용산구", "동대문구", "서대문구", "마포구", "영등포구", "동작구", "관악구", "서초구", "강남구", "송파구"];
    var jeju = ["선택", "제주시", "서귀포시"];
    var busan = ["선택", "영도구", "부산진구", "동래구", "해운대구", "강서구", "수영구", "기장군"];
    var daegu = ["선택", "수성구", "달서구", "달성군"];
    var incheon = ["선택", "중구", "동구", "미추홀구", "연수구", "남동구", "부평구", "계양구", "서구", "강화군", "옹진군"];
    var suwon = ["선택", "장안구", "권선구", "팔달구", "영통구"];
    var jeonju = ["선택", "완산구", "덕진구"];
    var changwon = ["선택", "의창구", "성산구", "마산합포구", "마산회원구", "진해구"];
    var cheonan = ["선택", "동남구", "서북구"];

    var target = document.getElementById("reselect_value2");

    if(e.value == '108') var d = seoul;
    else if (e.value == '184') var d = jeju;
    else if (e.value == '159') var d = busan;
    else if (e.value == '143') var d = daegu;
    else if (e.value == '112') var d = incheon;
    else if (e.value == '119') var d = suwon;
    else if (e.value == '146') var d = jeonju;
    else if (e.value == '295') var d = changwon;
    else if (e.value == '232') var d = cheonan;

    target.options.length = 0;

    for(x in d){
        var opt = document.createElement("option");
        opt.value = d[x];
        opt.innerHTML = d[x];
        target.appendChild(opt);
    }
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
    var value_str = document.getElementById('reselect_value');
    test = value_str.options[value_str.selectedIndex].value; //108
    //var local =  value_str.options[value_str.selectedIndex].value2;

    var local = $("#reselect_value > option:selected").attr("value2") //서울

    var graphobj=[];
    var graphlabel=[];

    smalllocal = $("#reselect_value2 > option:selected").attr("value");
  console.log(smalllocal); //마포구

  var showlocal = local + " " + smalllocal;
  console.log(showlocal);

  //서울

  if(smalllocal == "종로구"){
    visitcode = "11110"}
  else if(smalllocal == "중구"){
    visitcode = "11140"}
  else if(smalllocal == "용산구"){
    visitcode = "11140"}
  else if(smalllocal == "동대문구"){
    visitcode = "11230"}
  else if(smalllocal == "서대문구"){
    visitcode = "11410"}
  else if(smalllocal == "마포구"){
    visitcode = "11440"}
  else if(smalllocal == "영등포구"){
    visitcode = "11560"}
  else if(smalllocal == "동작구"){
    visitcode = "11590"}
  else if(smalllocal == "관악구"){
    visitcode = "11620"}
  else if(smalllocal == "서초구"){
    visitcode = "11650"}
  else if(smalllocal == "강남구"){
    visitcode = "11680"}
  else if(smalllocal == "송파구"){
    visitcode = "11710"} //부산
  else if(smalllocal == "영도구"){
    visitcode = "26200"}
  else if(smalllocal == "부산진구"){
    visitcode = "26230"}
  else if(smalllocal == "동래구"){
    visitcode = "26260"}
  else if(smalllocal == "해운대구"){
    visitcode = "26350"}
  else if(smalllocal == "강서구"){
    visitcode = "26440"}
  else if(smalllocal == "수영구"){
    visitcode = "26500"}
  else if(smalllocal == "기장군"){
    visitcode = "26710"}//제주
  else if(smalllocal == "제주시"){
    visitcode = "50110"}
  else if(smalllocal == "서귀포시"){
    visitcode = "50130"}//대구
  else if(smalllocal == "수성구"){
    visitcode = "27260"}
  else if(smalllocal == "달서구"){
    visitcode = "27290"}
  else if(smalllocal == "달성군"){
    visitcode = "27710"}//인천
  else if(smalllocal == "중구"){
    visitcode = "28110"}
  else if(smalllocal == "동구"){
    visitcode = "28140"}
  else if(smalllocal == "미추홀구"){
    visitcode = "28177"}
  else if(smalllocal == "연수구"){
    visitcode = "28185"}
  else if(smalllocal == "남동구"){
    visitcode = "28200"}
  else if(smalllocal == "부평구"){
    visitcode = "28237"}
  else if(smalllocal == "계양구"){
    visitcode = "28245"}
  else if(smalllocal == "서구"){
    visitcode = "28260"}
  else if(smalllocal == "광화군"){
    visitcode = "28710"}
  else if(smalllocal == "옹진군"){
    visitcode = "29720"}//수원
  else if(smalllocal == "장안구"){
    visitcode = "41111"}
  else if(smalllocal == "권선구"){
    visitcode = "41113"}
  else if(smalllocal == "팔달구"){
    visitcode = "41115"}
  else if(smalllocal == "영통구"){
    visitcode = "41117"}//천안
  else if(smalllocal == "동남구"){
    visitcode = "44131"}
  else if(smalllocal == "서북구"){
    visitcode = "44133"}//전주
  else if(smalllocal == "완산구"){
    visitcode = "45111"}
  else if(smalllocal == "덕진구"){
    visitcode = "45113"}//창원
  else if(smalllocal == "의창구"){
    visitcode = "48121"}
  else if(smalllocal == "성산구"){
    visitcode = "48123"}
  else if(smalllocal == "마산합포구"){
    visitcode = "48125"}
  else if(smalllocal == "마산회원구"){
    visitcode = "48127"}
  else if(smalllocal == "진해구"){
    visitcode = "48129"}



    $.ajax({
    type:"get",
    url:"https://aygix7ub7k.execute-api.ap-northeast-2.amazonaws.com/beta/result",
    data: {"date_str": g, "temp_region_code": test, "visit_region_code": visitcode},
    dataType:"json",
    success: function(data){
        console.log("통신성공");
        console.log(data);




        var num = data;
        document.getElementById("lasttemp").innerHTML = num[3]; //작년기온
        document.getElementById("lastyeardate").innerHTML = lastdate; //기온-작년날짜
        document.getElementById("selectedday").innerHTML = g; //예측관광객카드 날짜
        //document.getElementById("tourcount").innerHTML = num[18]+" 명";
        document.getElementById("selectedlocal").innerHTML = showlocal; //상단 선택지역
        document.getElementById("cleardate").innerHTML = g; //상단 선택날짜

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

