let index = {
    init: function () {
        $("#btn-save").on("click", () => {
           this.save();
        });
    }
    ,
    save: function () {
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
        };

        $.ajax({
            type:"POST",
            url:"/api/board",
            data:JSON.stringify(data),
            contentType:"application/json; charset=UTF-8",
            dataType:"json"
        }).done(function(req){
            alert("글쓰기가 완료 되었습니다.");
            location.href ="/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
}
index.init();
