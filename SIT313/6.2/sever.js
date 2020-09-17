

var mongoose = require("mongoose");
var express = require('express');

var bodyParser = require('body-parser');
//获取模块

var app = express();

var validator =require("validator");

var bcrypt = require('bcrypt');// 加密

var hashPassword;

const Worker = require("./model/Worker.js")


//var urlencodedParser = bodyParser.urlencoded({ extended: false }) //实例化


app.use(bodyParser.urlencoded({extended:true}));

mongoose.connect('mongodb://localhost:27017/iCrowdWorker', {useNewUrlParser: true,useUnifiedTopology: true});



//add , delete, get workers form Workers(table)

app.route('/Workers')

.post( function (req, res) {
	
	const worker =new  Worker( {
		id: req.body.id,
		name: req.body.name,
		password:req.body,password,
		email: req.body.email,
		phone:req.body.phone,
		
	})
	worker.save( function(err){
		if(err){
			res.send(err);
		}
		else{
			res.send("successfully add the worker");
		}
	} )

})

.get(function(req, res){
	
	Worker.find((err, workerList)=>{
	    if (err) {res.send(err)}
	    else {
			res.send(workerList);
		
		   res.send("successfully get workers!");
		}
	})
	
})


.delete( function(req, res){
	

    Worker.deleteMany((err) =>{
        if (err) {res.send(err)}
        else {res.send('Successfully deleted all workers!')}
    })
	
})

//update , delete, get workers form Workers(table) by ID;
app.route('/workers/:id')

.get(function(req, res){
    
    Worker.findOne({worker_id: req.params.id}, (err, foundWorker)=>{
        if (foundWorker) (res.send(foundWorker))
        else res.send("No Worker Found!")
    })
})

.put(function(req,res){
    
    Worker.update(
        
        {id: req.params.id},
		{name: req.body.name},
		{email: req.body.email},
		{password: req.body.password},
		{phone:req.body.phone},  
        {overwrite:true}, 
		
        (err)=>{
            if (err) {console.log(err);res.send(err)}
            else {res.send('Successfully updated(put) a worker')}
        }
    )
})


.delete( function(req, res){
	

    Worker.deleteOne((err) =>{
        if (err) {res.send(err)}
        else {res.send('Successfully deleted all workers!')}
    })
	
})


.patch(function(req, res){
   
    Worker.update(
        {worker_id: req.params.id},
        {$set: req.body},
        (err)=>{
            if (!err) {res.send('Successfully updated(patch)! the worker')}
            else {console.log(err);res.send(err)}
        }
    )
})


app.listen(3000, function(){
	
	console.log("Server is running at 3000 port ")
	
});





