

var mongoose = require("mongoose");
var express = require('express');

var bodyParser = require('body-parser');
//获取模块

var app = express();

var validator =require("validator");

var bcrypt = require('bcrypt');// 加密

var hashPassword;

const Requester = require("./model/Unit.js")

// 创建 application/x-www-form-urlencoded 解析
var urlencodedParser = bodyParser.urlencoded({ extended: false }) //实例化


app.get('/index',function(req,res){
	
	res.sendFile(__dirname+"/index.html") //跳转到页面
	

})//从哪个地方得到数据


// POST /login 获取 URL编码的请求体
app.post('/index', urlencodedParser, function (req, res) {
	
	
mongoose.connect('mongodb://localhost:27017/iCrowdTask', {useNewUrlParser: true,useUnifiedTopology: true});


hashPassword =secret(req.body.password);


const Unit = Requester;

const unit =new Unit(
{
    	
		country :req.body.country,
		first_name :req.body.first_name,
		last_name :req.body.last_name,
		email :req.body.email,
		address1 :req.body.address1,
		address2 :req.body.address2,
		city : req.body.city,
		state: req.body.state,
		zip: req.body.zip,
		phone: req.body.phone,
		password : hashPassword,
		compassword:  hashPassword,
		
  }
)

  unit.save( (err)=>{
  	
  	if(err){
  		
  		console.log(err);
  	}else{
  		
  		console.log("successfully!");
  	}
  	
  })
  
  //res.send('welcome, ' + req.body.first_name) // 生成新的页面 。。。
  
  
  res.redirect('/reqlogin');  //跳转到页面
  //mongoose.connection.close();
  
})









//从登录页面获取信息
app.get('/reqlogin',function(req,res){
	
	
	
	res.sendFile(__dirname+"/reqlogin.html") //跳转到页面
	

})

// POST /login 获取 URL编码的请求体
app.post('/reqlogin', urlencodedParser, function (req, res) {
	
	
	//mongoose.connect('mongodb://localhost:27017/iCrowdTask', {useNewUrlParser: true,useUnifiedTopology: true});
	
	var db  = mongoose.createConnection('mongodb://localhost:27017/iCrowdTask', {useNewUrlParser: true,useUnifiedTopology: true});
	
	

	GetEmail = req.body.email;
	Password =req.body.password;
	
	
	const Unit = Requester;
	
	Unit.findOne({email:GetEmail},(err,docs)=>{
		
	    if(docs==null){
			
	        res.send('The email is not in database')
			
	    }else{
			
	        bcrypt.compare(Password,docs.password,function(err,result){
				
	            if(result == true){
	                res.redirect('/reqtask'); //跳转到新的页面
	            }else{
					res.send('Password is invaild') ;
	                alert("The password is invaild");
	            }
	        })
	    }
	   
	})  
	
	
	/*
	db.iCrowdTask.find({email:Email},(err,docs)=>{
		
	    if(docs==null){
	        res.send('The Emila is invalid')
			
	    }else{
			
	        bcrypt.compare(Password,docs.password,function(err,result){
				
	            if(result == true){
	                res.redirect('/reqtask'); //跳转到新的页面
	            }else{
					res.send('密码错误') ;
	                alert("The password is invaild");
	            }
	        })
	    }
	   
	})  
	*/
	
	
	mongoose.connection.close();


})


function  secret( password){
	
	const saltRounds = 10;
	//随机生成salt
	const salt = bcrypt.genSaltSync(saltRounds);
	//获取hash值
	var hash = bcrypt.hashSync(password, salt);
	
	return hash;
} 




app.listen(3000);





