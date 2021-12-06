
function loginUser() {
    var xhr = new XMLHttpRequest();
    xhr.open("POST",arguments[0], false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8')
    bodyStr = arguments[1]
    alert(bodyStr)
    xhr.send(bodyStr)
    let str = "http://localhost:8080/html/" + xhr.responseText
    alert(str)
    document.location.href = "http://localhost:8080/html/" + xhr.responseText
    // return xhr.responseText
}