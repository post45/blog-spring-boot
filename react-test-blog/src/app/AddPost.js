import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createPost } from "../actions/UserActions";

class AddPost extends Component {
  constructor() {
    super();
    this.state = {
      title: "",
      body: "",
      createdBy: "",
      createDate: "",
      updateDate: "",
      errors: {},
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  // componentWillReceiveProps(nextProps) {
  //   if (nextProps.errors) {
  //     this.setState({ errors: nextProps.errors });
  //   }
  // }
  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }
  onSubmit(e) {
    e.preventDefault();
    const newPost = {
      title: this.state.title,
      body: this.state.body,
      createdBy: this.state.createdBy,
      createDate: this.state.createDate,
      updateDate: this.state.updateDate,
    };

    this.props.createPost(newPost, this.props.history);
  }

  render() {
    return (
      <div className="col-md-8 m-auto">
        <div className="form-area ">
          <form onSubmit={this.onSubmit} role="form ">
            <h2 className="text-center">Create Post </h2>
            <br styles="clear:both" />
            <div className="form-group ">
              <input
                type="title"
                className="form-control form-control-lg "
                id="title"
                name="title"
                value={this.state.title}
                onChange={this.onChange}
                placeholder="Title"
                required
              />
            </div>

            <div className="form-group ">
              <textarea
                className="form-control"
                type="body"
                name="body"
                placeholder="Body"
                maxlength="1400"
                rows="7"
                required
                value={this.state.body}
                onChange={this.onChange}
              ></textarea>
            </div>

            {
              // createdBy
            }

            <div className="form-group ">
              <input
                type="createdBy"
                className="form-control form-control-lg"
                name="createdBy"
                value={this.state.createdBy}
                onChange={this.onChange}
                placeholder="Created By"
                required
              />
            </div>

            {
              // createdBy
            }
            <h6>Create Date</h6>
            <div className="form-group">
              <input
                type="date"
                className="form-control form-control-lg"
                name="createDate"
                value={this.state.createDate}
                onChange={this.onChange}
              />
            </div>
            <h6>Estimated Update Date</h6>
            <div className="form-group">
              <input
                type="date"
                className="form-control form-control-lg"
                name="updateDate"
                value={this.state.updateDate}
                onChange={this.onChange}
              />
            </div>
            <div className="text-center mt-4">
              <button name="submit" className="btn btn-success">
                Post
              </button>
            </div>
          </form>
        </div>
      </div>
    );
  }
}

AddPost.propTypes = {
  createPost: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired,
};
const mapStateToProps = (state) => ({
  errors: state.errors,
});

export default connect(mapStateToProps, { createPost })(AddPost);
