import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Modal from '@mui/material/Modal';
import { useDispatch } from 'react-redux';
import { useFormik } from 'formik';
import { Avatar, IconButton, TextField } from '@mui/material';
import CloseIcon from '@mui/icons-material/Close';
import { updateProfileAction } from '../../Redux/Auth/auth.action';

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 500,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 2,
  outline : "none",
  overFlow : "scroll-y",
  borderRadius : 2, 
};

export default function ProfileModel({ open,handleClose }) {
    const dispatch = useDispatch();

    const handleSubmit = (values)=>{
      console.log("values",values);
    }
    const formik = useFormik({
      initialValues:{
        firstName:"",
        lastName:""
      },
      onSubmit:(values,)=>{
        console.log("values",values)
        dispatch(updateProfileAction(values))
      },
    })

  return (
    <div>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <form onSubmit={formik.handleSubmit}>
            <div className='flex items-center justify-between'>
              <div className='flex item-center space-x-3'>
                <IconButton onClick={handleClose}>
                  <CloseIcon/>
                </IconButton>
                <p>Edit Profile</p>
              </div>
            <Button type='submit'>Save</Button>
            </div>
            <div>
            <div className='h-[15rem]'>
            <img className='w-full rounded-t-md' src='https://motionbgs.com/media/1397/goku-ultra-instinct_2.jpg' alt=''/>
           </div>
           <div className='pl-5'>
          <Avatar className='transform -translate-y-24' sx={{ width: '10rem' , height: '10rem'}} src='https://w0.peakpx.com/wallpaper/583/634/HD-wallpaper-kid-goku-dbz-dragon-ball-dragon-ball-z-goku-kid-vegeta-thumbnail.jpg'/>
          </div>
           </div>
           <div className='space-y-3'>
            <TextField fullWidth id='firstName'name='firstName'label='First Name'value={formik.values.firstName} onChange={formik.handleChange} />
            <TextField fullWidth  id='lastName'name='lastName'label='Last Name'value={formik.values.lastName} onChange={formik.handleChange} />
           </div>
          </form>
        </Box>
      </Modal>
    </div>
  );
}