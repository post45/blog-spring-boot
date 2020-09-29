import { combineReducers } from "redux";
import blogPostReducer from "./blogPostReducer";
import errorReducer from "./errorReducer";
import securityReducer from "./securityReducer";

export default combineReducers({
  errors: errorReducer,
  blogPost: blogPostReducer,
  security: securityReducer,
});
