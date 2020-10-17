import React from 'react';

import '../css/ChoiceTask.css';

const DescribeTask = (props) => {
	return(
	
	<div class="background">
	
	<div class="firstline">  
	<p> Describe your Task to workers</p>
	</div>
	
	<div class="line">
	<label >Title      <input type="text" name='Title' id='Title' onChange={props.SelectTitle} /></label> <br/>
	</div>
	
	
	<div class="line">
	<label >Description<input type="text" name='Description' id='Description' onChange={props.SelectDescription} /></label> <br/>
	</div>
	
	
	<div class="line">
	<label >Expiry Date<input type="date" name='Date' id='Date' onChange={props.SelectDate} /></label> <br/>
	</div>
	
	
	</div>
	
	
	
	)
}

export default DescribeTask