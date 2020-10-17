import React from 'react';

import '../css/ChoiceTask.css';

const RequirementTask = (props) => {
	return(
	
	<div class="background">
	
	<div class="firstline">  
	<p> Worker Requirement</p>
	</div>
	
	
	<div class="line">
	
	
	
	<div class='pp'>
	Require Master Workers
	</div>
	
	<div class='choice'>
	<label ><input  type="radio" name='isRequire' id='isRequire' value='Yes' onChange={props.SelectRequire} />Yes</label>
	</div>
	
	<div class='choice'>
	<label ><input  type="radio" name='isRequire' id='isRequire' value='No'  onChange={props.SelectRequire} />No</label>
	</div>

    
	
	 
	
	</div>
	
	<div class="line">
	<label >Reword per response<input type="text" name='Reword' id='Reword' onChange={props.SelectReward} /></label> <br/>
	</div>
	
	
	<div class="line">
	<label >Number of Workers<input type="text" name='Number' id='Number' onChange={props.SelectNumber} /></label> <br/>
	</div>
	
	</div>
	
	
	
	)
}

export default RequirementTask