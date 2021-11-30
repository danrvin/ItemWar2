class User{
    username;
    password;
    }

function sendPostServer() {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", arguments[0], false);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    bodyStr = arguments[1]
    xhr.send(bodyStr)
    return xhr.responseText
}

function getAllUser() {
    var xhr = new XMLHttpRequest()
    xhr.open("GET", '/getUsers', false)
    xhr.setRequestHeader('Content-type', 'text/place; charset=utf-8')
    xhr.send()
    return xhr.responseText
}