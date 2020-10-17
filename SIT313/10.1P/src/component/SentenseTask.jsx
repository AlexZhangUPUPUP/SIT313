import React from 'react';

import '../css/ChoiceTask.css';

const SentenseTask = (props) => {
	return(
	
	<div class="background">
	
	<div class="firstline">  
	<p> Please input your task</p>
	</div>
	
	<div class="line">
	<label >Input      <input type="text" name='Sentense' id='Sentense' onChange={props.SelectSentense} /></label> <br/>
	</div>
	
	
	
	
	</div>
	
	
	
	)
}

export default SentenseTask