import React from 'react';
import { useLocation } from 'react-router-dom';
import '../Home/Home.css';
import doctorsymbol from '../../assets/doctorsymbol.png';
import { IoMdAddCircleOutline } from "react-icons/io";
import { PiTrademarkRegisteredThin } from "react-icons/pi";

const PatientDetails = () => {
  const location = useLocation();
  const patientData = location.state;


  return (
    <>
      <div className='patientdetails-main'>
        <div className='patient-details-page'>
          <div className='patient-details-presicription'>
            <IoMdAddCircleOutline className='pd-icon' />
            <img src={doctorsymbol} alt='doctorsymbol' className='patientdetails-doctorsymbol' />
            <p className='patientdetails-text'>Health Bridge Hospital</p>
            <p className='patientdetails-text1'>(Approved by Government of India <PiTrademarkRegisteredThin /> Register:122378)</p>

            <div className='patient-details-date-day'>
              <p><strong>Day:</strong> Wednesday</p>
              <p><strong>Date :</strong> 4/9/2025</p>
              <p><strong>Time :</strong> 12.23</p>
            </div>

            <br /><br />
            <hr /><hr />

            <ul className='patient-details-grid'>
              <li><p><strong>Patient Name:</strong> {patientData.firstName} {patientData.lastName}</p></li>
              <li><p><strong>Email Id:</strong> {patientData.email}</p></li>
              <li><p><strong>Mobile :</strong> {patientData.mobile}</p></li>
              <li><p><strong>Patient age :</strong> {patientData.age}</p></li>
              <li><p><strong>Patient Gender:</strong> {patientData.gender}</p></li>
              <li><p><strong>Doctor :</strong> {patientData.doctorName} ({patientData.specialization})</p></li>
            </ul>
          </div>

          <div className='patient-details-prescription'>
            <h3>Doctor Prescription :</h3>
          </div>
        </div>
      </div>
    </>
  );
};

export default PatientDetails;


