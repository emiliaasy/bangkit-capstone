const requireAuth = require('./middleware')
const express = require("express")
const router = express.Router()
const {
	addUser,
	getAllUsers,
	getUserById,
	updateUser,
	removeUser,
	loginUser
} = require('./controller')

router.get("/user", function(req, res){
    res.send("halo")
})

router.post("/user", addUser)
router.get("/alluser", requireAuth, getAllUsers)
router.get("/user/:id", requireAuth, getUserById)
router.put("/user/:id", requireAuth, updateUser)
router.delete("/user/:id", requireAuth, removeUser)
router.post("/login", loginUser)
module.exports = router