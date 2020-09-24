import { combineReducers } from "redux";
import postReducer from "./postReducer";
import errorReducer from "./errorReducer";
import securityReducer from "./securityReducer";

export default combineReducers({
  errors: errorReducer,
  blogPost: postReducer,
  security: securityReducer,
});
