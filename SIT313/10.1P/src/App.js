import React , {useState} from 'react';

import './css/App.css';
import Header from'./component/Header'; 
import Buttonsub from './component/Buttonsub';
import ChoiceTask from'./component/ChoiceTask';
import NoTask from'./component/NoTask';
import DescribeTask from'./component/DescribeTask';  
import RequirementTask from  './component/RequirementTask';
import DecisionTask from'./component/DecisionTask';
import SentenseTask from './component/SentenseTask';


function App() {
	
	
 
 
 const [Type,setType] = useState('')
 
 
 
 
 const[Contact,setContact] = useState({
   Type: '',
   Title:'',
   Description:'',
   Date:'',
   

   ChoiceOne:'',
   ChoiceTwo:'',
   ChoiceThree:'',
   
   
   Judge:'',
   
   Sentence:'',
   
   Require:'',
   Reward:'',
   Number:''
 })
 
 
 
 const handleclick = () =>{
 		 
 		 fetch('http://localhost:8000/register',{
 		   method :'post',
 		   headers :{'Content-Type':'application/json'},
 		   
 		   body :JSON.stringify({
 			   
 		     Type: '123',
 		     
 		     Title:Contact.Title,
 		     Description: Contact.Description,
 		     	 		 			 
 		     Date: Contact.Date,
 		     
 		     ChoiceOne: Contact.ChoiceOne,
 		     ChoiceTwo: Contact.ChoiceTwo,
 		     ChoiceThree:Contact.ChoiceThree,
 		     	 		 			 
 		     Judge:Contact.Judge,
 		     Sentence:Contact.Sentence,
 		     	 		 			 
 		     Require:Contact.Require,
 		     	 		 			 
 		     Reward: Contact.Reward,
 		     Number: Contact.Number,
 			 
 			 
 		   })
 		 })
 		 .then(response =>response.json())
 		 .then(data => console.log(data))
 		 .catch(err => {
 		   console.log(err)
 		 })
 
 }
 
 
 
 const SelectSentense =(event)=>{
 	 
 	 setType('Sentence')
 	 
 	 setContact((PreValue)=>{
 	   return{
 	     Type: 'Sentence',
 	     Title: PreValue.Title,
 	     Description: PreValue.Description,
 	 			 
 	     Date:PreValue.Date,
 	     
 	     ChoiceOne:PreValue.ChoiceOne,
 	     ChoiceTwo: PreValue.ChoiceTwo,
 	     ChoiceThree:PreValue.ChoiceThree,
 	 			 
 	     Judge:PreValue.Judge,
 	 			  Sentence:PreValue.Sentence,
 	 			 
 	     Require:PreValue.Require,
 	 			 
 	     Reward:PreValue.Reward,
 	     Number:PreValue.Number
 	   }
 	 })
 	 
 }
 
 
 const SelectCDecision =(event)=>{
	 
	 setType('Decision')
	 
	 setContact((PreValue)=>{
	   return{
	     Type: 'Decision',
	     Title: PreValue.Title,
	     Description: PreValue.Description,
	 			 
	     Date:PreValue.Date,
	     
	     ChoiceOne:PreValue.ChoiceOne,
	     ChoiceTwo: PreValue.ChoiceTwo,
	     ChoiceThree:PreValue.ChoiceThree,
	 			 
	     Judge:PreValue.Judge,
	 			  Sentence:PreValue.Sentence,
	 			 
	     Require:PreValue.Require,
	 			 
	     Reward:PreValue.Reward,
	     Number:PreValue.Number
	   }
	 })
	 
 }
 
 
 const SelectChoice =(event)=>{
	 

		 setType('Choice')
		 
		 
		 setContact((PreValue)=>{
		   return{
		     Type: 'Choice',
		     Title: PreValue.Title,
		     Description: PreValue.Description,
			 
		     Date:PreValue.Date,
		     
		     ChoiceOne:PreValue.ChoiceOne,
		     ChoiceTwo: PreValue.ChoiceTwo,
		     ChoiceThree:PreValue.ChoiceThree,
			 
		     Judge:PreValue.Judge,
			 
			 Sentence:PreValue.Sentence,
			 
		     Require:PreValue.Require,
			 
		     Reward:PreValue.Reward,
		     Number:PreValue.Number
		   }
		
		 
	 })
	 
	 
	 
	
 } 
 
 const TaskChange =(event)=>{
	 
	 const name = event.target.name;
	 const value = event.target.value;
	 
	 
	 
	 if (name === 'Description'){
		 
		 setContact((PreValue)=>{
		   return{
		     Type: PreValue.Type,
			 
		     Title: PreValue.Title,
	
		     Description: value,
		 			 
		     Date:PreValue.Date,
		     
		     ChoiceOne:PreValue.ChoiceOne,
		     ChoiceTwo: PreValue.ChoiceTwo,
		     ChoiceThree:PreValue.ChoiceThree,
		 			 
		     Judge:PreValue.Judge,
			 Sentence:PreValue.Sentence,
		 			 
		     Require:PreValue.Require,
		 			 
		     Reward:PreValue.Reward,
		     Number:PreValue.Number
		   }
		 })
		 
	 }
	 
	 else if (name === 'Title'){
	 		 
	 		 setContact((PreValue)=>{
	 		   return{
	 		     Type: PreValue.Type,
	 			 
	 		     Title: value,
	 		     Description: PreValue.Description,
	 		 			 
	 		     Date:PreValue.Date,
	 		     
	 		     ChoiceOne:PreValue.ChoiceOne,
	 		     ChoiceTwo: PreValue.ChoiceTwo,
	 		     ChoiceThree:PreValue.ChoiceThree,
	 		 			 
	 		     Judge:PreValue.Judge,
				 Sentence:PreValue.Sentence,
	 		 			 
	 		     Require:PreValue.Require,
	 		 			 
	 		     Reward:PreValue.Reward,
	 		     Number:PreValue.Number
	 		   }
	 		 })
	 		 
	 }
	 
	 
	 else if (name === 'Date'){
	 		 
	 		 setContact((PreValue)=>{
	 		   return{
	 		     Type: PreValue.Type,
	 			 
	 		     Title:PreValue.Title,
	 		     Description: PreValue.Description,
	 		 			 
	 		     Date: value,
	 		     
	 		     ChoiceOne:PreValue.ChoiceOne,
	 		     ChoiceTwo: PreValue.ChoiceTwo,
	 		     ChoiceThree:PreValue.ChoiceThree,
	 		 			 
	 		     Judge:PreValue.Judge,
				 Sentence:PreValue.Sentence,
	 		 			 
	 		     Require:PreValue.Require,
	 		 			 
	 		     Reward:PreValue.Reward,
	 		     Number:PreValue.Number
	 		   }
	 		 })
	 		 
	 }
	 
	 
	 else if (name === 'ChoiceOne'){
	 		 
	 		 setContact((PreValue)=>{
	 		   return{
	 		     Type: PreValue.Type,
	 			 
	 		     Title:PreValue.Title,
	 		     Description: PreValue.Description,
	 		 			 
	 		     Date: PreValue.Date,
	 		     
	 		     ChoiceOne: value,
	 		     ChoiceTwo: PreValue.ChoiceTwo,
	 		     ChoiceThree:PreValue.ChoiceThree,
	 		 			 
	 		     Judge:PreValue.Judge,
				 Sentence:PreValue.Sentence,
	 		 			 
	 		     Require:PreValue.Require,
	 		 			 
	 		     Reward:PreValue.Reward,
	 		     Number:PreValue.Number
	 		   }
	 		 })
	 		 
	 }
	 
	 else if (name === 'ChoiceTwo'){
	 		 
	 		 setContact((PreValue)=>{
	 		   return{
	 		     Type: PreValue.Type,
	 			 
	 		     Title:PreValue.Title,
	 		     Description: PreValue.Description,
	 		 			 
	 		     Date: PreValue.Date,
	 		     
	 		     ChoiceOne: PreValue.ChoiceOne,
	 		     ChoiceTwo: value,
	 		     ChoiceThree:PreValue.ChoiceThree,
	 		 			 
	 		     Judge:PreValue.Judge,
				 Sentence:PreValue.Sentence,
	 		 			 
	 		     Require:PreValue.Require,
	 		 			 
	 		     Reward:PreValue.Reward,
	 		     Number:PreValue.Number
	 		   }
	 		 })
	 		 
	 }
	 
	 else if (name === 'ChoiceThree'){
	 		 
	 		 setContact((PreValue)=>{
	 		   return{
	 		     Type: PreValue.Type,
	 			 
	 		     Title:PreValue.Title,
	 		     Description: PreValue.Description,
	 		 			 
	 		     Date: PreValue.Date,
	 		     
	 		     ChoiceOne: PreValue.ChoiceOne,
	 		     ChoiceTwo: PreValue.ChoiceTwo,
	 		     ChoiceThree:value,
	 		 			 
	 		     Judge:PreValue.Judge,
				 Sentence:PreValue.Sentence,
	 		 			 
	 		     Require:PreValue.Require,
	 		 			 
	 		     Reward:PreValue.Reward,
	 		     Number:PreValue.Number
	 		   }
	 		 })
	 		 
	 }
	 
	 
	 else if (name === 'Judge'){
	 		 
	 		 setContact((PreValue)=>{
	 		   return{
	 		     Type: PreValue.Type,
	 			 
	 		     Title:PreValue.Title,
	 		     Description: PreValue.Description,
	 		 			 
	 		     Date: PreValue.Date,
	 		     
	 		     ChoiceOne: PreValue.ChoiceOne,
	 		     ChoiceTwo: PreValue.ChoiceTwo,
	 		     ChoiceThree:value,
	 		 			 
	 		     Judge:value,
				 Sentence:PreValue.Sentence,
	 		 			 
	 		     Require:PreValue.Require,
	 		 			 
	 		     Reward:PreValue.Reward,
	 		     Number:PreValue.Number
	 		   }
	 		 })
	 		 
	 }
	 
	 
	 
	 
	 
	 else if (name === 'Sentense'){
	 		 
	 		 setContact((PreValue)=>{
	 		   return{
	 		     Type: PreValue.Type,
	 			 
	 		     Title:PreValue.Title,
	 		     Description: PreValue.Description,
	 		 			 
	 		     Date: PreValue.Date,
	 		     
	 		     ChoiceOne: PreValue.ChoiceOne,
	 		     ChoiceTwo: PreValue.ChoiceTwo,
	 		     ChoiceThree:value,
	 		 			 
	 		     Judge:PreValue.Judge,
				 Sentence:value,
	 		 			 
	 		     Require:PreValue.Require,
	 		 			 
	 		     Reward:PreValue.Reward,
	 		     Number:PreValue.Number
	 		   }
	 		 })
	 		 
	 }
	 
	 else if (name === 'isRequire'){
	 		 
	 		 setContact((PreValue)=>{
	 		   return{
	 		     Type: PreValue.Type,
	 			 
	 		     Title:PreValue.Title,
	 		     Description: PreValue.Description,
	 		 			 
	 		     Date: PreValue.Date,
	 		     
	 		     ChoiceOne: PreValue.ChoiceOne,
	 		     ChoiceTwo: PreValue.ChoiceTwo,
	 		     ChoiceThree:value,
	 		 			 
	 		     Judge:PreValue.Judge,
	 			 Sentence:PreValue.Sentence,
	 		 			 
	 		     Require:value,
	 		 			 
	 		     Reward:PreValue.Reward,
	 		     Number:PreValue.Number
	 		   }
	 		 })
	 		 
	 }
	 
	 else if (name === 'Reword'){
	 		 
	 		 setContact((PreValue)=>{
	 		   return{
	 		     Type: PreValue.Type,
	 			 
	 		     Title:PreValue.Title,
	 		     Description: PreValue.Description,
	 		 			 
	 		     Date: PreValue.Date,
	 		     
	 		     ChoiceOne: PreValue.ChoiceOne,
	 		     ChoiceTwo: PreValue.ChoiceTwo,
	 		     ChoiceThree:value,
	 		 			 
	 		     Judge:PreValue.Judge,
	 			 Sentence:PreValue.Sentence,
	 		 			 
	 		     Require:PreValue.Require,
	 		 			 
	 		     Reward:value,
	 		     Number:PreValue.Number
	 		   }
	 		 })
	 		 
	 }
	 
	 
	 else if (name === 'Number'){
	 		 
	 		 setContact((PreValue)=>{
	 		   return{
	 		     Type: PreValue.Type,
	 			 
	 		     Title:PreValue.Title,
	 		     Description: PreValue.Description,
	 		 			 
	 		     Date: PreValue.Date,
	 		     
	 		     ChoiceOne: PreValue.ChoiceOne,
	 		     ChoiceTwo: PreValue.ChoiceTwo,
	 		     ChoiceThree:value,
	 		 			 
	 		     Judge:PreValue.Judge,
	 			 Sentence:PreValue.Sentence,
	 		 			 
	 		     Require:PreValue.Require,
	 		 			 
	 		     Reward: PreValue.Reward,
	 		     Number: value
	 		   }
	 		 })
	 		 
	 }
	 
	 
	 
	 
 }
 
 
 
 
 
	
  return (
  
    <div class='sss'>

	  
	 <Header/>
	 
	
	 
	 
	 <div class="line">
	 
	 <div class="select">
	 
	 <label> Select Task Type  : </label>
	 
	 </div>
	 
	 
	 <div class="select">
	 
	 <label > <input  type="radio" name='Choice' value="Choice Task" id='Choice' onChange={SelectChoice} />Choice Task</label> <br/>
	 
	 </div>
	 
	 <div class="select">
	 
	 
	 <label > <input type="radio" name='Choice' value="Decision-Making" id='Decision' onChange={SelectCDecision} />Decision-Making Task</label><br/>
	 
	 </div>
	 
	 
	 <div class="select">
	 
	 <label > <input type="radio" name='Choice' value="Sentence-Level" id='Sentence' onChange={SelectSentense}  />Sentence-Level Task</label><br/>
	 
	 </div>

	 </div>
	 
	 
	 
	 
	 <DescribeTask  SelectTitle={TaskChange} SelectDescription={TaskChange} SelectDate={TaskChange} />
	 
	 
	 
	 <div style={ {display: Type=== '' ? 'block':'none'}}>,
	 
	 <NoTask/>
	 
	 </div>
	 
	 
	 <div style={ {display:Type=== 'Choice' ?'block':'none'}}>,
	 
	 <ChoiceTask  ChoiceOne={TaskChange} ChoiceTwo={TaskChange} ChoiceThree={TaskChange}/>
	 
	 </div>
	 
	 
	 
	 <div style={ {display:Type=== 'Decision' ?'block':'none'}}>,
	 
	 <DecisionTask Decision={TaskChange} Decision={TaskChange}  />
	 
	 </div>
	 
	 
	 <div style={ {display:Type=== 'Sentence' ?'block':'none'}}>,
	
	 <SentenseTask  SelectSentense={TaskChange} />
	 
	 </div>
	 
	 
	 
	 <RequirementTask SelectRequire={TaskChange} SelectReward={TaskChange}  SelectNumber={TaskChange} />
	 
	 
	 
	 
	 
	 
	 
	 <Buttonsub text ='save' type='submit' onClick={ handleclick}/>
	 
	 
	 
	   
	   
	   
	  
	</div>

  );
}

export default App;
