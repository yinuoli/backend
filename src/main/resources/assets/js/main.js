function getFormData(form) {
    var data = {};
    form.serializeArray().map(function(x){data[x.name] = x.value;});
    data = JSON.stringify(data);
    return data;
}