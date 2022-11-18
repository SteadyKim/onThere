var data = {
    labels: [
        "2019", "2020", "2021", "2022"
    ],
    datasets: [
        {
            label: '관광객 수',
            data: [
                //0, 0, 0, 0 으로 두면 여기에 데이터 들어옴 (?)
                // 화면 확인하기 위한 임시 값
                12000, 24000, 21000, 23458
                
            ],
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
    data: data,
    options: options
});

//버튼을 누르면 ajax요청을 하고 데이터베이스의 값을 받아온다. 그러면 이 버튼은 메인페이지의 검색이 되어야하나? 
var button = document.getElementById("sendAjax")
 
button.addEventListener("click", function() {
    sendAjax(''); //URL 추가
})
 
function sendAjax(url) {
    var oReq = new XMLHttpRequest();
 
    oReq.open('POST', url); // 요청 초기화
    oReq.setRequestHeader('Content-Type', "application/json") //보내는 본문의 Content-Type을 JSON으로 설정                    
    oReq.send(); // 서버에 요청
    //데이터 가져오기
    oReq.addEventListener('load', function() { 
        var result = JSON.parse(oReq.responseText); //데이터 문자열 형태로 들어와서 JSON객체로 바꿔줘야하는데 그때의 파싱함수
        var score = result.score;
        var comp_data = data.datasets[0].data;
 
        for (var i = 0; i < comp_data.length; i++) {
            comp_data[i] = score[i];
        }
 
        data.datasets[0].data = comp_data;
        myBarChart.update();
    })
}

