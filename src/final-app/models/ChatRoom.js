var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/its_chat');

var schema = new mongoose.Schema({
	title: String,
	createdByUserId: Schema.Types.ObjectId,
	createdByUserName: String,
	createdAt: Date
});

module.exports = mongoose.model('ChatRoom', schema);
