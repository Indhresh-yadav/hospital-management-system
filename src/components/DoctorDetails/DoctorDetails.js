import axios from 'axios';
import React from 'react'
import { Link, useLocation, useNavigate } from 'react-router-dom';

const DoctorDetails = () => {
  const navigate=useNavigate();
    const location = useLocation();
    console.log(location);
    
  const doctorData = location.state;
  console.log(doctorData);
  const handledelete = async(e)=>{
    e.preventDefault();
   try{
    const response= await axios.delete(`http://localhost:8080/indhreshyadav/deletedoctor/${doctorData.did}`);
    alert("Are you sure want to delete the data")
    if(response.status === 204){
     alert("your data deleted sucessfully")
      console.log("your data deleted sucessfully",response.data)
      navigate("/")
    }else{
      alert("your facing issue we can't delete your data")
    }
   }catch (error){
    
    console.log("in your backeng issue is there".error)
   }
  }
  
 

  return (
   
    <div style={{position:'absolute', top:'35%', left:'40%'}}>
    <h2>Welcome, Dr. {doctorData?.firstName} {doctorData?.lastName}!</h2>
    <p>Doctor Id:{doctorData?.did}</p>
    <p>Email: {doctorData?.email}</p>
    <p>Specialization: {doctorData?.specialization}</p>
    <p>Mobile: {doctorData?.mobile}</p>
    <button type='button' style={{height:'30px', width:'80px', backgroundColor:'orangered',borderRadius:'15px',border:'none'}} ><Link to="/editdoctordetails" state={doctorData}>Edit</Link> </button>  {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}
   {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}
    <button type='button' style={{height:'30px', width:'80px', backgroundColor:'orangered',borderRadius:'15px',border:'none'}} onClick={handledelete}> Delete</button> {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}



  </div>
  )
}

export default DoctorDetails
