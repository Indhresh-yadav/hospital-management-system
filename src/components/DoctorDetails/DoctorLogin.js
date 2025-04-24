import React from 'react'
import './Login.css'
import doctorlogin from '../../assets/doctorlogin.jpg'
import axios from 'axios'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const DoctorLogin = () => {
  const navigate=useNavigate();
  const[email,setEmail]=useState('');
  const[password,setPassword]=useState('');

  const handleDoctorLogin =async (e)=>{
    e.preventDefault();
   try{
    const response= await axios.get('http://localhost:8080/indhreshyadav/doctorlogin',{
      params: { email, password }
    });
    const result=response.data;
    setEmail('');
    setPassword('');
    if (result && result.statusCode === 202) {
      alert("your's login is sucessfully");
      
      navigate('/DoctorDetails',{state: result.data});
    } else {
      alert(result.msg || 'Invalid credentials');
    }
  } catch (error) {
    console.error('Login error:', error);
    alert('Something went wrong while connecting to the server.');
  }};

  
  return (
    <div className='doctor-login'>
       <img src={doctorlogin} alt="doctor" className="doctor-login-doctor" />
        <div className='doctor-login-form-main'>
        <h3 className='doctor-login-heading'>DoctorLogin</h3>
         <form className='doctor-login-form' onSubmit={handleDoctorLogin}>
            <input type='text' placeholder='Email' className='doctor-login-input' value={email} onChange={(e) => setEmail(e.target.value) }/> <br/> <br/>
            <input type='password' placeholder='Password' className='doctor-login-input'  value={password} onChange={(e) => setPassword(e.target.value)}/><br/> <br/>
            <button type='submit' className='doctor-login-button'>Login</button>
            <p><a href='/'>Forgot Password</a></p>
 
         </form>
        </div>
        <p className='contanct-footer'>Thank your for visiting us  Health Bridge Hospital,23, Sri Krishna Nagar, Anantapur,Andhra Pradesh, India,Phone: 09959410482,Email: gollaindresh201@gmail.com</p>
    </div>
  )
}

export default DoctorLogin;
