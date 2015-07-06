var express = require('express');
var router = express.Router();
var User = require('../../models/User');

/* For Example
curl http://localhost:3000/api/users -v -X POST -H 'Content-Type:application/json' -d '{"userName":"imaizm", "password":"password"}'
 */

/*
	var query = {chatRoomId: req.params.id};
	var options = {sort: {createdAt: 1}};
	ChatMessage.find(query, {}, options, function (err, result) {
		if (err) return next(err);

		res.json(result);
	});

*/

router.post('/', function(req, res, next) {
	var loginInfo = req.body;
	var query = {
		userName: loginInfo.userName,
		password: loginInfo.password
	};

	User.find(query, function (err, result) {
		if (err) return next(err);

		res.json(result);
	});
});

module.exports = router;
