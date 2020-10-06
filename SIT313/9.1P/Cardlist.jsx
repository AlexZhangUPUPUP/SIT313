import React from 'react';
import Card from'./Card';
import faker from 'faker';
import './index.css';
import Stufflist from './Stufflist';


function cardCompnent (Staff){
	
	return <Card
	key ={Staff.key}
	avatar = {Staff.avatar}
	name   = {Staff.name}
	position ={Staff.position}
	/>
	
}


function Cardlist(){
	
	return<div class="row">  
    {Stufflist.map(cardCompnent)}
		
	</div>
	
 
}
export default Cardlist