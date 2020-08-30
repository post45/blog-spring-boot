import React, { Component } from "react";

class AddPost extends Component {
  constructor() {
    super();

    this.state = {
      title: "",
      body: "",
      createdBy: "",
      createDate: "",
      updateDate: "",
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }
  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }
  onSubmit(e) {
    e.preventDefault();
    const AddPost = {
      title: this.state.title,
      body: this.state.body,
      createdBy: this.state.createdBy,
      createDate: this.state.createDate,
      updateDate: this.state.updateDate,
    };
    console.log(AddPost);
  }

  render() {
    return (
      <div className="col-md-8 m-auto">
        <div className="form-area ">
          <form role="form ">
            <h2 className="text-center">Create Post </h2>
            <br styles="clear:both" />
            <div className="form-group ">
              <input
                type="text"
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
                type="textarea"
                id="body"
                name="body"
                placeholder="Body"
                maxlength="1400"
                rows="7"
                value={this.state.body}
                onChange={this.onChange}
              ></textarea>
            </div>

            {
              // createdBy
            }

            <div className="form-group ">
              <input
                type="text"
                className="form-control form-control-lg"
                id="created By"
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

            <button
              type="button"
              id="submit"
              name="submit"
              className="btn btn-success pull-right"
            >
              Post
            </button>
          </form>
        </div>
      </div>
    );
  }
}
export default AddPost;
