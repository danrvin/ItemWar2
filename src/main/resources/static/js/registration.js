function addUser() {
    alert(arguments[0], arguments[1], arguments[2])
    var xhr = new XMLHttpRequest();
    xhr.open("POST", arguments[0], false);
    alert(arguments[0], arguments[1], arguments[2])
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    alert(arguments[0], arguments[1], arguments[2])
    bodyStr = arguments[1]
    xhr.send(bodyStr)
    //document.location.href = "http://localhost:8080/html/" + xhr.responseText
    document.location.href = "/../" + xhr.responseText
    alert(arguments[0], arguments[1], arguments[2])
}