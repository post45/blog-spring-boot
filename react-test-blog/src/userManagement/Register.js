import React, { Component } from "react";

class Register extends Component {
  render() {
    return (
      <div className="col-md-6 m-auto">
        <div className="form-area ">
          <form role="form">
            <h2 className="text-center mb-4">Sign Up Please</h2>
            {
              // firstName
            }
            <input
              type="firstName"
              title="firstName"
              id="firstName"
              className="form-control form-control-lg"
              placeholder="First Name"
              required
            />
            <br />
            {
              // lastName
            }
            <input
              type="lastName"
              title="lastName"
              id="lastName"
              className="form-control form-control-lg"
              placeholder="Last Name"
              required
            />
            <br />

            {
              // email
            }
            <input
              type="email"
              title="email"
              id="emal"
              className="form-control form-control-lg"
              placeholder="Your email"
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
            <br />
            {
              // confirm pass
            }
            <input
              type="confirmPassword"
              title="confirmPassword"
              id="confirmPassword"
              className="form-control form-control-lg"
              placeholder="Confirm Password"
              required
            />
            <br />
            {
              // Date
            }
            <h6>Create Date</h6>
            <div className="form-group">
              <input
                type="date"
                className="form-control form-control-lg"
                name="createDate"
              />
            </div>
            <h6>Estimated Update Date</h6>
            <div className="form-group">
              <input
                type="date"
                className="form-control form-control-lg"
                name="updateDate"
              />
            </div>
            {
              // Date
            }
            <div className="text-center mt-4">
              <button name="submit" className="btn btn-success">
                Register
              </button>
            </div>
          </form>
        </div>
      </div>
    );
  }
}
export default Register;
