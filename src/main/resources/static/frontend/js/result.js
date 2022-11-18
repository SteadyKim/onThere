
// function getJSON() {
//   $.ajax({
//   type:"get",
//   url:"https://qnzs6li797.execute-api.ap-northeast-2.amazonaws.com/2022-11-18/test",
//   data: {"id":1},
//   dataType:"json",
//   success: function(data){
//       console.log("통신성공");
//       console.log(data);
     
      
//   },
//   error:function(){
//       console.log("통신에러");
//   }
// })
// }


//기온 데이터 받아오고 보여주기(작년)
function getTemperature() {
      $.ajax({
      type:"get",
      url:"",
      data: "",
      dataType:"json",
      success: function(data){
          console.log("통신성공");
          console.log(data);
          // 기온 숫자로 받아오고 그대로 보여주기만 하면 됨 + 날짜도


         
          
         },
      error:function(){
          console.log("통신에러");
      }
    })
}

//기온 데이터 받아오고 보여주기(검색 기준 올해)
//만일 검색날이 오늘(사용자기준)로부터 10일 이상일 경우 -> SORRY
//10일 이하일 경우만 데이터 받아오는 함수 실행
function getTemperature() {
    $.ajax({
    type:"get",
    url:"",
    data: "",
    dataType:"json",
    success: function(data){
        console.log("통신성공");
        console.log(data);
        // 기온 숫자로 받아오고 그대로 보여주기만 하면 됨 + 날짜도

       
        
       },
    error:function(){
        console.log("통신에러");
    }
  })
}

// 예상관광객수 데이터 받아오는 js
function TouristNum() {
    $.ajax({
    type:"get",
    url:"",
    data: "",
    dataType:"json",
    success: function(data){
        console.log("통신성공");
        console.log(data);
        // 예상 관광객 수 받아오고 그대로 보여주기만 하면 됨 + 날짜도 + 혼잡도 표현

        
       },
    error:function(){
        console.log("통신에러");
    }
  })
}


