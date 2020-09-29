import React, { Component } from "react";
import { login } from "../actions/UserActions.js";
import { connect } from "react-redux";
import PropTypes from "prop-types";

class Login extends Component {
  constructor() {
    super();
    this.state = {
      email: "",
      password: "",
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
    if (nextProps.security.validToken) {
      this.props.history.push("/dashboard");
    }

    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
  }

  onSubmit(e) {
    e.preventDefault();
    const LoginForm = {
      email: this.state.email,
      password: this.state.password,
    };
    this.props.login(LoginForm, this.props.history);
  }
  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  render() {
    return (
      <div className="col-md-6 m-auto">
        <div className="form-area ">
          <form onSubmit={this.onSubmit} role="form">
            <h2 className="text-center mb-4">Login </h2>

            <input
              type="text"
              name="email"
              className="form-control form-control-lg"
              placeholder="Email"
              required
              value={this.state.email}
              onChange={this.onChange}
            />
            <br />

            <input
              type="password"
              name="password"
              className="form-control form-control-lg"
              placeholder="Password"
              required
              value={this.state.password}
              onChange={this.onChange}
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

Login.propTypes = {
  login: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired,
  security: PropTypes.object.isRequired,
};

const mapStateToProps = (state) => ({
  security: state.security,
  errors: state.errors,
});
export default connect(mapStateToProps, { login })(Login);
