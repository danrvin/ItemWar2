class Item {
    name;
    description;
    prise;
}

function addItem() {
    let item = new Item;
    item.prise = arguments[2]
    item.name = arguments[0]
    item.description = arguments[1]
    let s1 = JSON.stringify(item)
    var xhr = new XMLHttpRequest()
    xhr.open("POST", 'createItem', false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8')
    bodyStr = s1
    xhr.send(bodyStr)
    return xhr.responseText
}