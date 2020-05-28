var nodemailer = require('nodemailer');

var transporter = nodemailer.createTransport({
    service: 'Naver',
    host: 'smtp.naver.com',
    port: 587,
    auth: {
        user: 'lunell513@naver.com',
        pass: 'imksw*4969'
    }
});

var mailOptions = {
    from: 'lunell513@naver.com',
    to: '',
    subject: 'Sending Email using Node.js',
    text: 'That was easy!'
};

transporter.sendMail(mailOptions, function (error, info) {
    if (error) {
        console.log(error);
    } else {
        console.log('Email sent: ' + info.response);
    }
});
