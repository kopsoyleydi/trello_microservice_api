package com.example.apigateway.service.impl;

import com.example.apigateway.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    @Value("${mysecutirykey}")
    private String SECRET_KEY;

    public String extractEmail(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    @Override
    public boolean validateToken(String jwt, String comparedJwtInRedis) {
        final String email = extractEmail(jwt);
        final String role = extractRole(jwt);

        return email.equals(extractEmail(comparedJwtInRedis))
                && role.equals(extractRole(comparedJwtInRedis))
                && !isTokenExpired(jwt);
    }

    public String extractRole(String jwt) {
        return extractClaim(jwt, c -> c.get("role", String.class));
    }


    private <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(jwt);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    private boolean isTokenExpired(String jwt) {
        return extractExpiration(jwt).before(new Date());
    }

    private Date extractExpiration(String jwt) {
        return extractClaim(jwt, Claims::getExpiration);
    }

}
