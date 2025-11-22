package com.balaji.finance.config.util;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private final Key key;
	private final long expiration = 3600000; // 1 hour (optional constant)

	public JwtUtil() {
		// Automatically generate a secure 256-bit HS256 key
		this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

		// Optional: print key (for debugging)
		String base64Key = Encoders.BASE64.encode(key.getEncoded());
		System.out.println("Generated JWT Signing Key: " + base64Key);
	}

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expiration)).signWith(key).compact();
	}

	public boolean validateToken(String token) {
		try {
			extractAllClaims(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String extractUsername(String token) {
		return extractAllClaims(token).getSubject();
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}
}
