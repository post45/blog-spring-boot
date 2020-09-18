package com.arthur.blog.exceptions;

public class PostIdExceptionResponse {

    private String postIdentifier;

    public PostIdExceptionResponse(String posttIdentifier) {
        this.postIdentifier = posttIdentifier;
    }

    public String getPostIdentifier() {
        return postIdentifier;
    }

    public void setPostIdentifier(String postIdentifier) {
        this.postIdentifier = postIdentifier;
    }
}