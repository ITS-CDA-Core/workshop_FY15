var express = require('express');
var router = express.Router();
var ChatRoom = require('../../models/ChatRoom');
var ChatMessage = require('../../models/ChatMessage');

/* For Example
curl http://localhost:3000/api/chat_rooms -v -X POST -H 'Content-Type:application/json' -d '{"title":"Chat Room 1", "createdBy":"imaizm", "createdAt":"2015-01-01T09:00+09"}'
curl http://localhost:3000/api/chat_rooms -v -X POST -H 'Content-Type:application/json' -d '{"title":"Chat Room 2", "createdBy":"Kohara", "createdAt":"2015-01-02T23:59+09"}'
curl http://localhost:3000/api/chat_rooms -v -X GET
curl http://localhost:3000/api/chat_rooms/1 -v -X DELETE
curl http://localhost:3000/api/chat_rooms -v -X GET
 */

router.get('/', function(req, res, next) {
	ChatRoom.find({}, function(err, results) {
		if (err) return next(err);

		res.json(results);
	});
});

router.get('/:id', function(req, res, next) {
	ChatRoom.findById(req.params.id, function (err, result) {
		if (err) return next(err);

		res.json(result);
	});
});

router.get('/:id/chat_messages', function(req, res, next) {
	var query = {chatRoomId: req.params.id};
	var options = {sort: {createdAt: 1}};
	ChatMessage.find(query, {}, options, function (err, result) {
		if (err) return next(err);

		res.json(result);
	});
});

router.post('/', function(req, res, next) {
	var chatRoom = req.body;
	chatRoom.createdAt = new Date();

	ChatRoom.create(chatRoom, function (err, result) {
		if (err) return next(err);

		res.json(result);
	});
});

router.put('/:id', function(req, res, next) {
	ChatRoom.findByIdAndUpdate(req.params.id, req.body, function (err, result) {
		if (err) return next(err);

		res.json(result);
	});
});

router.delete('/:id', function(req, res, next) {
	var query = {chatRoomId: req.params.id};

	ChatMessage.remove(query, function (err, result) {
		if (err) return next(err);

		ChatRoom.findByIdAndRemove(req.params.id, req.body, function (err, result) {
			if (err) return next(err);

			res.json(result);
		});

	});

});

module.exports = router;
