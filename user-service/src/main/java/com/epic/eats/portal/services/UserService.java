package com.epic.eats.portal.services;



import com.epic.eats.portal.dtos.SignUpRequest;
import com.epic.eats.portal.dtos.UserResponseDTO;

import com.epic.eats.portal.handlers.UsernameExist;

public interface UserService {
    UserResponseDTO createUser(SignUpRequest signUpRequest) throws UsernameExist;
}