import React, { useState } from 'react'
import { useLocation } from 'react-router-dom'
import axios from 'axios';
import { Link } from 'react-router-dom';

const EditDoctorDetails = () => {
    
    const location=useLocation();
    console.log(location);
    const doctorData=location.state
    console.log(doctorData)

    let { did,firstName,lastName,email,password,mobile,specialization}=doctorData
  const[formdata,setFromdata]=useState(
    {  
        did,
        firstName,
        lastName,
        email,
        password,
        specialization,
        mobile
    }
  )

  let handleChange=(e)=>{
    const {name,value}=e.target;

    setFromdata({...formdata,[name]:value})

  }
  const handleupdate = async(e)=>{
    e.preventDefault();
  
    try{
        const response= await axios.put('http://localhost:8080/indhreshyadav/updatedoctor',formdata);
        const result= response.data;
    
    alert("are you sure to update the details")
    if(result.statusCode ===200){
      alert("your data updated sucessfully")
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
            <label>Doctor Id :   </label>
            <input type='text' name='did' value={formdata.did} onChange={handleChange} style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <label>FirstName :   </label>
            <input type='text' name='firstName' value={formdata.firstName} onChange={handleChange} style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <label>LastName :    </label>
            <input type='text' name='lastName'value={formdata.lastName}  onChange={handleChange}  style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <label>Email : </label>{'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}
            <input type='text' name='email'  value={formdata.email}  onChange={handleChange} style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <label>Password :  </label>
            <input type='text' name='password' value={formdata.password}  onChange={handleChange} style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <label>Specialization :  </label>
            <input type='text' name='password' value={formdata.specialization}  onChange={handleChange} style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <label>Mobile :</label>{'\u00A0'} {'\u00A0'} {'\u00A0'}
            <input type='text' name='mobile ' value={formdata.mobile}  onChange={handleChange}  style={{height:"30px", width:"200px",borderRadius:"15px", paddingLeft:"5px"}}/> <br/> <br/>
            <button type='button' style={{height:'30px', width:'80px', backgroundColor:'orangered',borderRadius:'15px',border:'none', textDecoration:"none"}}  ><Link to="/doctordetails">Back</Link></button>  {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}
            {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}
            <button type='button' style={{height:'30px', width:'80px', backgroundColor:'orangered',borderRadius:'15px',border:'none'}} onClick={handleupdate} > update</button> {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}


        </form>
    </div>
  )
}

export default EditDoctorDetails
