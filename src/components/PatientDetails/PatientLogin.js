import React, { useContext, useState } from 'react'
import '../DoctorDetails/Login.css'
import patient from '../../assets/patient.jpg'

import { useNavigate } from 'react-router-dom'
import axios from 'axios'
import { mycontext } from '../../contextapi/GlobalContext'

const PatientLogin = () => {
  const navigate=useNavigate();
  const[email,setEmail]=useState('');
  const[password,setPassword]=useState('');

 

  const handlePatientLogin =async (e)=>{
    e.preventDefault();
   try{
    const response=await axios.get('http://localhost:8080/indhreshyadav/loginpatient',{
      params: { email, password }
    });
    const result=response.data;
  
   
    setEmail('');
    setPassword('');
    if (result && result.statusCode === 202) {
      alert("your login is sucessfull welcome to health bridge hospital")
      navigate('/PatientDoctorDetails', { state: result.data });

    } else {
      alert(result.msg || 'Invalid credentials');
    }
  } catch (error) {
    console.error('Login error:', error);
    alert('Something went wrong while connecting to the server.');
  }};

  
  return (
   <>
   <div className='login-background'>
    <h1 className='login-heading'>Welcome Back  to Health Bridge Hospital</h1>
    <div className='login-form-background'>
    <img src={patient} alt="doctor" className="login-doctor" />
    <div className='login-form-page'>
      
      <form className='login-form' onSubmit={handlePatientLogin}>
      <h2 className='login-form-heading'> Patient Login</h2>
        <input type='email' name='email' className='login-form-input' placeholder='Enter your email' value={email} onChange={(e) => setEmail(e.target.value)}  /> <br/> <br/>
        <input type='password' name='password' className='login-form-input' placeholder='Enter your password' value={password} onChange={(e) => setPassword(e.target.value)}  /> <br/> <br/>
        <button className='login-form-button'  type='submit'>Login</button>
        <p className='login-form-forgot'><a href='/#'>Forgot Password?</a></p>
        <p className='login-form-register'><a href='/RegistrationForm'>Register</a></p>
      </form>
    </div>
    
    </div>
   </div>
   <p className='contanct-footer'>Thank your for visiting us  Health Bridge Hospital,23, Sri Krishna Nagar, Anantapur,Andhra Pradesh, India,Phone: 09959410482,Email: gollaindresh201@gmail.com</p>
   </>
  )
}

export default PatientLogin
