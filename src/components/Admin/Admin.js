import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import '../Home/Home.css';

const Admin = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.get(`http://localhost:8080/indhreshyadav/adminlogin`, {
        params: { username, password },
      });

      console.log('Raw response:', response);
      console.log('Response data:', response.data);

      const result = response.data;
      setUsername('');
      setPassword('');

      if (result && result.statusCode === 202) {
        alert(result.msg);
        navigate('/doctorregistration');
      } else {
        alert(result.msg || 'Invalid credentials');
      }
    } catch (error) {
      console.error('Login error:', error);
      alert('Something went wrong while connecting to the server.');
    }
  };

  return (
    <div>
      <h3 style={{textAlign:"center", paddingTop:"20px"}}>Admin Login</h3>
      <form onSubmit={handleLogin} className='adminform' autoComplete="off">
        
        <input
          type="text"
          name="username"
          placeholder="Enter your username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          className='admin-input'
        /><br /><br />
        <input
          type="password"
          name="password"
          placeholder="Enter your password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          className='admin-input'
        /><br /><br />
        <button type="submit" className='admin-button'>Login</button>
      </form>
    </div>
  );
};

export default Admin;
