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
    submit(username, password, "login");
}

function logup() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var passwordConfirm = document.getElementById("passwordConfirm").value;
    if (username == "") {
        alert("请输入账号");
        return false;
    }
    if (password == "") {
        alert("请输入密码");
        return false;
    }
    if (passwordConfirm == "") {
        alert("请确认密码");
        return false;
    }
    if (password != passwordConfirm) {
        alert("两次输入密码不一致");
        return false;
    }
    submit(username, password, "logup");
}

function submit(username, password, action) {
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
    form.action = action;
    document.body.appendChild(form);
    form.submit();
    document.body.removeChild(form);
}

function build(username, type, id, level) {
    var usernameElement = document.createElement("input");
    usernameElement.setAttribute("name", "username");
    usernameElement.setAttribute("type", "hidden");
    usernameElement.value = username;
    var typeElement = document.createElement("input");
    typeElement.setAttribute("name", "type");
    typeElement.setAttribute("type", "hidden");
    typeElement.value = type;
    var idElement = document.createElement("input");
    idElement.setAttribute("name", "id");
    idElement.setAttribute("type", "hidden");
    idElement.value = id;
    var levelElement = document.createElement("input");
    levelElement.setAttribute("name", "level");
    levelElement.setAttribute("type", "hidden");
    levelElement.value = level;

    var form = document.createElement("FORM");
    form.method = "POST";
    form.appendChild(usernameElement);
    form.appendChild(typeElement);
    form.appendChild(idElement);
    form.appendChild(levelElement);
    form.action = "/building";
    document.body.appendChild(form);
    form.submit();
    document.body.removeChild(form);
}

function trainSoldier(username, soldierType, soldierNumber, presentGold, cost) {

    if (cost * soldierNumber > presentGold) {
        alert("金币不足");
        return;
    }

    var usernameElement = document.createElement("input");
    usernameElement.setAttribute("name", "username");
    usernameElement.setAttribute("type", "hidden");
    usernameElement.value = username;
    var soldierTypeElement = document.createElement("input");
    soldierTypeElement.setAttribute("name", "soldierType");
    soldierTypeElement.setAttribute("type", "hidden");
    soldierTypeElement.value = soldierType;
    var soldierNumberElement = document.createElement("input");
    soldierNumberElement.setAttribute("name", "soldierNumber");
    soldierNumberElement.setAttribute("type", "hidden");
    soldierNumberElement.value = soldierNumber;

    var form = document.createElement("FORM");
    form.method = "POST";
    form.appendChild(usernameElement);
    form.appendChild(soldierTypeElement);
    form.appendChild(soldierNumberElement);
    form.action = "/train";
    document.body.appendChild(form);
    form.submit();
    document.body.removeChild(form);
}