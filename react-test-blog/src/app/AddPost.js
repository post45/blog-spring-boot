import React, { Component } from "react";

class AddPost extends Component {
  render() {
    return (
      <div className="col-md-5">
        <div className="form-area">
          <form role="form">
            <br styles="clear:both" />
            <div className="form-group">
              <input
                type="text"
                className="form-control"
                id="title"
                name="title"
                placeholder="Title"
                required
              />
            </div>

            <div className="form-group">
              <textarea
                className="form-control"
                type="textarea"
                id="subject"
                placeholder="Subject"
                maxlength="140"
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