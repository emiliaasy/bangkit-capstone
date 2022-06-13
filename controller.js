
const User = require('./model/user')
const firestore = require('./db');
const jwt = require('jsonwebtoken')

const addUser = async (req, res, next) => {
	try {
		const data = req.body;
		await firestore.collection('users').doc().set(data);
		res.send('Data successfuly added');
	} catch (error) {
		res.status(400).send(error.message);
	}
}

const getAllUsers = async (req, res, next) => {
	try {
		const users = await firestore.collection('users');
		const data = await users.get();
		const usersArray = [];
		if (data.empty) {
			res.status(404).send('No student record found');
		} else {
			data.forEach(doc => {
				const user = new User(
					doc.id,
					doc.data().email,
					doc.data().password,
					doc.data().username
				);
				usersArray.push(user);
			});
			res.send(usersArray);
		}
	} catch (error) {
		res.status(400).send(error.message);
	}
}

const getUserById = async (req, res, next) => {
	try {
		const id = req.params.id;
		const user = await firestore.collection('users').doc(id);
		const data = await user.get();
		if (!data.exists) {
			res.status(404).send('User with the given ID not found');
		} else {
			res.send(data.data());
		}
	} catch (error) {
		res.status(400).send(error.message);
	}
}

const updateUser = async (req, res, next) => {
	try {
		const id = req.params.id;
		const data = req.body;
		const user = await firestore.collection('users').doc(id);
		await user.update(data);
		res.send('User successfuly updated');
	} catch (error) {
		res.status(400).send(error.message);
	}
}

const removeUser = async (req, res, next) => {
	try {
		const id = req.params.id;
		await firestore.collection('users').doc(id).delete();
		res.send('User successfuly deleted');
	} catch (error) {
		res.status(400).send(error.message);
	}
}

const loginUser = async (req, res, next) => {
	const { username, password } = req.body

	const userRef = firestore.collection('users');
	const userQuery = await userRef.where('username', '==', username).get();

	if (userQuery.empty) {
		return res.status(404).send('Username not found')
	}

	let user = {};

	userQuery.forEach(doc => {
		user = {
			id: doc.id,
			...doc.data()
		}
	});	

	console.log(user);
	//check if password is the same
	if (user.password !== password) {
		return res.status(404).send('Password is wrong')
	}

	const token = jwt.sign({
		id: user.id,
		username: user.username
	}, 'PM39KOLJ56448UWOA1EO'
	);

	return res.status(200).send({
		'success': true,
		'token': token
	})
}

module.exports = {
	addUser,
	getAllUsers,
	getUserById,
	updateUser,
	removeUser,
	loginUser
}