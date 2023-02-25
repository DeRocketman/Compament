package de.compament.backendrestapi.authentication.service;

import de.compament.backendrestapi.authentication.dto.SignInRequestDto;
import de.compament.backendrestapi.authentication.dto.SignInResponseDto;
import de.compament.backendrestapi.authentication.dto.SignUpRequestDto;
import de.compament.backendrestapi.authentication.dto.SignUpResponseDto;
import de.compament.backendrestapi.authentication.material.Role;
import de.compament.backendrestapi.authentication.material.User;
import de.compament.backendrestapi.authentication.repository.UserRepository;
import de.compament.backendrestapi.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationApplicationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public SignUpResponseDto signUp(SignUpRequestDto request) {
        Optional<User> checkMailInUse = repository.findByEmail(request.getEmail());
        if (checkMailInUse.isEmpty()) {
            var user = User.builder()
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .role(Role.PLAYER_ROLE)
                    .build();
            repository.save(user);

            return SignUpResponseDto.builder()
                    .responseText("Benutzer erfolgreich erstellt")
                    .build();
        } else {
            return SignUpResponseDto.builder()
                    .responseText("E-Mail-Adresse wird bereits verwendet")
                    .build();
        }
    }

    public SignInResponseDto signIn(SignInRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return SignInResponseDto.builder()
                .token(jwtToken)
                .build();
    }

}
