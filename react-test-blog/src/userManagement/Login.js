import React, { Component } from "react";
import { login } from "../actions/userActions.js";
import { connect } from "react-redux";
import Dashboard from "../components/Dashboard.js";

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

  // componentDidMount() {
  //   this.props.history.push("/dashboard");
  // }
  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }
  onSubmit(e) {
    e.preventDefault();
    const LoginForm = {
      email: this.state.email,
      password: this.state.password,
    };
    this.props.login(LoginForm, this.props.history);
  }

  render() {
    return (
      <div className="col-md-6 m-auto">
        <div className="form-area ">
          <form onSubmit={this.onSubmit} role="form">
            <h2 className="text-center mb-4">Login </h2>
            {
              // email
            }
            <input
              type="email"
              name="email"
              className="form-control form-control-lg"
              placeholder="Email"
              required
              value={this.state.email}
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
              value={this.state.password}
              onChange={this.onChange}
            />
            <div className="text-center mt-4">
              <button name="submit" className="btn btn-success">
                Login
              </button>
            </div>
            {
              // <div className="text-center mt-4">
              //   <button name="submit" className="btn btn-primary">
              //     Logout
              //   </button>
              // </div>
            }
          </form>
        </div>
      </div>
    );
  }
}

const mapStateToProps = (state) => ({
  errors: state.errors,
});
export default connect(mapStateToProps, { login })(Login);
