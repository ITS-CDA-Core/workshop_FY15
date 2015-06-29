var mongoose = require('mongoose');

var schema = new mongoose.Schema({
	chatRoomId: Schema.Types.ObjectId,
	message: String,
	createdByUserId: Schema.Types.ObjectId,
	createdByUserName: String,
	createdAt: Date
});

module.exports = mongoose.model('ChatMessage', schema);
