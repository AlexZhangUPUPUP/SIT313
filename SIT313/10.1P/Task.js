const mongoose = require("mongoose")
const server = require("./server.js")


const taskSchema = new mongoose.Schema(
    {
        Type: String,
        Title: String,
        Description:String,
        Date: Date,
		
        
        ChoiceOne:String,
        ChoiceTwo:String,
        ChoiceThree:String,
		
        Judge:String,
		
        Sentence:String,
		
		Require:String,
        Reward:String,
        Number:String
    }
)


module.exports = mongoose.model("task", taskSchema);