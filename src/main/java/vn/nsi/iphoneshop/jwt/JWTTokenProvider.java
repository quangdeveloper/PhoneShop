package vn.nsi.iphoneshop.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import vn.nsi.iphoneshop.security.UserPrincipal;

import java.util.Date;

@Slf4j
@Component
public class JWTTokenProvider {


    //    static final long EXPIRATION_TIME = 3_600_000 * 24 * 30L;
//    static final String SECRET = "KYIVtA7915PUEWTqTca74sENpw48u7nkzSJiJmitF7D2PJWOu";
//    static final String PREFIX = "Bearer ";
//    static final String HEADER_STRING = "Authorization";

    @Value("${app.jwt.secret}")
    private String SECRET;

    @Value("${app.jwt.expriedTime}")
    private long EXPIRATION_TIME;

    public String generateToken(UserPrincipal userPrincipal) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
        return Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token).getBody();

        return Long.parseLong(claims.getSubject());
    }

    public Boolean validateToken(String token) {

        try {
            Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token);
            return true;

        } catch (MalformedJwtException ex1) {
            log.error("invalid jwt token");
        } catch (ExpiredJwtException ex2) {
            log.error("expirate time token");
        } catch (UnsupportedJwtException ex3) {
            log.error("unsuport jwt token");
        } catch (IllegalArgumentException ex4) {
            log.error("JWT claims  in token is empty");
        }
        return false;

    }
}
