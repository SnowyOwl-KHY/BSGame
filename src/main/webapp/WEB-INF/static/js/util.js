/**
 * Created by kehanyang on 15/7/6.
 */
function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if (username == "") {
        alert("请输入账号");
        return false;
    }
    if (password == "") {
        alert("请输入密码");
        return false;
    }
    submit(username, password);
}
function submit(username, password) {
    var usernameElement = document.createElement("input");
    usernameElement.setAttribute("name", "username");
    usernameElement.setAttribute("type", "hidden");
    usernameElement.value = username;
    var passwordElement = document.createElement("input");
    passwordElement.setAttribute("name", "password");
    passwordElement.setAttribute("type", "hidden");
    passwordElement.value = password;

    var form = document.createElement("FORM");
    form.method = "GET";
    form.appendChild(usernameElement);
    form.appendChild(passwordElement);
    form.action = "login";
    document.body.appendChild(form);
    form.submit();
    document.body.removeChild(form);
}