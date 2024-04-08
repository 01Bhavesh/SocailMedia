
import { Button, TextField } from '@mui/material';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import React, { useState } from 'react';
import * as Yup from "yup";
import { useDispatch, useSelector } from 'react-redux';
import { loginUserAction } from '../../Redux/Auth/auth.action';
import { Route, Routes, useNavigate } from 'react-router-dom';

const initialValues = {gmail:"",password:""}
const validationSchema = Yup.object().shape({
    email: Yup.string().email("Invalid email").required("Email is required"),
    password: Yup.string().min(6,"Password must be at least 6 characters").required("Password is required")
  });
export const Login = () => {
    const [formValues,setFormValue] = useState();
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const {auth} = useSelector(store=>store);

    const handleSubmit=(values)=>{
        console.log("handle submit",values)
 dispatch(loginUserAction({data:values}))
    };

    // const handleSubmit =  (values) => {
    //     try {
    //         const response = dispatch(loginUserAction({ data: values }));
    //         // If login succeeds, redirect to the home page
    //         console.log(response)
    //         if (response && response.type === 'LOGIN_SUCCESS') {
    //             navigate('/');
    //         }
    //     } catch (error) {
    //         console.log("Error occurred during login:", error);
    //         navigate("/signup")
    //     }
    // };



  return (
    <>
    <Formik onSubmit={handleSubmit}
    //  validationSchema={validationSchema} 
     initialValues={initialValues}> 

    <Form className='space-y-5'>
<div className='space-y-5'>
<div>
    <Field as={TextField} name='gmail' placeholder='email' type='email' variant='outlined' fullWidth></Field>
<ErrorMessage name="gmail" component={"div"} className='text-red-500'></ErrorMessage>
</div>
<div>
    <Field as={TextField} name='password' placeholder='password' type='password' variant='outlined' fullWidth></Field>
<ErrorMessage name="password" component={"div"} className='text-red-500'></ErrorMessage>
</div>
</div>
<Button sx={{padding: ".8rem 0rem"}} fullWidth type="submit" variant="contained" color="primary">Login</Button>
    </Form>

    </Formik>
    <div className='flex gap-2 item-center justify-center pt-5'>
        <p>If you don't have account ?</p>
        <Button onClick={()=>navigate("/signup")}>Register</Button>
    </div>

    </>
  );
};
export default Login;