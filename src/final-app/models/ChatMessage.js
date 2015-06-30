var mongoose = require('mongoose');

var schema = new mongoose.Schema({
	chatRoomId: mongoose.Schema.Types.ObjectId,
	message: String,
	createdByUserId: mongoose.Schema.Types.ObjectId,
	createdByUserName: String,
	createdAt: Date
});

module.exports = mongoose.model('ChatMessage', schema);
