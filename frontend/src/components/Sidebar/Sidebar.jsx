import React from 'react'
import { navigationMenu } from './SidebarNavigation'
import { Button, Card, Divider, Menu, MenuItem } from '@mui/material'
import PersonIcon from '@mui/icons-material/Person';
import MoreHorizIcon from '@mui/icons-material/MoreHoriz';

const Sidebar = () => {

  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };


  return (
    <Card className='card h-screen flex flex-col justify-between py-5'>
        <div className='space-y-8 pl-5'>
        <div className=''>
        <span className='logo font-bold text-xl'>
        <b>Social Media</b>
        </span>
        </div>
        <div className='space-y-5'>
    {navigationMenu.map((item)=> <div className='cursor-pointer flex space-x-items-center'>
      {item.icon}
      <p className='text-xl'>{item.title}</p>
      </div>)}
        </div>
        <Divider/>
        <div className='pl-5 flex item-center justify-between pt-5'>
          <div className='flex item-center space-x-3'>
    <div>
    <hr></hr><hr></hr>
      <PersonIcon/>
      <p><b>Socail Media</b></p>
      <p><b>@socailMedia</b></p>
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
        <MenuItem onClick={handleClose}>Profile</MenuItem>
        <MenuItem onClick={handleClose}>My account</MenuItem>
        <MenuItem onClick={handleClose}>Logout</MenuItem>
      </Menu>
        </div>
        </div>

    </Card>
  )
}

export default Sidebar