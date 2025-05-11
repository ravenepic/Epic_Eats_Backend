package com.epic.eats.portal.apis;

import com.epic.eats.portal.dtos.AuthRequest;
import com.epic.eats.portal.dtos.ResponseDTO;
import com.epic.eats.portal.dtos.SignUpRequest;
import com.epic.eats.portal.dtos.UserResponseDTO;
import com.epic.eats.portal.entities.UserEntity;
import com.epic.eats.portal.handlers.UsernameExist;
import com.epic.eats.portal.services.AuthenticationService;
import com.epic.eats.portal.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("users")
@Slf4j
public class AuthAPI {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public UserResponseDTO registerUser(@RequestBody SignUpRequest signUpRequest) throws UsernameExist {
        return this.userService.createUser(signUpRequest);
    }


    @PostMapping("/login")
    public ResponseDTO authenticateUser(@RequestBody AuthRequest authRequest){
        Authentication authentication = this.authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserEntity user =(UserEntity) authentication.getPrincipal();
        return ResponseDTO.builder()
                .token(this.authenticationService.generateToken(authentication))
                .username(user.getUsername())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @GetMapping("/validate")
    public Boolean validateToken(@RequestParam("token") String token) throws Exception {
        log.info("Entered validate token method at "+ LocalDateTime.now());
        return authenticationService.validateToken(token);
    }
}
