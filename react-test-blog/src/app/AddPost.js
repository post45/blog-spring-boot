import React, { Component } from "react";

class AddPost extends Component {
  render() {
    return (
      <div className="col-md-8 ">
        <div className="form-area ">
          <form role="form ">
            <h2 className="text-left">Create Post form</h2>
            <br styles="clear:both" />
            <div className="form-group ">
              <input
                type="text"
                className="form-control "
                id="title"
                name="title"
                placeholder="Title"
                required
              />
            </div>

            <div className="form-group ">
              <textarea
                className="form-control"
                type="textarea"
                id="body"
                placeholder="Body"
                maxlength="1400"
                rows="7"
              ></textarea>
            </div>

            <button
              type="button"
              id="submit"
              name="submit"
              className="btn btn-primary pull-right"
            >
              Add Post
            </button>
          </form>
        </div>
      </div>
    );
  }
}
export default AddPost;
