import React, { createContext, useState } from 'react'


export let mycontext=createContext();
const GlobalContext = ({children}) => {

    let [doctors,setDoctors]=useState([])
    let [patientDetails,setPatientDetails]=useState()
  return (
    <mycontext.Provider value={{doctors,setDoctors,patientDetails,setPatientDetails}}>
      {children}
    </mycontext.Provider>
  )
}

export default GlobalContext
