package com.arthur.blog.security;

public class SecurityConst {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADERS_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 300_000; //5min
}
