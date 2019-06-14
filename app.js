var express = require('express');
var request = require('request');
var cors = require('cors');
var cookieParser = require('cookie-parser');

var client_id = process.env.CLIENT_ID_M;
var client_secret = process.env.CLIENT_SECRET_M;

var app = express();

app
   .use(cors())
   .use(cookieParser());

app.get('/musixmatch/auth', function(req, res) {

  let token;

  var authOptions = {
    url: '',
    headers: {
      'Authorization': 'Basic ' + (new Buffer.from(client_id + ':' + client_secret).toString('base64'))
    },
    form: {
      grant_type: 'client_credentials'
    },
    json: true
  };

  request.post(authOptions, function(error, response, body) {
    if (!error && response.statusCode === 200) {
      token = body.access_token;
    }
  });

  setTimeout(() => {
    res.end(JSON.stringify({'token':token}));
  }, 1500);
});

console.log('Listening on 8888');
app.listen(8888);