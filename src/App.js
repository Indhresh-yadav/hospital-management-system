import React from 'react'
import Navbar from "./components/Navbar/Navbar" 
import { BrowserRouter } from 'react-router-dom'
import { Routes, Route } from'react-router-dom'
import HomePage from "./components/Home/HomePage"
import AboutPage from "./components/About/AboutPage"
import ContactPage from "./components/Contact/ContactPage"


import RegistrationForm from './components/PatientDetails/RegistrationForm'
import PatientLogin  from './components/PatientDetails/PatientLogin'
import PatientDetails from './components/PatientDetails/PatientDetails'
import PatientDoctorDetails from './components/PatientDetails/PatientDoctorDetails'

import Admin from './components/Admin/Admin'

import DoctorLogin from './components/DoctorDetails/DoctorLogin'
import DoctorRegistration from './components/DoctorDetails/DoctorRegistration'
import DoctorDetails from './components/DoctorDetails/DoctorDetails'
import EditDoctorDetails from './components/DoctorDetails/EditDoctorDetails'
import EditPatientDetails from './components/PatientDetails/EditPatientDetails'


const App = () => {
   return (
   <BrowserRouter>
   <Navbar/>
   <Routes>
        <Route path="/" element={<HomePage/>} />
      
        <Route path='/DoctorLogin' element={<DoctorLogin/>} />
        <Route path='/adminlogin' element={<Admin/>}/>
        <Route path='/DoctorDetails' element={<DoctorDetails/>}/>
        <Route path='/editdoctordetails' element={<EditDoctorDetails/>}/>
        <Route path='/editpatientdetails' element={<EditPatientDetails/>}/>
        <Route path='/doctorregistration' element={<DoctorRegistration/>}/>
        <Route path='/RegistrationForm' element={<RegistrationForm/>} />  
        <Route path='/PatientLogin' element={<PatientLogin/>} /> 
        <Route path='/PatientDetails' element={<PatientDetails/>}/>
        <Route path='/PatientDoctorDetails' element={<PatientDoctorDetails/>}/>
        <Route path="/about" element={<AboutPage/>} />
        <Route path="/contact" element={<ContactPage/>} />
      </Routes>
   </BrowserRouter>
  
  
  )
}

export default App
