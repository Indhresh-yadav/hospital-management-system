import React from 'react'
import '../Home/Home.css'
import contactimage from '../../assets/contanctpageimage1.jpg'
import contactimage2 from '../../assets/contanctpageimage.jpeg'
const ContactPage = () => {
  return(
    <>
    <div className='contactpage-main'>
      <img src={contactimage} alt='contact image' className='contact-image' />
      <img src={contactimage2} alt='contact image' className='contact-image1' />
      <h3 className='contanctpage-heading'>Contact Us</h3>
    <div className='contanctpage-section'>
      <h3>Contact Information</h3>
      <ul>
        <li>Email: gollaindresh201@gmail.com</li>
        <li>Phone: 09959410482</li>
        <li>Address: Near tower clock, Anantapur, Andhra pradesh-515766</li>
      </ul>
      <h3>Social Media</h3>
      <ul>
        <li><a href='https://www.facebook.com/Gollaindresh-201'>Facebook</a></li>
        <li><a href='https://www.instagram.com/gollaindresh201'>Instagram</a></li>
        <li><a href='https://www.twitter.com/gollaindresh201'>Twitter</a></li>
        <li><a href='https://www.linkedin.com/in/gollaindresh-201'>LinkedIn</a></li>
        <li><a href='https://www.youtube.com/channel/UCP8Yp0z-b1jO7dK80g8v-CAQ'>Youtube</a></li>
      </ul>
      <h3>Opening Hours</h3>
      <ul>
        <li>Monday to Friday: 9:00 AM to 5:00 PM</li>
        <li>Saturday: 9:00 AM to 1:00 PM</li>
        <li>Sunday: Closed</li>
      </ul>
    </div>
    <p className='contanct-footer'>Thank your for visiting us  Health Bridge Hospital,23, Sri Krishna Nagar, Anantapur,Andhra Pradesh, India,Phone: 09959410482,Email: gollaindresh201@gmail.com</p>
    
     

    </div>

    </>
  )
  
}

export default ContactPage
