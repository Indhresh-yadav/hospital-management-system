import React from 'react'
import { Link, useNavigate } from 'react-router-dom';
import { useLocation } from 'react-router-dom';
import axios from 'axios';
import { useState } from 'react';


const EditPatientDetails = () => {
    const navigate=useNavigate();
    const location=useLocation();
    console.log(location);
    const patientData=location.state
    console.log(patientData)

    let { pid,firstName,lastName,email,password,mobile,age,gender}=patientData;
  const[formdata,setFromdata]=useState(
    {   pid,
        firstName,
        lastName,
        email,
        password,
        mobile,
        age,
        gender,
    }
  )

  let handleChange=(e)=>{
    const {name,value}=e.target;
     setFromdata({...formdata,[name]:value})

  }
  const handlepatientupdate = async(e)=>{
    e.preventDefault();
  
    try{
        const response= await axios.put('http://localhost:8080/indhreshyadav/updatepatient',formdata);
        const result= response.data;
    
    alert("Are your  sure want to update your data")
    if(result.statusCode === 200){
      alert("your data updated sucessfully")
      navigate("/")
      console.log("your  doctor data updated  sucessfully")
    }else{
     alert("somthing wet wrong")
    }
  
    }catch (error){
        alert("back end somthing wrong")
      console.log(" in your back end somthing wrong",error)
    }
  
   }
  
    
  return (
    <div>
        
        <form autoComplete='off' style={{position:"absolute", top:"25%", left:"35%"}}>
           <label>Patient Id :   </label>
            <input type='text' name='pid' value={formdata.pid} onChange={handleChange} style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <label>FirstName :   </label>
            <input type='text' name='firstName' value={formdata.firstName} onChange={handleChange} style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <label>LastName :    </label>
            <input type='text' name='lastName' value={formdata.lastName}  onChange={handleChange}  style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <label>Email : </label>{'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}
            <input type='text' name='email'  value={formdata.email}  onChange={handleChange} style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <label>password :  </label>
            <input type='text' name='password' value={formdata.password}  onChange={handleChange} style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <label>Mobile :</label>{'\u00A0'} {'\u00A0'} {'\u00A0'}
            <input type='text' name='mobile ' value={formdata.mobile}  onChange={handleChange}  style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <label>Age :</label>{'\u00A0'} {'\u00A0'} {'\u00A0'} {'\u00A0'} {'\u00A0'}
            <input type='text' name='age ' value={formdata.age}  onChange={handleChange}  style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <label>Gender :</label>{'\u00A0'} {'\u00A0'} {'\u00A0'}  
            <input type='text' name='gender ' value={formdata.gender}  onChange={handleChange}  style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <button type='button' style={{height:'30px', width:'80px', backgroundColor:'orangered',borderRadius:'15px',border:'none', textDecoration:"none"}}  onClick={()=>{navigate("/PatientDoctorDetails",{state:patientData})}} >Back</button>  {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}
            {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}
            <button type='button' style={{height:'30px', width:'80px', backgroundColor:'orangered',borderRadius:'15px',border:'none'}} onClick={handlepatientupdate} > update</button> {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}


        </form>
    </div>
  )
}

export default EditPatientDetails;
