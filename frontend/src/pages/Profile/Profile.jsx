import { Avatar, Box, Button, Card, Tab, Tabs } from '@mui/material';
import React from 'react'
import { useParams } from 'react-router-dom'
import Postcard from '../../components/Post/Postcard';
import UserReelsCard from '../../components/Reels/UserReelsCard';
import { useSelector } from 'react-redux';
import ProfileModel from './ProfileModel';
import { useState } from 'react';

const tabs=[
  {value:'post',name:'Post'},
  {value:'reels',name:'Reels'},
  {value:'saved',name:'Saved'},
  {value:'repost',name:'Repost'}
]
const posts = [1,1,1,1]
const reels = [1,1,1,1]
const savedPost = [1,1,1]
const Profile = () => {
    const {id} = useParams();
    const [open, setOpen] = useState(false);
  const handleOpenProfileModel = () => setOpen(true);
  const handleClose = () => setOpen(false);

    const [value, setValue] = React.useState('post');
    const {auth} = useSelector(store=>store);
  const handleChange = (event, newValue) => {
    setValue(newValue);
  };
  return (
    <Card className='my-10 w-[70%]'>
      <div className='rounded-md'>
        <div className='h-[15rem]'>
          <img className='w-full h-full rounded-t-md' src='https://lh3.googleusercontent.com/proxy/4973GJPvdYPfiMuI9O-MRKtPAKcXrhKPFNkXUBK0Pg-bDBI40daBGPXk1Yuqr-cEZd3j-LdrVqHbSLTZqAXQZFuBt-9nSLC4iwD-bNmuTWgBEUVpMGJ4S3HDvy8CyOemg1PY' alt='Image' />
        </div>
        <div className='px-5 flex justify-between items-start mt-5 h-[5rem]'>
      <Avatar className='transform -translate-y-24' sx={{ width: '10rem', height: '10rem' }} src='https://w0.peakpx.com/wallpaper/1013/327/HD-wallpaper-goku-mystic-ultra-instinct-dbz-dragon-dragon-ball.jpg' />
      <section>
        <Button onClick={handleOpenProfileModel} sx={{ borderRadius: '20px' }} variant='outlined'>Edit Profile</Button>
        <ProfileModel open={open} handleClose={handleClose} /> 
      </section>
    </div>
        <div className='p-5'>
          <div>
            <h1 className='py-1 font-bold text-xl'>{auth.user?.firstName +" "+ auth.user?.lastName}</h1>
            <p>@{auth.user?.firstName.toLowerCase() +""+ auth.user?.lastName.toLowerCase()}</p>
          </div>
          <div className='flex gap-5 items-center py-3'>
            <span>29 post</span>
            <span>2000 followers</span>
            <span>03 followings</span>
          </div>
          <div>
            <p> Indian international cricketer, currently captain the India national cricket team across all formats.</p>
          </div>
        </div>
        <section>
        <Box sx={{ width: '100%', borderBottom:1,borderColor:'divider'}}>
      <Tabs
        value={value}
        onChange={handleChange}
        aria-label="wrapped label tabs example"
      >
        
        {tabs.map((item)=><Tab value={item.value} label={item.name} wrapped/>)}
      </Tabs>
    </Box>
    <div className='flex justify-center'>
      {value==='post'? (<div className='space-y-5 w-[70%] my-10'>
    {posts.map((item)=> (<div className='border border-slate-100 rounded-md'>
      <Postcard/>
    </div>))}

      </div>
      ):value==='reels'?<div className='flex justify-center flex-wrap gap-2 my-10'>
          {reels.map((item)=> <UserReelsCard/>)}
        
        </div> :value==='reels'?<div className='flex justify-center flex-wrap gap-2 my-10'>
          {reels.map((item)=> <UserReelsCard/>)}
        
        </div>:value==='saved'? (<div className='space-y-5 w-[70%] my-10'>
    {savedPost.map((item)=> (<div className='border border-slate-100 rounded-md'>
      <Postcard/>
    </div>))}

      </div>
      ) :(
        <div>Repost</div>
        )}
    </div>
        </section>
      </div>
      
    </Card>
  )
}

export default Profile
