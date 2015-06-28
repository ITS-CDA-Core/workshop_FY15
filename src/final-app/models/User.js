var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/its_chat');

var schema = new mongoose.Schema({
	userName: String,
	password: String,
	avatarId: String,
	createdAt: Date
});

module.exports = mongoose.model('User', schema);
