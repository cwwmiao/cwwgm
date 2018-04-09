function getResponse(url,data,contentType){
    var processData=true;
    if(url==null)
        return;
    if(contentType==null){
        contentType='application/json;charset=utf-8';
    }else if(contentType=="multipart/form-data"){
        contentType=false;
        processData=false;
    }

    if(data==null)
        data={};
    var result=$.ajax({
        type: "post",
        url: url,
        data: data,
        contentType:contentType,
        processData: processData,
        async: false
    });
    return result;
}


function getData(url,data,contentType){
    var response=getResponse(url,data,contentType);
    return response.data;
}
