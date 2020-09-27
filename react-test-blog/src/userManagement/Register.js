import React, { Component } from "react";
import { register } from "../actions/UserActions.js";
import { connect } from "react-redux";
import PropTypes from "prop-types";

class Register extends Component {
  constructor() {
    super();
    this.state = {
      firstName: "",
      lastName: "",
      email: "",
      password: "",
      confirmPassword: "",
      errors: {},
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }
  componentDidMount() {
    if (this.props.security.validToken) {
      this.props.history.push("/dashboard");
    }
  }
  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }
  onSubmit(e) {
    e.preventDefault();
    const registerForm = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      email: this.state.email,
      password: this.state.password,
      confirmPassword: this.state.confirmPassword,
    };
    this.props.register(registerForm, this.props.history);
  }

  render() {
    const { errors } = this.state;
    return (
      <div className="col-md-6 m-auto">
        <div className="form-area ">
          <form onSubmit={this.onSubmit} role="form">
            <h2 className="text-center mb-4">Sign Up </h2>

            <input
              type="firstName"
              name="firstName"
              className="form-control form-control-lg"
              placeholder="First Name"
              required
              value={this.state.firstName}
              onChange={this.onChange}
            />
            <br />

            <input
              type="lastName"
              name="lastName"
              className="form-control form-control-lg"
              placeholder="Last Name"
              required
              value={this.state.lastName}
              onChange={this.onChange}
            />
            <br />

            <input
              type="email"
              name="email"
              className="form-control form-control-lg"
              placeholder="Your email"
              required
              value={this.state.email}
              onChange={this.onChange}
            />
            <br />

            <input
              type="password"
              name="password"
              className="form-control form-control-lg"
              placeholder="Password must be at list 6 char"
              required
              value={this.state.password}
              onChange={this.onChange}
            />
            <br />

            <input
              type="password"
              name="confirmPassword"
              className="form-control form-control-lg"
              placeholder="Confirm Password"
              required
              value={this.state.confirmPassword}
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
Register.propTypes = {
  register: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired,
  security: PropTypes.object.isRequired,
};
const mapStateToProps = (state) => ({
  errors: state.errors,
  security: state.security,
});
export default connect(mapStateToProps, { register })(Register);
