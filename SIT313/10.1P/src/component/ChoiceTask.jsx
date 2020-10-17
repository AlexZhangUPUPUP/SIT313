import React from 'react';

import '../css/ChoiceTask.css';

const ChoiceTask = (props) => {
	return(
	
	<div class="background">
	
	<div class="firstline">  
	<p> Please select your choice</p>
	</div>
	
	<div class="line">
	<label >Choice 1<input type="checkbox" name='ChoiceOne' id='ChoiceOne' onChange={props.ChoiceOne} value='ChoiceOne'/></label> <br/>
	</div>
	
	
	<div class="line">
	<label >Choice 2 <input type="checkbox" name='ChoiceTwo' id='ChoiceTwo' onChange={props.ChoiceTwo} value='ChoiceTwo'/></label> <br/>
	</div>
	
	
	<div class="line">
	<label >Choice 3<input type="checkbox" name='ChoiceThree' id='ChoiceThree' onChange={props.ChoiceThree}  value='ChoiceThree'/></label> <br/>
	</div>
	
	
	</div>
	
	
	)
}

export default ChoiceTask