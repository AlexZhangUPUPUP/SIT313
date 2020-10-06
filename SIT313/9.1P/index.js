import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Image from './Image';
import Header from './Header';
import Bottom from './Bottom';
import Left from'./Left';
import Right from'./Right';
import Cardlist from './Cardlist';



ReactDOM.render(
 <div>

  <Header/>
  <Image />

  <Cardlist/>
  

  
  <Left/>
  <Right/>
  
  
   

  
</div>

,document.getElementById('root') )




