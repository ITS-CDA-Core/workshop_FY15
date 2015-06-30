var express = require('express');
var router = express.Router();
var ChatMessage = require('../../models/ChatMessage');

/* For Example
 */

router.get('/', function(req, res, next) {
	ChatMessage.find({}, function(err, results) {
		if (err) return next(err);

		res.json(results);
	});
});

router.get('/:id', function(req, res, next) {
	ChatMessage.findById(req.params.id, function (err, post) {
		if (err) return next(err);

		res.json(result);
	});
});

router.post('/', function(req, res, next) {
	var chatMessage = req.body;
	chatMessage.createdAt = new Date();

	ChatMessage.create(chatMessage, function (err, result) {
		if (err) return next(err);

		res.json(result);
	});
});

router.put('/:id', function(req, res, next) {
	ChatMessage.findByIdAndUpdate(req.params.id, req.body, function (err, post) {
		if (err) return next(err);

		res.json(result);
	});
});

router.delete('/:id', function(req, res, next) {
	ChatMessage.findByIdAndRemove(req.params.id, req.body, function (err, post) {
		if (err) return next(err);

		res.json(result);
	});
});

module.exports = router;
