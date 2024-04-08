import { Card, Grid } from '@mui/material'
import React from 'react'
import { Login } from './Login'
import Register from './Register'
import { Route, Routes } from 'react-router-dom'

export const Authentication = () => {
  return (
    <div>
        <Grid container>
        <Grid className='h-screen overflow-hidden' item xs={7}>
            <img className='h-full w-full' src='https://previews.123rf.com/images/cifotart/cifotart1809/cifotart180900023/110266933-people-connected-by-social-media-or-social-networks-concept-of-communication-business-globalization.jpg' alt='Image not found'></img>
        </Grid>
        <Grid item xs={5}>
            <div className='px-20 flex flex-col justify-center h-full'>
            <Card className='card p-8'>
            <div className='flex flex-col items-center mb-5 space-y-1'>
                <h1 className='logo text-center'>Socail Media</h1>
                <p className='text-center text-sm  w-[70&]'>Connecting Live, Sharing-Strorie:Your socail-world</p>
            </div>
            <Routes>
            <Route path='/' element={<Login></Login>} />
              <Route path='/signin' element={<Login></Login>} />
              <Route path='/signup' element={<Register></Register>} />
            </Routes>
            </Card>
            </div>
        </Grid>
        </Grid>
    </div>
  )
}
