import React, { Component } from "react";

class Login extends Component {
  render() {
    return (
      <div className="col-md-6 m-auto">
        <div className="form-area ">
          <form role="form">
            <h2 className="text-center mb-4">Login </h2>
            {
              // email
            }
            <input
              type="email"
              title="email"
              id="email"
              className="form-control form-control-lg"
              placeholder="Email"
              required
            />
            <br />
            {
              // pass
            }
            <input
              type="password"
              title="password"
              id="password"
              className="form-control form-control-lg"
              placeholder="Password"
              required
            />
            <div className="text-center mt-4">
              <button name="submit" className="btn btn-success">
                Login
              </button>
            </div>
          </form>
        </div>
      </div>
    );
  }
}
export default Login;
