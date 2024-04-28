package com.example.bookmyshow.controllers;

import com.example.bookmyshow.Dto.UserRequestDto;
import com.example.bookmyshow.Dto.UserResponseDto;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.models.Userstatus;
import com.example.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }
    UserResponseDto signUp(UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = new UserResponseDto();
        try{
            String email = userRequestDto.getEmail();
            String password = userRequestDto.getPassword();
            User user = userService.signUp(email, password);
            userResponseDto.setUserId(user.getId());
            userResponseDto.setUserstatus(Userstatus.SUCCESS);
        }catch(Exception e){
            userResponseDto.setUserstatus(Userstatus.FAILURE);
        }
        return userResponseDto;
    }
}
