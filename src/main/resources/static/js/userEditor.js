class User{
    username;
    password;
    email;
}

function jsonUserCreate() {
    let user1 = new User();
    user1.password = arguments[1]
    user1.username = arguments[0]
    user1.email = arguments[2]
    return JSON.stringify(user1);
}