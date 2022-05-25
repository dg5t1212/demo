package com.example.demo.utils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTUtils {
	

	private static Long TOKEN_EXPIRY_TIME = Long.valueOf(6000000L);

	private static String KEY = "TASAMENGTASAMENGTASAMENGTASAMENGTASAMENGTASAMENGTASAMENGTASAMENGTASAMENGTASAMENGTASAMENG";

	public static String generateToken(String username) {
		
		SecretKey key = Keys.hmacShaKeyFor(KEY.getBytes(StandardCharsets.UTF_8));
		Date expiryTime = new Date(System.currentTimeMillis() + TOKEN_EXPIRY_TIME.longValue());
		String token = Jwts.builder()
				.setSubject(username)
				.setExpiration(expiryTime)
				.signWith(key)
				.compact();
		return token;
	}
	
	public static String parserToken(String token){
		
		SecretKey key = Keys.hmacShaKeyFor(KEY.getBytes(StandardCharsets.UTF_8));
		Claims claims = Jwts.parserBuilder()
							.setSigningKey(key)
							.build()
							.parseClaimsJws(token)
							.getBody();
		return String.valueOf(claims.getSubject());
	}
	
	public static void main(String[] args) {
		String token = JWTUtils.generateToken("user");
		System.out.println(token);
		token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjUyOTU4MjUxfQ.oUejXt_BuNAnUPBMQwZY1wwqYprtuy1nekz1hSCeYpUp3zto9OizHovpZXIueX4OlCYovFzY3aYTs_OBtkUpsA";
		String user = JWTUtils.parserToken(token);
		System.out.println(user);
	}
}
