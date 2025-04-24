import React from 'react'
import '../Home/Home.css'
import doctorabout from '../../assets/aboutdoctor.avif'
import lab from '../../assets/lab.jpg'
import pharamcy from '../../assets/Pharamcy.avif'
import scanning from '../../assets/scanning.jpg'
import surgery from '../../assets/OT.jpg'
import inpatientward from '../../assets/inpatientward.webp'
import icuward from '../../assets/icu.jpg'
import outpatientward from '../../assets/outpatient.webp'
import amubulence from '../../assets/ambulance.jpeg'
const AboutPage = () => {
  return (
    <>
    
      <div>
      <img src={doctorabout} alt='doctor about' className='about-doctor-image' />
      <div className='about-page-main'>
      <h3 className='about-about'>About Us</h3>
        <h3>  Our services</h3>
      <ul className='about-ourservices'>
        <li>Cardiology</li>
        <li>Dermatology</li>
        <li>Neurology</li>
        <li>Orthopedics</li>
        <li>ENT</li>
        <li>General Surgery</li>
        <li>Gastroenterology</li>
        <li>Dermatology</li>
        <li>Nephrology</li>
        <li>Urology</li>
        <li>Obstetrics</li>
      </ul>
      <h3>  Our doctors</h3>
      <ul className='about-ourservices'>
        <li>Dr. Indhresh Yadav (MBBS, MD, DM)</li>
        <li>Dr. Veerendra (MBBS, MD)</li>
        <li>Dr. Vinneth Kumar (MBBS, MD, DM)</li>
        <li>Dr. Dp Santhosh Kumar (MBBS, MD, DM)</li>
        <li>Dr. Michael Brown (MBBS,MS)</li>
      </ul>
      </div>
     <div className='about-doctor-information'>
      <h3>Our Doctors information</h3>
      <p>Health Bridge Hospital is proud to have a team of highly qualified and experienced doctors who are dedicated to delivering exceptional patient care. Leading the medical team is Dr. Indhresh Yadav, MBBS, MD, DM, a renowned Cardiologist and the Chairman of Health Bridge Hospitals. With years of experience and a reputation for excellence in heart care, Dr. Yadav also serves as the Senior Consultant in Cardiology. His leadership, dedication, and commitment to advanced cardiac treatment have been instrumental in building the hospital's strong reputation.</p>
       <p>Joining him is Dr. G. Veerendra, MBBS, MD, a General Physician known for his clinical expertise and compassionate care. A gold medalist in MBBS, Dr. Veerendra has a strong background in internal medicine and is widely respected for his ability to diagnose and treat a wide range of health conditions. His patient-friendly approach and sharp diagnostic skills make him a key pillar of the hospital’s general medicine department.</p>
       <p>The hospital is also privileged to have Dr. Vinneth Kumar, MBBS, MD, DM, a Neurologist with an impressive track record, including his previous role at AIIMS Delhi. Now serving as a Senior Consultant in Neurology at Health Bridge Hospital, Dr. Kumar brings deep expertise in managing complex neurological disorders. Completing this team of specialists is Dr. D.P. Santhosh Kumar, MBBS, MS, an experienced ENT Specialist with proficiency in both medical and surgical ENT procedures. His well-rounded expertise ensures comprehensive care for patients with ear, nose, and throat conditions. Together, these four experts form the core of Health Bridge Hospital’s medical excellence.</p>
      </div> 
      <div>
        <ul className='about-images'>
        <li>
          <img src={lab} alt='lab' className='aboutimage' />
          <p className='about-images-text'>Our Lab</p>
        </li>
        <li>
          <img src={pharamcy} alt='lab' className='aboutimage'/>
          <p className='about-images-text'>Our Pharamcy</p>
        </li>
        <li>
          <img src={scanning} alt='' className='aboutimage'/>
          <p className='about-images-text'>Our Scanning Center</p>
        </li>
        <li>
          <img src={surgery} alt=''className='aboutimage' />
          <p className='about-images-text'>Our O.T</p>
        </li>
        <li>
          <img src={inpatientward} alt=''className='aboutimage' />
          <p className='about-images-text'>Our inpatient General ward</p>
        </li>
        <li>
          <img src={icuward} alt='' className='aboutimage'/>
          <p className='about-images-text'>Our ICU(Intence Care Unit)</p>
        </li>
        <li>
          <img src={outpatientward} alt='' className='aboutimage' />
          <p className='about-images-text'>Our Outpatient ward</p>
        </li>
        <li>
          <img src={amubulence} alt='' className='aboutimage'/>
          <p className='about-images-text'>Our Ambulance Service</p>
        </li>
        </ul>
        </div>
        <p className='about-footer-page'>Near tower clock,Anantapur,Andhra pradesh-515766 For enquires call 09959410482 (or) gmail:gollaindresh201@gmail.com </p>
     </div>
     
    
    </>
  )
}

export default AboutPage
