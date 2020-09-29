import { GET_POSTS } from "../actions/types";

const initialState = {
  blogPosts: [],
  blogPost: {},
};
export default function (state = initialState, action) {
  switch (action.type) {
    case GET_POSTS:
      return {
        ...state,
        blogPosts: action.payload,
      };
    default:
      return state;
  }
}
