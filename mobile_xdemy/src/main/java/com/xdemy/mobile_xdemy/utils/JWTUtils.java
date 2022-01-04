package com.xdemy.mobile_xdemy.utils;

import com.xdemy.mobile_xdemy.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

//generated token can be decrypted by base64 to show plaintext information
public class JWTUtils {

    //expire time for 7 day in ms
    private static final long EXPIRE = 60000 * 60 * 24 * 7;

    //secret key
    private static final String SECRET_KEY = "xdemy.666";

    //token prefix
    private static final String TOKEN_PREFIX = "xdemy";

    //subject
    private static final String SUBJECT = "xdemy";

    //generate token by user info
    public static String jsonWebToken(User user){
        String token = Jwts.builder().setSubject(SUBJECT)
                        .claim("head_img", user.getHeadImg())
                        .claim("id", user.getId())
                        .claim("name", user.getName())
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
        token = TOKEN_PREFIX + token;
        return token;
    }

    //verify token, if token expired or key does not match vertify failed
    public static Claims checkJWT(String token){
        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).
                    parseClaimsJws(token.replace(TOKEN_PREFIX, "")).
                    getBody();
            return claims;
        }catch(Exception e){
            return null;
        }
    }

}
