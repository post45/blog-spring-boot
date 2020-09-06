import axios from "axios";

export const login = (loginForm) => async (dispatch) => {
  const response = await axios.post("/api/user/login", loginForm);
};

export const register = (registerForm) => async (dispatch) => {
  const response = await axios.post("/api/user/register", registerForm);
};

export const getPostsForUser = (id) => async (dispatch) => {
  const res = await axios.get("/api/post/user-posts/" + id);
  console.log(res);
};
