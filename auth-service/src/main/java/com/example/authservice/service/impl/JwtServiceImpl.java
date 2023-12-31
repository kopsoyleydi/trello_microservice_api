package com.example.authservice.service.impl;

import com.example.authservice.dto.RoleDto;
import com.example.authservice.dto.UserAuthInfo;
import com.example.authservice.service.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${mysecutirykey}")
    private String SECRET_KEY;
    @Override
    public String generateToken(UserAuthInfo user) {
        Map<String, String> roleList = new HashMap<>();
        roleList.put("role", user.getRole().getRoleName());
         return Jwts.builder().setClaims(roleList)
                 .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }
}
