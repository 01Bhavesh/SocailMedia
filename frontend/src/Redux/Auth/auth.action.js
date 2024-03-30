import axios from "axios";
import { LOGIN_FAILURE, LOGIN_SUCCESS } from "./auth.actiontype";
import { API_BASE_URL } from "../../config/api";

export const loginUserAction = (loginData) => async (dispatch) => {
    dispatch({ type: LOGIN_SUCCESS }); // Dispatch LOGIN_SUCCESS initially
    try {
        const { data } = await axios.post(`${API_BASE_URL}/auth/signin`, loginData.data);

        if (data.jwt) {
            localStorage.setItem("jwt", data.jwt);
            dispatch({ type: LOGIN_SUCCESS, payload: data.jwt }); // Dispatch LOGIN_SUCCESS with JWT payload
        }
        console.log("login success", data);
    } catch (error) {
        console.log("Error occurred during login:", error);
        dispatch({ type: LOGIN_FAILURE, payload: error }); // Dispatch LOGIN_FAILURE if login fails
    }
};


export const registerUserAction=(loginData)=>async(dispatch)=>{
    dispatch({type:LOGIN_SUCCESS})
    try {
        const {data}=await axios.post(`${API_BASE_URL}/auth/signup`,loginData.data)

        if(data.jwt)
        {
            localStorage.setItem("jwt",data.jwt)
        }
        console.log("register..",data)
        dispatch({type:LOGIN_SUCCESS,payload:data.jwt})
    } catch (error) {
        console.log(".......",error)
        dispatch({type:LOGIN_FAILURE,payload:error})
    }
}

