

var mongoose = require("mongoose");
var express = require('express');

var bodyParser = require('body-parser');
//获取模块

var app = express();

var validator =require("validator");


// 创建 application/x-www-form-urlencoded 解析
var urlencodedParser = bodyParser.urlencoded({ extended: false }) //实例化

app.get('/',function(req,res){
	
	
	res.sendFile(__dirname+"/index.html") //跳转到页面
	

})


// POST /login 获取 URL编码的请求体
app.post('/', urlencodedParser, function (req, res) {
	mongoose.connect('mongodb://localhost:27017/iCrowdTask', {useNewUrlParser: true});

const studentSchema  =new mongoose.Schema(

{
    
	
    country: { type:String, required :true },
   
	first_name:{ type:String, required :true },
	
	last_name: { type:String, required :true },
	email:     { type:String, required :true,
	 
	 validate(value){
		 
		 if( validator.isEmail(value) != true ){
			 
			 throw new Error("Email is invalid");
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
	
	
	phone:{ type :Number, required :false,
	
	validate(value){
		
	    if(validator .isMobilePhone(value) != true){
			
			throw new Error("mobile phone numer is invalid");
		}
		
	}},
	
})

const Unit =mongoose.model('Unit', studentSchema)

const unit =new Unit(
{
    	
		country :req.body.country,
		first_name :req.body.first_name,
		last_name :req.body.last_name,
		email :req.body.email,
		password : req.body.password,
		compassword: req.body.compassword,
		address1 :req.body.address1,
		address2 :req.body.address2,
		city : req.body.city,
		state: req.body.state,
		zip: req.body.zip,
		phone: req.body.phone,
		
	
  }
)

unit.save( (err)=>{
	
	if(err){
		
		console.log(er);
	}else{
		
		console.log("successfully!");
	}
})
	
  
  res.send('welcome, ' + req.body.first_name) // 生成新的页面 。。。
  
})


app.listen(3000)


