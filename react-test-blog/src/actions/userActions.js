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
  console.log(logout);
};

export const register = (registerForm, history) => async (dispatch) => {
  try {
    const response = await axios.post("/api/user/register", registerForm);
    history.push("/login");
  } catch (err) {
    console.log(err);
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

{
  // createPost
}
export const createPost = (blogPost, history) => async (dispatch) => {
  const res = await axios.post("/api/post/create-post" + blogPost);
  console.log(res);
  history.push("/dashboard");
};
