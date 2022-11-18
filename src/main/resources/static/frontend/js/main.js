var picker = new Pikaday({ 
  field: document.getElementById('startdate'),
  format: 'yyyy-MM-dd',
  toString(date, format) {
    let day = ("0" + date.getDate()).slice(-2);
    let month = ("0" + (date.getMonth() + 1)).slice(-2);
    let year = date.getFullYear();
    return `${year}-${month}-${day}`;
  }
});

var picker = new Pikaday({ 
  field: document.getElementById('enddate'),
  format: 'yyyy-MM-dd',
  toString(date, format) {
    let day = ("0" + date.getDate()).slice(-2);
    let month = ("0" + (date.getMonth() + 1)).slice(-2);
    let year = date.getFullYear();
    return `${year}-${month}-${day}`;
  }
});


function reqAjax2() {
  var location = $("#location").val();
  var startdate = $("#startdate").val();
  var enddate = $("#enddate").val();

  // json 형식으로 바꿀 수 있음 (key)
  var sendData = [{"location": location}, {"startdate" : startdate}, {"enddate" : enddate}]
  $.ajax({
      url:''
      , method : 'POST'
      , data: sendData
      , success :function(){} //데이터 받아오기 성공 후 실행할 함수들 연결예정
  })	
}




// $(document).ready(function(){
//   $.ajax({
//     type: 'get',   //get방식으로 명시
//     url : '',  //이동할 파일 주소
//     dataType:'text',   //문자형식으로 받기
//     success: function(data){   //데이터 주고받기 성공했을 경우 실행할 결과
//             //function(data)를 쓰게 되면 전달받은 데이터가 data안에 담아서 들어오게 된다. 
//       alert(data);   
//     },
//     error:function(){   //데이터 주고받기가 실패했을 경우 실행할 결과
//       alert('실패');
//     }
//   })
// });



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

