import React from 'react';
import './Avatar.css'; // Import CSS file for styling

const Avatar = ({ src, alt, size }) => {
  return (
    <div className="avatar" style={{ width: size, height: size }}>
      <img src={"https://img.freepik.com/free-vector/isolated-young-handsome-man-different-poses-white-background-illustration_632498-859.jpg?size=338&ext=jpg&ga=GA1.1.1887574231.1711670400&semt=ais"} alt={"Image not found"} className="avatar-img" />
    </div>
  );
};

export default Avatar;
