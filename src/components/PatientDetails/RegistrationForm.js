import React, { Fragment, useContext, useEffect, useState } from 'react';
import '../Registration/RegistrationForm.css'
import { Link } from 'react-router-dom';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { mycontext } from '../../contextapi/GlobalContext';

const RegistrationForm = () => {

  let {doctors,setDoctors}=useContext(mycontext)

  const navigate = useNavigate();
  // const [doctors, setDoctors] = useState([]);
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    mobile: '',
    age: '',
    gender: '',
    doctor: ''
  });

  console.log(doctors);
  
  
    //  to fech all doctors
    const handledoctors = async (e)=>{
      try{
        const response= await axios.get('http://localhost:8080/indhreshyadav/fetchdoctors');
        
        const result=response.data;
        console.log(result)
        setDoctors(result)
         
        
        if(result.statusCode === 202){
          setDoctors(result.data)
          console.log("doctors fetched sucessfully")
          console.log("hii")
          console.log(result)
        }else{
          console.log("data feched failed")
        }
      } catch(error){
        console.log("facing to fetch the doctor details",error);
      }
     
    } 
    useEffect(()=>{
      handledoctors()
    },[]);
    const handleSubmit =async (e)=>{
      e.preventDefault();
     try{
      const { doctor, ...patientData } = formData;
      
      const response= await axios.post(
        `http://localhost:8080/indhreshyadav/savepatient/${doctor}`,
        patientData
        );
        alert("Re check again your data")
      setFormData({
        firstName: '',
        lastName: '',
        email: '',
        password: '',
        mobile: '',
        age: '',
        gender: '',
        doctor: ''
      })
      if(response.status === 201){
       
        alert("Welcome to health bridge hospital your Registration is sucessfully ")
        
        navigate('/PatientDetails', { state: formData });

      }else{
          console.log(" unable to send the data")
      }

     }catch(error){
      console.log("unable to store the data",error)
     }

    }
    const handleChange=(e)=>{
      const {name,value} =e.target;
      setFormData(prev=>({...prev,[name]:value}));

    }
  return (
    <>
      <div className='registration-backgroundimage'>
        <h1 className='registration-heading'>HealthBridge Hospital</h1>
        <h1 className='registration-reception'>Reception</h1>
        <div className='registration-form'>
          <form autoComplete='off' onSubmit={handleSubmit}>
           
                <input
                  name='firstName'
                  type='firstname'
                  className='registration-input'
                  placeholder='enter your first name'
                  value={formData.firstName}
                  onChange={handleChange}
                /><br /><br />
                 <input
                  name='lastName'
                  type='lastname'
                  className='registration-input'
                  placeholder='enter your  lastname'
                  value={formData.lastName}
                  onChange={handleChange}
                /><br /><br />
              
                <input
                  name='email'
                  type='email'
                  className='registration-input'
                  placeholder='enter your email'
                  value={formData.email}
                  onChange={handleChange}
                /><br /><br />
                
                <input
                  name='password'
                  type='password'
                  className='registration-input'
                  placeholder='enter your password'
                  value={formData.password}
                  onChange={handleChange}
                 /><br /><br />
                  <input
                  name='mobile'
                  type='mobile'
                  className='registration-input'
                  placeholder='enter your mobile'
                  value={formData.mobile}
                  onChange={handleChange}
                /><br /><br />
              <input
                  name='age'
                  type='age'
                  className='registration-input'
                  placeholder='enter your age'
                  value={formData.age}
                  onChange={handleChange}
                /><br /><br />
            <input
                  name='gender'
                  type='gender'
                  className='registration-input'
                  placeholder='enter your gender'
                  value={formData.gender}
                  onChange={handleChange}
                /><br /><br />
            

            <select
              name='doctor'
              className='registration-input'
              value={formData.doctor}
              onChange={handleChange}
              required
            >
              <option value="" hidden>-- Choose a doctor --</option>
              {
                  doctors.map((element,index)=>{
                    console.log(element);
                    let{did,firstName,lastName,specialization}=element;
                    return(
                      <Fragment key={index}>
                          <option value={did}>{firstName} {lastName}  ({specialization})</option>
                      </Fragment>
                    )
                  })
              }
              
            </select><br /><br />

            {'\u00A0'} {'\u00A0'} {'\u00A0'}{'\u00A0'}{'\u00A0'}{'\u00A0'} {'\u00A0'} {'\u00A0'} <button type='submit' className='registration-button'>Submit</button>
            
            <pre>Do have an account? <Link to="/PatientLogin"> Login</Link></pre>
          </form>
        </div>
      </div>

      <div className='registration-footer'>
        <p>Near tower clock, Anantapur, Andhra Pradesh-515766. For enquiries call 09959410482 or email: gollaindresh201@gmail.com</p>
      </div>
    </>
  );
};

export default RegistrationForm;
