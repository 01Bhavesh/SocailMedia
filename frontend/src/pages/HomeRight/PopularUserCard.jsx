import { Avatar, Button, CardHeader, IconButton } from '@mui/material'
import { red } from '@mui/material/colors'
import React from 'react'
import MoreVertIcon from '@mui/icons-material/MoreVert';
import { useSelector } from 'react-redux';

const PopularUserCard = () => {
  const {auth} = useSelector(store=>store);
  return (
    <div>
        <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
            {auth.user?.firstName.substring(0,1)}
          </Avatar>
        }
        action={
          <Button>
            Follow
          </Button>
        }
        title={auth.user?.firstName +" "+ auth.user?.lastName}
        subheader={auth.user?.firstName.toLowerCase() +""+ auth.user?.lastName.toLowerCase()}
      />
    </div>
  )
}

export default PopularUserCard