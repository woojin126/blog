let index = {
    init: function () {
        $("#btn-save").on("click", () => {
           this.save();
        });
        $("#btn-login").on("click", () => {
            this.login();
        });
    }
    ,
    save: function () {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        $.ajax({
            type:"POST",
            url:"/api/user/join",
            data:JSON.stringify(data), //http body 데이터
            contentType:"application/json; charset=UTF-8", //body 데이터 타입
            dataType:"json" // 요청을 서버로해서 응답이 왔을 때 (기본 모든 응답은 버퍼 = String으로 온다), 결론은 자바스크립트 오브젝트로 바꿔줌
        }).done(function(req){ // req로 컨트롤러단에서 리턴한값이 올것
            alert("회원가입이 완료 되었습니다.");
            location.href = "/";
        }).fail(function(error){
            console.log(error)
        });
    } ,
    login: function () {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
        };

        $.ajax({
            type:"POST",
            url:"/api/user/login",
            data:JSON.stringify(data), //http body 데이터
            contentType:"application/json; charset=UTF-8", //body 데이터 타입
            dataType:"json" // 요청을 서버로해서 응답이 왔을 때 (기본 모든 응답은 버퍼 = String으로 온다), 결론은 자바스크립트 오브젝트로 바꿔줌
        }).done(function(req){ // req로 컨트롤러단에서 리턴한값이 올것
            alert("로그인이 완료 되었습니다.");
            location.href = "/";
        }).fail(function(error){

        });
    }
}
index.init();

