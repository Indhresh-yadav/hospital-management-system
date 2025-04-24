import React from 'react'
import { useNavigate } from "react-router-dom";
import '../Home/Home.css'
import video from '../../assets/backgroundvideo.mp4'
import doctorphoto from '../../assets/doctor.jpg'
import cardilogy from '../../assets/cardilogy.jpg'
import neurologist from '../../assets/neurologist.jpg'
import genaralpysician from '../../assets/generalphysican.jpg'
import ent from '../../assets/ent.jpg'
import veerendra from  '../../assets/veerendra.jpeg'
import vineethkumar from '../../assets/vineethkumar.jpeg'
import santhosh from '../../assets/santhosh.jpeg'


const HomePage = () => {
  const navigate = useNavigate();
  const handleBookAppointment = () => {
    navigate('/RegistrationForm');
  }

  return (
    <>
    <div className="home-video-container">
      <video autoPlay muted loop playsInline className="background-video">
        <source src={video} type="video/mp4" />
    </video>
      <h1 className='home-text'>Welcome to HealthBridge hospitals</h1>
      <img src={doctorphoto} className='home-doctor'/>
      <p className='home-text1'><b>Dr Indhresh yadav</b><br/>sr Cardiology Consultant<br/>Health Bridge Hospitals(MD) </p>
      <p className='home-text2'>" HealthBridge Hospital "- delivering excellence in healthcare.<br/>" Your health,our mission"- every patient matters.</p>
      <button className='home-button' onClick={handleBookAppointment}>Book an appointment</button>
    </div>
    <div>
      <h1 className='home-services'>Our Services</h1>
      <p className='home-services-text'>Our HealthBridge Hospitals offers a variety of services</p>
      <ul className='home-two-per-line'>
        <li>
          <h3>Patient Care:</h3>
          <p>Providing comprehensive medical care, including diagnosis, treatment,<br/> and management of various medical conditions.</p>
        </li>
        <li>
        <h3>Emergency Services:</h3>
        <p>Offering immediate and critical care for patients with life-threatening conditions <br/>or injuries.</p>
        </li>
        <li>
        <h3>Diagnostics:</h3>
        <p>Utilizing various imaging techniques (radiology, CT scans, MRIs) and laboratory tests <br/>to identify and diagnose illnesses.</p>
        </li>
        <li>
        <h3>Surgery:</h3>
        <p>Hospitals have operating rooms and specialized surgical teams to perform various types<br/> of surgeries.</p>
        </li>
        <li>
        <h3>Inpatient Care:</h3>
        <p>Hospitals provide beds and facilities for patients who need to stay overnight <br/>for treatment.</p>
        </li>
        <li>
        <h3>Outpatient Care:</h3>
        <p>Hospitals also offer outpatient services, where patients can receive care without <br/>needing to stay overnight.</p>
        </li>
        <li>
        <h3>Pharmacy:</h3>
        <p>Hospitals have pharmacies to dispense medications to patients. </p>
        </li>
        </ul>
      <br/>
      <br/>
    </div>
    
      <h1 className='home-services'>Meet Our Expert Doctors</h1>
      <br/>
          <br/>
          <br/>
          <br/>
          <br/>
      <div>
        <div className='home-expert-doctor-main'>
         
        <ul className='home-expert-doctors'>
          <li>
            <img src={doctorphoto} alt='Doctor' className='home-doctor-image1'/><button className='home-book-appointement' onClick={handleBookAppointment}>Book Appointment</button>
            <p><b>Dr Indhresh yadav (MBBS,MD,DM)</b><br/>sr Cardiology Consultant<br/>Health Bridge Hospitals(MD) </p>
           
          </li>
          <li>
            <img src={veerendra} alt='Doctor' className='home-doctor-image1'/> <button className='home-book-appointement' onClick={handleBookAppointment}>Book Appointment</button>
            <p><b>Dr Veerendra (MBBS,MD)</b><br/>General Physician<br/>Gold Medalist in MBBS </p>
          </li>
          <li>
            <img src={vineethkumar} alt='Doctor' className='home-doctor-image1'/><button className='home-book-appointement' onClick={handleBookAppointment}>Book Appointment</button>
            <p><b>Dr Vineeth Kumar (MBBS,MD,DM)</b><br/>sr Neurologist & consultent<br/>x employee in AIIMS(Delhi) </p>
          </li>
          <li>
            <img src={santhosh} alt='Doctor' className='home-doctor-image1'/><button className='home-book-appointement' onClick={handleBookAppointment}>Book Appointment</button>
            <p><b>Dr Dp Santhosh kumar (MBBS,Ms)</b><br/>ENT Specialist<br/>Experience in both medical and surgical </p>
          </li>
        
        </ul>
        <ul className='home-expert-doctors'>
          <li>
          <img src={cardilogy} alt='Doctor' className='home-expert-doctors-images'/>
          <br/>
          <br/>
          <br/>
          <br/>
          <br/>
          </li>
          <li>
          <img src={genaralpysician} alt='Doctor' className='home-expert-doctors-images'/>
          <br/>
          <br/>
          <br/>
          <br/>
          <br/>
          </li>
          <li>
          <img src={neurologist} alt='Doctor' className='home-expert-doctors-images'/>
          <br/>
          <br/>
          <br/>
          <br/>
          <br/>
          <br/>
          </li>
          <li>
          <img src={ent} alt='Doctor' className='home-expert-doctors-images'/>
          </li>
        </ul>
        </div>
      </div>
      <br/>
      <div className='home-footer'>
      <p>Near tower clock,Anantapur,Andhra pradesh-515766 For enquires call 09959410482 (or) gmail:gollaindresh201@gmail.com </p>
    </div>
    </>
    

)}

export default HomePage
