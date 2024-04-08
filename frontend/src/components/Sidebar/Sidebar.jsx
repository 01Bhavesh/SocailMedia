import React from 'react'
import { navigationMenu } from './SidebarNavigation'
import { Button, Card, Divider, Menu, MenuItem } from '@mui/material'
import PersonIcon from '@mui/icons-material/Person';
import MoreHorizIcon from '@mui/icons-material/MoreHoriz';
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';

const Sidebar = () => {
  const {auth} = useSelector(store=>store);
  const navigate=useNavigate();
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };
const handleNavigate=(item)=>{
  if(item.title==="Profile"){
    navigate(`/profile/${auth.user?.id}`)
  }
  else{
    navigate(item.path)
  }
  // if(item.title==="Home"){
  //   navigate('/')
  // }
  // if(item.title==="Reels"){
  //   navigate('/reels')
  // }
  // if(item.title==="Create Reels"){
  //   navigate('/create-reels')
  // }
}

  return (
    <Card className='card h-screen flex flex-col justify-between py-10'>
        <div className='space-y-8 pl-5'>
        <div className=''>
        <span className='logo font-bold text-xl'>
        <b>Social Media</b>
        </span>
        </div>
        <div className='space-y-5'>
    {navigationMenu.map((item)=> (<div onClick={()=>handleNavigate(item)} className='cursor-pointer flex space-x-items-center'>
      {item.icon}
      <p className='text-xl'>{item.title}</p>
      </div>))}
        </div>
        <Divider/>
        <div className='pl-5 flex item-center justify-between pt-5'>
          <div className='flex item-center space-x-3'>
    <div>
    <hr></hr><hr></hr>
      <PersonIcon/>
      <p><b>{auth.user?.firstName +" "+ auth.user?.lastName}</b></p>
      <p><b>@{auth.user?.firstName.toLowerCase() +""+ auth.user?.lastName.toLowerCase()}</b></p>
    </div>
          </div>
          <Button
        id="basic-button"
        aria-controls={open ? 'basic-menu' : undefined}
        aria-haspopup="true"
        aria-expanded={open ? 'true' : undefined}
        onClick={handleClick}
      >
        <MoreHorizIcon/>
      </Button>
      <Menu
        id="basic-menu"
        anchorEl={anchorEl}
        open={open}
        onClose={handleClose}
        MenuListProps={{
          'aria-labelledby': 'basic-button',
        }}
      >
        <MenuItem onClick={()=>navigate(`/profile/${auth.user?.id}`)}>Profile</MenuItem>
        <MenuItem onClick={handleClose}>My account</MenuItem>
        <MenuItem onClick={()=>navigate("/signin")}>Logout</MenuItem>
      </Menu>
        </div>
        </div>

    </Card>
  )
}

export default Sidebar
