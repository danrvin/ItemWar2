class User{
    username;
    password;
}

function jsonUserCreate() {
    let user1 = new User();
    user1.password = arguments[1]
    user1.username = arguments[0]
    return JSON.stringify(user1);
}