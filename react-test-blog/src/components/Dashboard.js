import React, { Component } from "react";
import { connect } from "react-redux";
import { getPostsForUser } from "../actions/UserActions";
import PropTypes from "prop-types";
import PostItem from "../app/PostItem";

class Dashboard extends Component {
  componentDidMount() {
    this.props.getPostsForUser();
  }
  render() {
    const { blogPosts } = this.props.blogPost;
    return (
      <div className="blogPost">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h3 className=" text-center">Blog</h3>
              <br />

              <hr />
              <PostItem />
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
Dashboard.propTypes = {
  blogPost: PropTypes.object.isRequired,
  getPostsForUser: PropTypes.func.isRequired,
};

const mapStateToProps = (state) => ({
  blogPost: state.blogPost,
});

export default connect(mapStateToProps, { getPostsForUser })(Dashboard);
