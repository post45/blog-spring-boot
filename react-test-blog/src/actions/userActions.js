import axios from "axios";
import { GET_ERRORS, GET_POSTS } from "./types";

export const login = (loginForm, history) => async (dispatch) => {
  try {
    const response = await axios.post("/api/user/login", loginForm);
    history.push("/dashboard");
  } catch (err) {
    console.log(err);
  }
};

export const logout = () => (dispatch) => {
  axios.get("api/user/logout");
  alert(" SignOut Successfully", "success");
  return this.props.history.push("/login");
};
export const register = (registerForm, history) => async (dispatch) => {
  try {
    const res = await axios.post("/api/user/register", registerForm);
    console.log(res);
    history.push("/login");
  } catch (err) {
    console.log(err);
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
  const res = await axios.get("/api/post/user-posts/" + id);
  console.log(res);
  dispatch({
    type: GET_POSTS,
    payload: res.data,
  });
};
