

const onDeleteClickHandler = async (obj) => {
    let tr = obj.parentNode.parentNode;
    const res =  await fetch(`http://localhost:8080/api/record/${obj.value}`,{
        method:"DELETE",
    }).then(res => console.log(res))
        .catch(e => console.log(e))

    tr.parentNode.removeChild(tr);
}

//TODO 프론트 참고용 코드

const onCLickHandler = async () => {
    const data = await fetch("http://localhost:8080/api/record",{
        method:"GET"
    })
        .then((res) => {
            return res.json()
        }).then(data => {
                console.log(data)
                data.map(obj=>{
                    for (const key in obj){
                        document.getElementById('show_data').innerText += `${key} : ${obj[key]}`
                    }
                })
            }
        )
        .catch((err) => console.log(err))
}
document.getElementById('btn').addEventListener("click",onCLickHandler)
