var express = require('express');
var router = express.Router();
var User = require('../../models/User');

/* For Example
curl http://localhost:3000/api/users -v -X POST -H 'Content-Type:application/json' -d '{"userName":"imaizm", "password":"password", "avatarId":"01"}'
curl http://localhost:3000/api/users -v -X POST -H 'Content-Type:application/json' -d '{"userName":"kohara", "password":"password", "avatarId":"02"}'
curl http://localhost:3000/api/users -v -X GET
curl http://localhost:3000/api/users/imaizm -v -X DELETE
curl http://localhost:3000/api/users -v -X GET
 */

/*
router.get('/', function(req, res, next) {
	res.send('respond with a resource');
});
*/

router.get('/', function(req, res, next) {
	User.find({}, function(err, results) {
		if (err) return next(err);

		res.json(results);
	});
});

router.get('/:id', function(req, res, next) {
	User.findById(req.params.id, function (err, result) {
		if (err) return next(err);

		res.json(result);
	});
});

router.post('/', function(req, res, next) {
	var user = req.body;
	user.createdAt = new Date();

	User.create(user, function (err, result) {
		if (err) return next(err);

		res.json(result);
	});
});

router.put('/:id', function(req, res, next) {
	User.findByIdAndUpdate(req.params.id, req.body, function (err, result) {
		if (err) return next(err);

		res.json(result);
	});
});

router.delete('/:id', function(req, res, next) {
	User.findByIdAndRemove(req.params.id, req.body, function (err, result) {
		if (err) return next(err);

		res.json(result);
	});
});

module.exports = router;
