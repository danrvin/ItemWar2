
function loginUser() {
    var xhr = new XMLHttpRequest();
    xhr.open("POST","/loginUser", false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8')
    bodyStr = arguments[0]
    // alert(bodyStr)
    xhr.send(bodyStr)
    let str = "http://localhost:8080/html/" + xhr.responseText
    // alert(str)
    document.location.href = "http://localhost:8080/html/" + xhr.responseText
    // return xhr.responseText
}