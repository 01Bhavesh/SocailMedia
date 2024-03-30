import { Grid } from '@mui/material';
import React from 'react';
import {Route, Routes, useLocation} from 'react-router-dom';
import Sidebar from '../../components/Sidebar/Sidebar';
import MiddlePart from '../../components/MiddlePart/MiddlePart';
import Reels from '../../components/Reels/Reels';
import CreateReelsForm from '../../components/Reels/CreateReelsForm';
import Profile from '../Profile/Profile';
import HomeRight from '../HomeRight/HomeRight';

export const HomePage = () => {
    const location=useLocation();
  return (
    <div className='px-20'>
        <Grid container spacing={0}>
    <Grid item xs={0} lg={3}>
    <div className='sticky top-0'>
        <Sidebar></Sidebar>
    </div>
    </Grid>
    <Grid lg={location.pathname==="/"?6:9} item className='px-5 flex justify-center' xs={12}>
    <Routes>
       <Route path="/" element={<MiddlePart></MiddlePart>}></Route> 
       <Route path="/reels" element={<Reels></Reels>}></Route>
       <Route path="/create-reels" element={<CreateReelsForm></CreateReelsForm>}></Route>
       <Route path="/profile/:id" element={<Profile></Profile>}></Route>
    </Routes>
    </Grid>
    <Grid item lg={3} className='relative'>
    <div className='sticky top-0 w-full'>
    <HomeRight></HomeRight>
    </div>
    </Grid>
        </Grid>
    </div>
  )
}
