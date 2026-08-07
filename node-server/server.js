const express = require("express");
const app = express();
const port = process.env.PORT || 7070;

function getRandomColor() {
  var letters = '0123456789ABCDEF';
  var color = '#';
  for (var i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

var color = getRandomColor();
var servername = require('os').hostname();
app.get('/', function(req, res){
    var msg = `<h1 style="color:${color};">NODEJS - Server: ${servername} </h1>`;
    res.send(msg);
});

app.listen(port, function(){
    console.log("Server running at http://localhost:"+port);
});