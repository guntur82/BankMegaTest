package com.megatest.controller;

import com.megatest.dto.JwtResponseDTO;
import com.megatest.dto.RegisterDTO;
import com.megatest.dto.RequestJwtDTO;
import com.megatest.security.JwtManager;
import com.megatest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtManager jwtManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody RequestJwtDTO dto) {
        try {
            var springSecurityToken = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
            authenticationManager.authenticate(springSecurityToken);

            var userDetails = userDetailsService.loadUserByUsername(dto.getUsername());
            String jwtToken = jwtManager.generateToken(dto.getUsername(),"bankmega");

            JwtResponseDTO responseDTO = new JwtResponseDTO(true,"Succesfully Login",jwtToken, dto.getUsername());
            return ResponseEntity.status(200).body(responseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Object> post(@Valid @RequestBody RegisterDTO dto) {
        try {
            var insertedEntity = userService.registerAccount(dto);
            return ResponseEntity.status(201).body("Success");
        } catch (Exception exception) {
            return ResponseEntity.status(500).body(exception.getMessage());
        }
    }
}
