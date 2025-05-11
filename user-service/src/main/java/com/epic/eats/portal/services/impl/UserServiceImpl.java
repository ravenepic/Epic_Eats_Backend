package com.epic.eats.portal.services.impl;

import com.epic.eats.portal.dtos.SignUpRequest;
import com.epic.eats.portal.dtos.UserResponseDTO;
import com.epic.eats.portal.entities.RoleEntity;
import com.epic.eats.portal.entities.UserEntity;
import com.epic.eats.portal.handlers.UsernameExist;
import com.epic.eats.portal.repositories.UserRepository;
import com.epic.eats.portal.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO createUser(SignUpRequest signUpRequest) throws UsernameExist {
        Optional<UserEntity> byUsername = this.userRepository.findByUsername(signUpRequest.getUsername());
        if(byUsername.isPresent()){
            throw new UsernameExist("username already exist : '"+signUpRequest.getUsername()+"'");
        }else{
            UserResponseDTO userResponseDTO=new UserResponseDTO();
            List<RoleEntity> rolesList=new ArrayList<>();
            for(String rolesStr:signUpRequest.getRoles()){
                rolesList.add(new RoleEntity(rolesStr));
            }
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(signUpRequest.getUsername());
            userEntity.setCreate_at(LocalDateTime.now());
            userEntity.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
            userEntity.setRoles(rolesList);
            this.userRepository.save(userEntity);
            userResponseDTO.setMessage("user created successfully");
            return userResponseDTO;
        }}
}