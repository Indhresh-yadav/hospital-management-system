import React from 'react'
import { useLocation } from 'react-router-dom';
import { Link } from 'react-router-dom';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const PatientDoctorDetails = () => {
  const navigate =useNavigate();
  const location = useLocation();
const patientData = location.state;
const handlepatientdelete = async(e)=>{
  e.preventDefault();
 try{
  const response= await axios.delete(`http://localhost:8080/indhreshyadav/deletepatient/${patientData.pid}`);
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

console.log("Received patient data:", patientData);
  return (
    <div style={{position:'absolute', top:'35%', left:'40%'}}>
      <h2>Welcome, {patientData?.firstName} {patientData?.lastName}</h2>
      <p>Patient Id :{patientData?.pid}</p>
      <p>Mobile :{patientData?.mobile}</p>
      <p>Email: {patientData?.email}</p>
      <p>Password:{patientData?.password}</p>
      <p>Gender:{patientData?.gender}</p>
      <p>Age: {patientData?.age}</p>
      <button type='button' style={{height:'30px', width:'80px', backgroundColor:'orangered',borderRadius:'15px',border:'none'}}  ><Link to="/editpatientdetails" state={patientData}>Edit</Link> </button>  {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}
   {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}
    <button type='button' style={{height:'30px', width:'80px', backgroundColor:'orangered',borderRadius:'15px',border:'none'}} onClick={handlepatientdelete} > Delete</button> {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}
    </div>
  )
}

export default PatientDoctorDetails

  