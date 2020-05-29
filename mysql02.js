// MySQL 8.0에서는 다음 구문 실행해야 함
// alter user 'root'@'localhost' identified with mysql_native_password by'1234';

// 모듈을 추출합니다.
// 모듈을 추출합니다.
var fs = require('fs');
var ejs = require('ejs');
var mysql = require('mysql');
var express = require('express');
var bodyParser = require('body-parser');



// 데이터베이스와 연결합니다.
var client = mysql.createConnection({
    user: 'root',
    password: '1234',
    database: 'company'
});

// 서버를 생성합니다.
var app = express();
app.use(bodyParser.urlencoded({
    extended: false
}));

// 서버를 실행합니다. *listen이 start와 같은 의미.
app.listen(52273, function () {
    console.log('server running at http://127.0.0.1:52273');
});


// '/'는 root directory를 의미함.
// 'http://localhost:52273'로 접속했을 때 html페이지 화면이 보임
// 상품목록 페이지
app.get('/', function (request, response) {
    // 파일을 읽습니다.
    fs.readFile('list.html', 'utf8', function (error, data) {
        // 데이터베이스 쿼리를 실행합니다.
        client.query('SELECT * FROM products', function (error, results) {
            // 응답합니다.
            // .send는 브라우저로 보내는 역할
            response.send(ejs.render(data, {
                productList: results //productList는 attribute 이름. list.html의 productList에서 받게됨.
            }));
        });
    });
});


// 상품등록 페이지로 이동
app.get('/insert', function (request, response) {
    // 파일을 읽습니다.
    fs.readFile('insert.html', 'utf8', function (error, data) {
        // 응답합니다.
        response.send(data);
    });
});

// 상품등록 처리
app.post('/insert', function (request, response) {
    var body = request.body;
    client.query('insert into products(name,modelnumber,series) values(?,?,?)',
        [body.name, body.modelnumber, body.series],
        function () {
            response.redirect("/");
        }
    )
});

//상품수정폼
app.post('/edit/:id',function(fequest,response){
      // 파일을 읽습니다.
      fs.readFile('edit.html', 'utf8', function (error, data) {
        client.query('SELECT * FROM products where id=?',
          [request.params.id],
            function(error,results){
              response.send(ejs.render(data,{
                productList: results
              }));
            });
        });
});

//상품수정처리
app.post('/edit/:id', function (request, response) {
  // 변수를 선언합니다.
  var body = request.body;
  // 데이터베이스 쿼리를 실행합니다.
  client.query('UPDATE products SET name=?, modelnumber=?, series=? WHERE id=?',
   [body.name, body.modelnumber, body.series,request.params.id],
    function () {
     // 응답합니다.
      response.redirect('/');
  });
});

//삭제하기
app.get('/delete/:id', function (request, response) {
  // 데이터베이스 쿼리를 실행합니다.
  client.query('DELETE FROM products WHERE id=?', [request.params.id], function () {
    // 응답합니다.
    response.redirect('/');
  });
});