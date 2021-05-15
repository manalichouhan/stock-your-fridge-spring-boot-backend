package com.stockyourfridge.stockyourfridge.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtProvider {
	
	private String SECRET_KEY = "secret-Key";

	@Value("${jwt.expiration.time}")
	private Long jwtExpirationInMillis;
	
   
	public String generateToken(Authentication authentication ) {
		User principal = (User) authentication.getPrincipal();
		
		Map<String, Object> claims = new HashMap<>();
		 return Jwts.builder().setClaims(claims).setSubject(principal.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + getJwtExpirationInMillis()))
	                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}
	
	public Long getJwtExpirationInMillis() {
        return jwtExpirationInMillis;
    }
	
	public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	}

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
	    
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

	
}
