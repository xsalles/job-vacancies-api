package br.com.jobvacancies.main.job_vacancies.common.service;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.jobvacancies.main.job_vacancies.config.jwt.JwtConfig;

@Service
public class JwtService {
    @Autowired
    private JwtConfig jwtConfig;

    public String generateToken(UUID id, String name, String email) {
        Algorithm algorithm = Algorithm.HMAC256(jwtConfig.getSecret());

        return JWT.create().withIssuer("job-vacancies-api")
                .withExpiresAt(Instant.now().plus(Duration.ofHours(24)))
                .withSubject(id.toString())
                .withClaim("name", name)
                .withClaim("email", email)
                .sign(algorithm);
    }
}
