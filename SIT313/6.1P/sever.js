

var mongoose = require("mongoose");
var express = require('express');

var bodyParser = require('body-parser');
//获取模块

var app = express();

var validator =require("validator");


var https= require("https");


// 创建 application/x-www-form-urlencoded 解析
var urlencodedParser = bodyParser.urlencoded({ extended: false }) //实例化

app.get('/',function(req,res){
	
	
	res.sendFile(__dirname+"/index.html") //跳转到页面
	

})//从哪个页面得到信息


// POST /login 获取 URL编码的请求体
app.post('/', urlencodedParser, function (req, res) {
	
	var first_name =req.body.first_name;
	var last_name =req.body.last_name;
	var email =req.body.email;
	
	var data={
		members:[{
			email_address:email,
			status :"subscribed",
			merge_fields:{
				FNAME:first_name,
				LNAME:last_name
				
			}
			
		}]
		
		
	}
	
	var apiKey ="d155f0213017ada6e38da5897532800f-us17";
	var list_id="636b9d9e58";
	
	jsonData = JSON.stringify(data);
	//send the data to JSON
	
	var url="https://us17.api.mailchimp.com/3.0/lists/636b9d9e58";
	
	var options={
		method:"POST",
		auth:"azi:d155f0213017ada6e38da5897532800f-us17",
	
	}
	
	const request= https.request(url,options,(response)=>{
		
		
		response.on("data", (data)=>{
			
			console.log(JSON.parse(data))
			
		})
		
	})
	
	request.write(jsonData);
	request.end();
	
	console.log(first_name,last_name,email);
	
	


  
  res.send('welcome, ' + req.body.first_name +"  you have registered successfully.") // 生成新的页面 。。。
  
})


app.listen(3000);


