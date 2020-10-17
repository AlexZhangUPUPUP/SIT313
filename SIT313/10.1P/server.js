const express = require("express")
const bodyParser = require("body-parser")
const mongoose = require("mongoose")
const Task = require("./Task.js")
const cors = require("cors")

const app = express();
app.use(bodyParser.urlencoded({extended:true}))
app.use(cors())
app.use(bodyParser.json())

mongoose.connect("mongodb://localhost:27017/iCrowdTask",{useNewUrlParser:true, useUnifiedTopology:true})

//home route
app.get('/',(req,res)=>{
    const user = {
        username:'deakin',
        password:'sit313'
    }
    res.send(user)
})

app.post('/register',(req,res) => {
	
    const task = new Task({
        Type: req.body.Type,
        Title : req.body.Title,
        Description : req.body.Description,
        Date: req.body.Date,
        ChoiceOne: req.body.ChoiceOne,
        ChoiceTwo: req.body.ChoiceTwo,
        ChoiceThree: req.body.ChoiceThree,
        Judge: req.body.Judge,
		Sentence: req.body.Sentence,
        Require: req.body.Require,
        Reward: req.body.Reward,
        Number:req.body.Number
    });
    task.save()
    .catch((err)=>console.log(err));
    res.json(('successful save' + task));
})



app.listen(8000,(req,res)=>{
    console.log("Server is running on port 8000")
})

