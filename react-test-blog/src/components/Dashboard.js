import React, { Component } from "react";
import { connect } from "react-redux";
import { getPostsForUser } from "../actions/userActions";

class Dashboard extends Component {
  componentDidMount() {
    this.props.getPostsForUser(10);
  }
  render() {
    return (
      <div className="posts">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h3 className=" text-center">Blog</h3>
              <br />
              {
                //
              }
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default connect(null, { getPostsForUser })(Dashboard);
