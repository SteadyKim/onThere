

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