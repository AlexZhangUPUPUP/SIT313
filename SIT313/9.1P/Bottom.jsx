import React from 'react';

function Header(){
	return(
	
	<div class="Header">
	
	
	<div class="LeftHeader"> 
	
	<div class="left"> NEWSLETTER SIGN  </div>
	
	<input type="text" name="fname" placeholder="Enter your email" class="input"/>
	
	<button class="subscribe">subscribe </button>
	
	</div>
	
	
	<div class="RightHeader">  
	
	<div class="subscribe">CONNECT US</div>
	<img src= { require('./images/f.PNG')} alt='facebook' class="icon"/>
	<img src= { require('./images/t.PNG')} alt='twitter' class="icon"/>
	<img src= { require('./images/i.PNG')} alt='ins' class="icon"/>
	
	
	</div>
	

	</div> 
	)
}

export default Header