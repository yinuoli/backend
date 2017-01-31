function click() {
    var user = {};
    user.id = '95c46636617946beba607270529ca6b4';
    user.email = 'david.liu.g@outlook.com';
    user.password = '12345678';
    user.name = 'evil';
    user = JSON.stringify(user);
    $.post("/api/user/register", user, function (data) {
        alert(data);
    })
}

function init() {
    $('button').on('click', click);
}