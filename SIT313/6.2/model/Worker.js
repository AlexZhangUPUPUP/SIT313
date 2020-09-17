const mongoose = require("mongoose");
const validator = require("validator");

const WorkerSchema  =new mongoose.Schema(
	
	{
	    
		id :{ type: Number, required :true },
		
	    name: { type:String, required :true },
	   
		email:     { type:String, required :true,
		 
		 validate(value){
			 
			 if( validator.isEmail(value) != true ){
				 
				 throw new Error("Email is invail");
			 }
		 }},
		 
		
	
		password:{ type:String, required :true},
		
		
		phone:{ type :String, required :true,
		
		
		validate(value){
			
		    if(validator .isMobilePhone(value) != true){
				
				throw new Error("mobile phone numer is invalid");
			}
			
		}},
		
	})
	
	module.exports = mongoose.model("Worker",WorkerSchema);