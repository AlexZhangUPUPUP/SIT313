const mongoose = require("mongoose");
const validator = require("validator");

const studentSchema  =new mongoose.Schema(
	
	{
	    
		
	    country: { type:String, required :true },
	   
		first_name:{ type:String, required :true },
		
		last_name: { type:String, required :true },
		email:     { type:String, required :true,
		 
		 validate(value){
			 
			 if( validator.isEmail(value) != true ){
				 
				 throw new Error("Email 不合法");
			 }
		 }},
		 
		
		
		
		password:{ type:String, required :true ,minlength: 8,
		
		
		validate(value){
				 
		  if(this.compassword  != value){
			
			throw new Error("password is not same as Confirm password!");
		  }
		  
		}},
		
		compassword:{ type:String, required :true, minlength: 8,
		
		
		},
		
		
		
		address1:{ type:String, required :true, minlength: 8 },
		
		address2:{ type:String, required :true },
		
		city:{ type:String, required :true },
		
		state:{ type:String, required :true },
		
		
		zip:  { type :Number, required :false},
		
		
		phone:{ type :String, required :false,
		
		validate(value){
			
		    if(validator .isMobilePhone(value) != true){
				
				throw new Error("mobile phone numer is invalid");
			}
			
		}},
		
	})
	
	module.exports = mongoose.model("Unit",studentSchema);