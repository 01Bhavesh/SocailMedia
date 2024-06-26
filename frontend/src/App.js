
import { Route, Routes } from 'react-router-dom';
import './App.css';
import { Authentication } from './pages/Authentication/Authentication';
import Message from './pages/Message/Message';
import { HomePage } from './pages/HomePage/HomePage';
import { useDispatch, useSelector } from 'react-redux';
import { useEffect } from 'react';
import { getProfileAction } from './Redux/Auth/auth.action';
import Login from './pages/Authentication/Login';
import Register from './pages/Authentication/Register';

function App() {
  const {auth} = useSelector(store=>store);  //for accessing store from local storage
  const dispatch=useDispatch();
  const jwt = localStorage.getItem("jwt");
  useEffect(()=>{
    dispatch(getProfileAction(jwt))
  },[jwt])
  return (
    <div className="App">

      <Routes>
        
        
      <Route path='/*' element={auth.user ? <HomePage /> : <Authentication />} />
      {/* <Route path='/*' element={<HomePage/>} /> */}
        <Route path='/message' element={<Message />} />
         <Route path='/signin' element={<Login></Login>} />
              /* <Route path='/signup' element={<Register></Register>} /> 
        <Route path='/*' element={<Authentication/>} />
      </Routes>
    </div>
  );
}

export default App;
