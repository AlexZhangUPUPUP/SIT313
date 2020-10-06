import React from 'react';

function Card(props){
	
    return(
	<div class="column">
	
	<img src= {props.avatar} alt="stuff"/>
	<h3> {props.name}</h3>
	<p> {props.position} </p>
	
	</div>  )}

export default Card


