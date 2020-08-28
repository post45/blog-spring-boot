import React, { Component } from "react";

class Register extends Component {
  render() {
    return (
      <div>
        <form>
          <p className="h4 text-center mb-4">Sign up</p>
          <label htmlFor="defaultFormRegisterNameEx" className="grey-text">
            Your name
          </label>
          <input
            type="text"
            id="defaultFormRegisterNameEx"
            className="form-control"
          />
          <br />
          <label htmlFor="defaultFormRegisterEmailEx" className="grey-text">
            Your email
          </label>
          <input
            type="email"
            id="defaultFormRegisterEmailEx"
            className="form-control"
          />
          <br />
          <label htmlFor="defaultFormRegisterConfirmEx" className="grey-text">
            Confirm your email
          </label>
          <input
            type="email"
            id="defaultFormRegisterConfirmEx"
            className="form-control"
          />
          <br />
          <label htmlFor="defaultFormRegisterPasswordEx" className="grey-text">
            Your password
          </label>
          <input
            type="password"
            id="defaultFormRegisterPasswordEx"
            className="form-control"
          />
          <div className="text-center mt-4">
            <button type="submit">Register</button>
          </div>
        </form>
      </div>
    );
  }
}
export default Register;
