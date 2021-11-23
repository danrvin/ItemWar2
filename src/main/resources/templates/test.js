function sendPostServer() {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", '/user', false);
    xhr.setRequestHeader('Content-type', 'text/place; charset=utf-8');
    bodyStr = arguments[0] + '#' + arguments[1];
    xhr.send(bodyStr)
}


//bodyStr = '{\"name\" : \"'+arguments[0]+'\", \"password\" : \"'+arguments[1]+'\"}'
//xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');