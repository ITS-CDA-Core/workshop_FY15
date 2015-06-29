var mongoose = require('mongoose');

var schema = new mongoose.Schema({
	userName: String,
	password: String,
	avatarId: String,
	createdAt: Date
});

module.exports = mongoose.model('User', schema);
