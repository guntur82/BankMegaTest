package com.megatest.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtManager {
    private final String SECRET_KEY = "bankmega";

    public String generateToken(String username, String secretKey) {
        JwtBuilder builder = Jwts.builder();
        builder.setIssuer("http://localhost:5060")
                .claim("username", username)
                .signWith(SignatureAlgorithm.HS256,secretKey);
        return builder.compact();
    }

    private Claims getClaimFromToken(String token){
        JwtParser parser = Jwts.parser().setSigningKey(SECRET_KEY);
        Jws<Claims> signatureAndClaims = parser.parseClaimsJws(token);
        Claims claims = signatureAndClaims.getBody();
        return claims;
    }

    public String getUsernameByToken(String token){
        Claims claims = getClaimFromToken(token);
        String username = claims.get("username", String.class);
        return username;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsernameByToken(token);
        Boolean isMatch = username.equals(userDetails.getUsername());
        return isMatch;
    }
}
