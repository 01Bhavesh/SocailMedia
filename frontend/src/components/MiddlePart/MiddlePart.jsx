import { Avatar, Card, IconButton } from '@mui/material'
import React from 'react';
import AddIcon from '@mui/icons-material/Add';
import StoryCircle from './StoryCircle';
import ImageIcon from '@mui/icons-material/Image';
import VideocamIcon from '@mui/icons-material/Videocam';
import ArticleIcon from '@mui/icons-material/Article';
import Postcard from '../Post/Postcard';

const story = [11,1,1,1]
const posts = [1,1,1,1]
const MiddlePart = () => {
  const handleOpenCreatePostModal=()=>{
    console.log("open post model...")
  }
  return (
    <div className='px-20'>
      <section className="flex items-center justify-center p-5 rounded-b-md">
        <div className='flex flex-col items-center mr-4'>
        <Avatar 
      // src='data:image/webp;base64,UklGRgIMAABXRUJQVlA4IPYLAACwPQCdASrkAJ4APpFGnUolpCKpJ1U6ASASCWMHBYAKEN6mzXgGa8uMdsDHBc3FN3RysvUPYeW7e3v9zzZwWrKkW5DyXgUZKX5GZ1hG4eajbsDUWO+9X6hEpmI/IlSTggrs7/tscWLFgOLAQH1tmBjpzG04GsxlK9+T2qh3jKA5OsApc+IcNiX6x7/mI/gjyKQmribEZEU8MxnsDOaMEZ9vK1XRPoEyDYLkrfHPDihRDKugTS+Av97X/nsMLixGNAiUOgVOwvgmvixvjE4q+jOZ5njq7bMe/NGZzpASSx3xRGLfFQv5DGsTn+ITdDlujTfKtwBG/J7mQZ+puMblTE0aav6VL+AV7P666S8I537x5aFGiq/S2lwnF3NharmawelH/Suokp0HwyUhoYZ5YZqnwXfvg3rMl8webzJREZ8abZvXEAFEAzLqhfi0nVHWJDYiqdwMKOhp3N761hEzqRrnNJZkEePYp0UpkcqXuGA4EPNpyUsxXZH2QFU7KTbGiPupNRHjYFZv4UMAhhCBnyJoV6Z5KYEJYg3OURk9eo6EwNthDWlLti+g+6bGgNnsT4ZA5FThoAfbZSVd8hlopf9qFFEv5ZUkEfbswmx4Xler2lZBbv8GX3ip3J4bE6M5QYFZVSAhTRIzMFQKKodweIq4gTwALs8QAP71vzJnZNfwTqpgtNqKw8Cr37lOWYo4zzjy8IIFdAVKtY1QaFjIBlxr+eVIU0iokIPaC016oL4FqdAPT9z7KQeLokdDECQEHsq/TUgv4JVWpEejlIRl2bBRYpXpjQFqLp4z9CsI6I3v8I4SqMh422Ewl6oq5uyCVvcLBCM3AGA+D+crUWBfWiLz6e1PW+QPD+TGgcxp7F13PbbC9onTAM6SbHDuHvkp3hJ69O6c58fZB+X2AKs0IflOTqdUEZCOOhIaaVdLwoP5RztfQ3304YX85fKJn6O+tStLjY1fuGqoC6oIrhqPE5DKIHg0A990HEHVG/TY37UaQy4YrOVeIkejutZkjmM2pSMfJXJHpHMQvxwE/5BB5EYE/0CAY3sP7qCkPhtvHXAjCWDfuW34QkWmBMGePJwlomBuUGUbE8RaHoKrnjkZwCq12RUndht2TJm51u5ZhmNIEWigGbmmFV336vRKxNl53H8v/ElGkRxaHHZtUcYbPw1yJAmrgbJ2dATxqgxNJYBqRWtAcM9ssEGEIosr1ktyJlD+RNnwDO03IsOYhY7xnn+cU6iJ/QPl2aFRkvJQJRtzPQbpMzMT+Txmw9VKb9WOHEMErkRf602Kuy3fstGG4wZffLM7PuwVJ9+E8D9jqJTHNJN1Cqzj/kXeSXDUhRptpLHkiC6Tr8xIJk6DNT0YJFaa7+2BTuAEJeFhbtkqsSv7ZBFjvED5ZQmvEuobVO7hXZqXNkI6g3r9p+w5PKIYhTwqxbI7gABMtHOUxKHbvuhyh+5f2eVUN2jho57fvbkuCt2cK/OXkSjEIRwKxbxGR7NvuSDU36SjpkiK9ZK7oEjhrC3zFC9P6ncwm23VlLljkZRgLDv8MrMnk4P2Ui+nIMv2aNe2ujxpSeJ+Ek3wvhec5nHbqLQByr85AGQoTatsGaqjzZICQDVbD1HTVF6tH2ZmZv6pitJT5cw6dhbXgD7kJjb0mWhjeJnbHQ9rAmp6m9ZgVibXQIvYJ1TRvFkzaOpLR4pbwMsmUjLsBymxwJ3EPsfrV2oxK91LgFVIrRiIXsczfE3uYksqNsuxAUvLVBaWpApBG70IIBH1DsnnMuVY9qytr17S7L/l4ox/RAeB6x6u+i25SZm3xxgHcvszYSYF4vp6umd2FocoFW6CGnd3ATr4RCT9czHk6dD2dX738BQ2p/7UFqrNfdioWFtiox+i5vg2QOWszh6/XU/PDuIK1PqHFhG89pngnpl8cO4iLOevqwKhGak53oNu+fSCpN8Y1WgRS+b1QipFe7xSSjMuNqxbRAimHfJrpVHLJnJe6JJGW2wCSyLNLavx5/SdS8LqdmE8v7psUFg3WE7I1ya0EO12smmvxMdzdhIDYsnDmfOZhTGEc1e8Pb+PtYIqX1yNDA4pdkCNCS/TdqlQGCMs+hMP8G2Kk8mClNXv+MY2pEexGGYJVbW8Njk/On8Pbq7FZqYmCXf+uNvaOYYjMVv30NZUKKVDKivtuNb0wQ5w92azS60lbQMbpNyHuke9sE91PrtaNdJY8r/qJ+NZmQcJKGg8vC/bWY2fiG6LXt47vj9apTHGkqOE53as5doyiiSIw8gJrVsfibRFjE6diWxfYrTdPGVAAtv4NltWGytbpUQxp07x/w3eTUSCa2B47gM8Qs/uW7NLzMMmK2COK67hivkWhLK3CiA2X3PARgzvVKWyEYVZ/9ogM+q7JKI3ViSZI4mH6mDYkSnffqg4RTTOfCgzGwK2NZJYKnAevknQwn5MQ4CDVoQm9uvDueoIWieRvIW1cHM8yLAE/tSjReSSF/VvNPrFn1DBuIays5XJAwS7CAIGLLN/5VIHsSPaLusRT7EaS7K2A5evG+i6f0jWrzwCy4wjwT/HojhHzdSD/C4vwnKxSMZKb7OPcySi28JTanTJ1vMq/U/aP6ukCSBUDRHCm0KfJot6vBZEn+5r73CIqjOP16HnNz2AbSmBnq5NOKQjhtR6dG8BYfB2hX3TLrgAe4kIci1cwtvISCiP5hP7NTChuKo2IP745s3/ydc0RxjfgOCS2mTA2KYeNM81A5D7Z7ZtZaDAhx8+ccYF2Vg49mcdBp2uAL6+nGAwUN2ij2bYH4fE0kBUd9+T+kzinjoPaq8HxTo662nuqlaMRLPfCwzR/kFWzz8HCBMb4546Xbk2iCUaZrLma18RgpI0cxXhCt0QfD8IQDhthBvhUlAmJOriT7PtKU8BKNB1fQF6UnqL3slRaZShhWv+aN+IjB13TqBWwxiq8GO4NUtSR9fIR//9EkK93laK6K0ASLlUAIbyINncQZgM4SV2UZtY5ZEAFxwTHfbi/JgOns+z51zXri4b8uU+BRC6vLINxYpXWBjM0LCLATinBzfGaxekjZyG1qw+1abC7P9VoBAt9gcmWMDllR8616BwiXL910kz0qkGm/r4oFTP2RL6rQUJz1WkCLA3m6raPN+x9OPDNmo2T8R8mcbE4CheVsZLRpGqQifZFEuXLZt4CVrlJob1luc1pv7T9fpm5EeUPCl8vU2CzohfBLVSp73Ut4tPzCUCrHcJuSacLrB0Ah1tMtFXZBTKd2qpLDgzGWbUYiUjjotwBPLJMi/WriwpQkFDMs6TBuDB6vf5olgmhBIAdNxCtEHVskQ0ls6CeUNzQnmEq0B6rxt6k8bOEX5N5wO3m3jC3eEGrtkmewJNZ1vqYVtLrd5watawLJfg5jXd/xScl+AOX8XVN+VBoBG3wnjW2+wOy5E/Ctz53LiKNp/THrb2rfuMJrl1BR2cd4c4v5+6bu/70ggmWLVzKqKaUCrTqU5P2WoeulMDTjElon4UqDPJx7Jag2bDZdE7DymxKlFtWicPhyvJ0LsDoBQ/kQauoX5qrMJXTMzpkUfPjXH0cd7tFnSHlP4Opndf1B1o4mKMSkSk8pkZOIRyeA+SLAZ/pcK5KbrHLarzDPpvEDD1e6qUComMZ7H9My0UVj+cofeK1vK7XIL1VgOJzOvaB3lVUm/XUKV+l+ueCWGdo82w4qh59QOcaiIXFnxtFexTfhLvJ2LK9Xd1rl0esdO7BrLyiwPSzfmQwTDuwFTJBylXK3FXdBG+rMk5xocVTtiklKrbywlsdGj2nIhMOdSjMYpqZoJVWdTEzFugl3tyJVYM131JOeZbw7rLIDcgcYX+5QC3ajV9566CzVgYTc+zoP65F9nT9uNjPtEBDvz/xfTavrIvBmNT0e68r6cGN+BiEP/rG1xXEfOA8S80HGT39mEg98BGOoa7qvJpeyXprYLZlSY7sBw5fOuHp7a9/LbgoWVJB9Kk7d5KqzKmc1dDQ33AwqGWAGwcHMaQ1oC6sWR8qs+3y7+Pxbbdev6a2h9BDImX595J2xPWG2U82X5q8zYOxlRDhdbMozlEY7HJgu62H1IeMoy6kogAAA=='
       alt="Avatar" size={50} >
        <AddIcon sx={{fontSize:"3rem"}}/>
       </Avatar>
       <p>New</p>
        </div>
      {story.map((item)=><StoryCircle></StoryCircle>)}
      </section>
      <Card className='p-5 mt-5'>
        <div className='flex justify-between'>
    <Avatar/>
    <input readOnly className='outline-none w-[90%] rounded-full px-5 bg-transparent border-[#3b4054] border' type='text'></input>
        </div>
        <div className='flex justify-center space-x-9 mt-5'>
          <div className='flrx items-center'>
            <IconButton color='primary' onClick={handleOpenCreatePostModal}>
              <ImageIcon></ImageIcon>
            </IconButton>
            <span>
              media
              </span>
          </div>

          <div className='flrx items-center'>
            <IconButton color='primary' onClick={handleOpenCreatePostModal}>
              <VideocamIcon></VideocamIcon>
            </IconButton>
            <span>
              video
              </span>
          </div>
        
          <div className='flrx items-center'>
            <IconButton color='primary' onClick={handleOpenCreatePostModal}>
              <ArticleIcon></ArticleIcon>
            </IconButton>
            <span>
              article
              </span>
          </div>
        </div>
      </Card>
      <div className='mt-5 space-y-5'>
        {posts.map((item)=><Postcard/>)}
      <Postcard></Postcard>
      </div>
    </div>
  )
}

export default MiddlePart
