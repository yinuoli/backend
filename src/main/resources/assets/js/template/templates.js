(function() {
window["JST"] = window["JST"] || {};

window["JST"]["post"] = function(obj) {
obj || (obj = {});
var __t, __p = '', __j = Array.prototype.join;
function print() { __p += __j.call(arguments, '') }
with (obj) {

_.each(articles, function (article) {;
__p += '\n<div id="' +
((__t = (article.id)) == null ? '' : __t) +
'" class="w3-card-4 w3-margin-bottom">\n    <header class="w3-container w3-light-grey">\n        <h3>' +
((__t = (article.title)) == null ? '' : __t) +
'</h3>\n    </header>\n    <div class="w3-container w3-white">\n        <p>' +
((__t = (article.content)) == null ? '' : __t) +
'</p>\n    </div>\n    <button class="w3-btn-block w3-dark-grey">view</button>\n    <button onclick="deletePost(\'' +
((__t = (article.id)) == null ? '' : __t) +
'\')" class="w3-btn-block w3-dark-grey" data-id="' +
((__t = (article.id)) == null ? '' : __t) +
'">delete\n    </button>\n</div>\n';
});;


}
return __p
}})();