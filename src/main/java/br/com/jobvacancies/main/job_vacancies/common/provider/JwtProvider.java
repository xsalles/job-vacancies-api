package br.com.jobvacancies.main.job_vacancies.common.provider;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.jobvacancies.main.job_vacancies.config.jwt.JwtConfig;

@Service
public class JwtProvider {
    @Autowired
    private JwtConfig jwtConfig;

    public String generateToken(UUID id, String name, String email, String role) {
        Algorithm algorithm = Algorithm.HMAC256(jwtConfig.getSecret());

        return JWT.create().withIssuer("job-vacancies-api")
                .withExpiresAt(Instant.now().plus(Duration.ofHours(24)))
                .withSubject(id.toString())
                .withClaim("name", name)
                .withClaim("email", email)
                .withClaim("role", role)
                .sign(algorithm);
    }

    public String validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(jwtConfig.getSecret());

        token = token.replace("Bearer ", "");

        try {
            var subject = JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();

            return subject;
        } catch (JWTVerificationException ex) {
            ex.printStackTrace();
            return "";
        }
    }

}
