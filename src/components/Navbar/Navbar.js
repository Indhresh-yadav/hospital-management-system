import React from "react";
import { NavLink} from "react-router-dom";
import hospitallogo from "../../assets/hospital.jpg";
import "../Home/Home.css";
const Navbar = () => {
  
  
  return(
    <>
    <div className="navbar">
     
      <img src={hospitallogo} alt="Logo" className="navbar-logo" />
    
    <div className="navbar-links">
      <NavLink to="/">Home</NavLink>
      <NavLink to="/about">About</NavLink>
      <NavLink to="/contact">Contact</NavLink>
      <NavLink to="/PatientLogin">PatientLogin</NavLink>
      <NavLink to="/DoctorLogin">DoctorLogin</NavLink>
      <NavLink to="/adminlogin">AdminLogin</NavLink>
      

    </div>
    </div>
    
    </>
)
}

export default Navbar;
