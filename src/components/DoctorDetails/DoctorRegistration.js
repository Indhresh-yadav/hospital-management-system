import React, { useState } from 'react';
import '../Registration/RegistrationForm.css'
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

const DoctorRegistration = () => {
    const navigate=useNavigate();
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    specialization: '',
    mobile: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit =  async (e) => {
    e.preventDefault();
   try{
    const response=await axios.post('http://localhost:8080/indhreshyadav/savedoctor',formData);
    const result=response.data;

    setFormData({
        firstName: '',
        lastName: '',
        email: '',
        password: '',
        specialization: '',
        mobile: ''
      });
      if(result && result.statusCode === 201){
        alert(result.msg);
        alert("your data inserted sucessfully in health bridge hospital as a doctor")
        navigate("/")
      }else{
        alert(result.msg || 'invalid credentils')
      }
    console.log('Submitted data:', formData);
   } catch (error){
        console.error('Lohgin error :', error);
        alert(" something wet wrong in back end side")
   }
  };




  return (
    <div className='doctor-registration-background-image'>
      <form onSubmit={handleSubmit} className="doctor-registration-form" autoComplete="off">
        <h2>Doctor Registration</h2>

        <input
          type="text"
          name="firstName"
          placeholder="First Name"
          className='doctor-registration-input'
          value={formData.firstName}
          onChange={handleChange}
        /><br/><br/>

        <input
          type="text"
          name="lastName"
          placeholder="Last Name"
          className='doctor-registration-input'
          value={formData.lastName}
          onChange={handleChange}
        /><br/><br/>

        <input
          type="email"
          name="email"
          placeholder="Email"
          value={formData.email}
          className='doctor-registration-input'
          onChange={handleChange}
        /><br/><br/>

        <input
          type="password"
          name="password"
          placeholder="Password"
          value={formData.password}
          className='doctor-registration-input'
          onChange={handleChange}
          autoComplete="new-password"
        /><br/><br/>

        <input
          type="text"
          name="specialization"
          placeholder="Specialization"
          className='doctor-registration-input'
          value={formData.specialization}
          onChange={handleChange}

        /><br/><br/>

        <input
          type="tel"
          name="mobile"
          placeholder="Mobile Number"
          className='doctor-registration-input'
          value={formData.mobile}
          onChange={handleChange}
        /><br/><br/>

        {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'} {'\u00A0'}{'\u00A0'} <button type="submit"   className='doctor-registration-button'>Register</button>   
        <p>do you have account ?  <Link to="/DoctorLogin">Login</Link></p>
      </form>
    </div>
  );
};

export default DoctorRegistration;
