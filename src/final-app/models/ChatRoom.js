var mongoose = require('mongoose');

var schema = new mongoose.Schema({
	title: String,
	createdByUserId: mongoose.Schema.Types.ObjectId,
	createdByUserName: String,
	createdByUserAvatarId: String,
	createdAt: Date
});

module.exports = mongoose.model('ChatRoom', schema);
