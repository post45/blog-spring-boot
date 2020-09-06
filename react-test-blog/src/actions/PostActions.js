import axios from "axios";
import { GET_ERRORS, GET_POSTS } from "./types";

export const getPostsForUser = (id) => async (dispatch) => {
  const res = await axios.get("/api/post/user-posts/" + id);
  dispatch({
    type: GET_POSTS,
    payload: res.data,
  });
};
