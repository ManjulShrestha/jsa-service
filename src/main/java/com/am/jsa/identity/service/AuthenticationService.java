package com.am.jsa.identity.service;

import com.am.jsa.common.SHAHash;
import com.am.jsa.identity.entity.User;
import com.am.jsa.identity.repository.UserRepository;
import com.am.jsa.logger.AmLogger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
    private String secretKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ5Y28iLCJuYW1lIjoiZG90IiwiYWRtaW4iOnRydWV9.BWbQ03_LTu8_fpX1CU0cKEiD_l3_KQnIwc5pViMu4h4";
    private long tokenLife = 3600000;

    @Autowired
    private UserRepository userRepository;

    public User challenge(User user) {
        System.out.println(SHAHash.hashPassword(user.getPassword()));
        User challengingUser = userRepository.validateUser(user.getUserName(), SHAHash.hashPassword(user.getPassword()));
        if (challengingUser == null)
            return null;
        challengingUser.setToken(generateToken(String.valueOf(challengingUser.getId()),
                "division-", "", tokenLife));
        return challengingUser;
    }

    public User verifyToken(String token) {
        try{
            Claims claims = parseJWT(token);
            if((new Date()).before(claims.getExpiration())){
                // means the token has not yet expired
                User user = userRepository.getOne(Long.valueOf(claims.getId()));
                //user.setToken(token);
                return user;
            } else
                AmLogger.printData("Token Expired");
                return null;
        } catch(Exception ex){
            AmLogger.printData("token invalid or expired");
            // invalid token
            // log the action here
            // as invalid token never should be passed via application, only expired ones are allowed
        }

        return null;
    }

    private String generateToken(String id, String issuer, String subject, long ttlMillis) {

        // The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        // if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        // Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public Claims parseJWT(String jwt) {
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey)).parseClaimsJws(jwt)
                .getBody();

    }
}
