const express = require('express');
const os = require('os');
const router = express.Router();
const db = require('../dbconnection');

/* GET home page. */
router.get('/api/getUsername', (req, res, next) => {
    res.send({ username: os.userInfo().username });
});

router.get('/getData', (req, res) => {
    db.query("select * from `table`", (err, rows) => {
    if (!err) {
        res.send(rows);
    } else {
        console.log(`query error : ${err}`);
        res.send(err);
    }
    });
});

//로그인
router.get("/api/isLogin", (req, res) => {
    
    const userId = req.query.id;
    const userPw = req.query.pw;

    db.query("select count(*) as cnt from getuser where id='"+userId+"' and pw='"+userPw+"'", (err, rows, fields) => {
        console.log(rows[0].cnt)
        
        res.send({rs : rows[0].cnt});
    });
})

module.exports = router;

