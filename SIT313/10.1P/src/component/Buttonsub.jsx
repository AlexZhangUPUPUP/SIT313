import React from 'react'
import '../css/ChoiceTask.css';

const Buttonsub = (props) =>{
	
	return (
	
	<div>
		<button class='button' type = {props.type} onClick={props.onClick}> {props.text} </button>
	</div>

	
	)

	
    
	
	
}
export default Buttonsub