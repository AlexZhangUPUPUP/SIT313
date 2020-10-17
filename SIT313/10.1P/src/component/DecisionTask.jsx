import React from 'react';

import '../css/ChoiceTask.css';

const DecisionTask = (props) => {
	return(
	
	<div class="background">
	
	<div class="firstline">  
	<p> Do you need the help of manager?</p>
	</div>
	
	
	<div class="line">
	
	
	
	<div class='choice'>
	<label ><input  type="radio" name='Judge' id='Judge' value='Yes' onChange={props.Decision} />Yes</label>
	</div>
	
	<div class='choice'>
	<label ><input  type="radio" name='Judge' id='Judge' value='No'  onChange={props.Decision} />No</label>
	</div>

    
	
	 
	
	</div>
	

	
	</div>
	
	
	
	)
}

export default DecisionTask