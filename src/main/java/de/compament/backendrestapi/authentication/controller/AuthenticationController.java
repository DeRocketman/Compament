package de.compament.backendrestapi.authentication.controller;

import de.compament.backendrestapi.authentication.dto.SignInRequestDto;
import de.compament.backendrestapi.authentication.dto.SignInResponseDto;
import de.compament.backendrestapi.authentication.dto.SignUpRequestDto;
import de.compament.backendrestapi.authentication.dto.SignUpResponseDto;
import de.compament.backendrestapi.authentication.service.AuthenticationApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationApplicationService service;

    @PostMapping("/sign-up")
    public ResponseEntity<SignUpResponseDto> register(
            @RequestBody SignUpRequestDto requestDto
    ) {
        return ResponseEntity.ok(service.signUp(requestDto));
    }
    @PostMapping("/sign-in")
    public ResponseEntity<SignInResponseDto> authenticate(
            @RequestBody SignInRequestDto requestDto
    ) {
        return ResponseEntity.ok(service.signIn(requestDto));
    }
}
