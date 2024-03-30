
import { Button, TextField } from '@mui/material';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import React, { useState } from 'react';
import * as Yup from "yup";
import { useDispatch } from 'react-redux';
import { loginUserAction } from '../../Redux/Auth/auth.action';
import { useNavigate } from 'react-router-dom';

const initialValues = {email:"",password:""}
const validationSchema = {email:Yup.string().email("Invalid email").required("Email is required"),password:Yup.string().min(6,"Password must be at least 6 characters").required("Password is required")}
export const Login = () => {
    const [formValues,setFormValue] = useState();
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleSubmit=(values)=>{
        console.log("handle submit",values)
        dispatch(loginUserAction({data:values}))
    };
  return (
    <>
    <Formik onSubmit={handleSubmit}
    //  validationSchema={validationSchema} 
     initialValues={initialValues}> 

    <Form className='space-y-5'>
<div className='space-y-5'>
<div>
    <Field as={TextField} name='gmail' placeholder='email' type='gmail' variant='outlined' fullWidth></Field>
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
        <Button onClick={()=>navigate("/register")}>Register</Button>
    </div>

    </>
  );
};
export default Login;