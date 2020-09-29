import axios from "axios";
import { GET_ERRORS, GET_POSTS, SET_CURRENT_USER } from "./types";
import setJWTToken from "../securityUtils/setJWTToken";
import jwt_decode from "jwt-decode";

export const login = (loginForm, history) => async (dispatch) => {
  try {
    const res = await axios.post("/api/user/login", loginForm);
    //extract token from res.data
    const { token } = res.data;
    //store the token in local storage
    localStorage.setItem("jwtToken", token);
    //set our token in header
    setJWTToken(token);
    //decode
    const decode = jwt_decode(token);
    //dispatch to securityReducer
    dispatch({
      type: SET_CURRENT_USER,
      payload: decode,
    });

    history.push("/dashboard");
  } catch (err) {
    console.log(err);
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data,
    });
  }
};

export const logout = () => (dispatch) => {
  axios.get("api/user/logout");
  localStorage.removeItem("jwtToken");
  setJWTToken(false);
  dispatch({
    type: GET_ERRORS,
    payload: {},
  });
  // alert(" Sign Out Successfully", "success");
};

export const register = (registerForm, history) => async (dispatch) => {
  try {
    await axios.post("/api/user/register", registerForm);
    history.push("/login");
    dispatch({
      type: GET_ERRORS,
      payload: {},
    });
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data,
    });
  }
};

export const createPost = (blogPost, history) => async (dispatch) => {
  try {
    const res = await axios.post("/api/post/create-post", blogPost);
    history.push("/dashboard");
    dispatch({
      type: GET_ERRORS,
      payload: {},
    });
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data,
    });
  }
};

export const getPostsForUser = (id) => async (dispatch) => {
  const res = await axios.get("/api/post/user-posts");
  dispatch({
    type: GET_POSTS,
    payload: res.data,
  });
};
