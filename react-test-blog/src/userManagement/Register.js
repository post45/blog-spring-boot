import React, { Component } from "react";

class Register extends Component {
  constructor() {
    super();
    this.state = {
      firstName: "",
      lastName: "",
      email: "",
      password: "",
      confirmPassword: "",
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }
  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }
  onSubmit(e) {
    e.preventDefault();
    const newUser = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      password: this.state.password,
      confirmPassword: this.state.confirmPassword,
    };
  }

  render() {
    return (
      <div className="col-md-6 m-auto">
        <div className="form-area ">
          <form role="form">
            <h2 className="text-center mb-4">Sign Up </h2>
            {
              // firstName
            }
            <input
              type="firstName"
              name="firstName"
              className="form-control form-control-lg"
              placeholder="First Name"
              required
              value={this.state.username}
              onChange={this.onChange}
            />
            <br />
            {
              // lastName
            }
            <input
              type="lastName"
              name="lastName"
              className="form-control form-control-lg"
              placeholder="Last Name"
              required
              value={this.state.username}
              onChange={this.onChange}
            />
            <br />

            {
              // email
            }
            <input
              type="email"
              name="emal"
              className="form-control form-control-lg"
              placeholder="Your email"
              required
              value={this.state.username}
              onChange={this.onChange}
            />
            <br />
            {
              // pass
            }
            <input
              type="password"
              name="password"
              className="form-control form-control-lg"
              placeholder="Password"
              required
              value={this.state.username}
              onChange={this.onChange}
            />
            <br />
            {
              // confirm pass
            }
            <input
              type="confirmPassword"
              name="confirmPassword"
              className="form-control form-control-lg"
              placeholder="Confirm Password"
              required
              value={this.state.username}
              onChange={this.onChange}
            />
            <br />

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
