import { combineReducers } from "redux";
import postReducer from "./postReducer";
import errorReducer from "./errorReducer";

export default combineReducers({
  errors: errorReducer,
  blogPost: postReducer,
});
