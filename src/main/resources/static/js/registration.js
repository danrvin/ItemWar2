function addUser() {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", arguments[0], false);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    bodyStr = arguments[1]
    xhr.send(bodyStr)
    //document.location.href = "http://localhost:8080/html/" + xhr.responseText
    document.location.href = "/../" + xhr.responseText
}