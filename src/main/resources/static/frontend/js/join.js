function join_check() {
    var name = $("#name");
    var uid = $("#uid");
    var pw1 = $("#pw1");
    var pw2 = $("#pw2");


    if(name.val() ==""){
        alert("필수 정보를 입력해주세요.");
        return false;
    }

    if(uid.val() ==""){
        alert("필수 정보를 입력해주세요.");
        return false;
    }


    if(pw1.val() ==""){
        alert("필수 정보를 입력해주세요.");
        return false;
    }

    if(pw1.val().length <8 || pw1.val().length > 20){
        alert("비밀번호를 8~20자 사이로 입력해주세요.")
        return false;
    }

    if(pw2.val() ==""){
        alert("필수 정보를 입력해주세요.");
        return false;
    }

    if(pw2.val() != pw1.val()){
        alert("비밀번호를 확인해주세요.")
        return false;
    }

    return true;

}