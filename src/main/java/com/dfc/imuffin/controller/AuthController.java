package com.dfc.imuffin.controller;

import com.dfc.imuffin.dto.*;
import com.dfc.imuffin.security.JwtTokenProvider;
import com.dfc.imuffin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="auth")
public class AuthController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserService userService;
    @RequestMapping(value="/signin",method= RequestMethod.POST)
    public ResponseEntity signin(@RequestBody AuthenticationDto authenticationDto){
        Map<Object,Object> model = new HashMap<>();
        UserDto userDto = userService.getUser(authenticationDto);
        String token = userService.loginUser(userDto);
        model.put("token", token);
        model.put("statusCode", "200");
        model.put("statusMessage", "Ok");
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @RequestMapping(value="/signup",method= RequestMethod.POST)
    public ResponseEntity signup(@RequestBody UserDto userDto){
        Map<Object,Object> model = new HashMap<>();
        userService.createUser(userDto);
        UserRoleDto userRoleDto = userService.getUserRole(userDto);
        String token = jwtTokenProvider.createToken(userDto.getUsername(),userRoleDto.getRoles());

        model.put("username",userDto.getUsername());
        model.put("token",token);
        model.put("statusCode","201");
        model.put("statusMessage","Created");

        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update",method= RequestMethod.PUT)
    public ResponseEntity update(@AuthenticationPrincipal UserDetails userDetails, @RequestBody UpdateUserDto updateUserDto){
        Map<Object,Object> model = new HashMap<>();
        userService.updateUser(userDetails,updateUserDto);
        model.put("statusCode", "200");
        model.put("statusMessage", "Ok");
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @RequestMapping(value="/delete",method= RequestMethod.DELETE)
    public ResponseEntity delete(@AuthenticationPrincipal UserDetails userDetails, @RequestBody PasswordDto passwordDto){
        Map<Object,Object> model = new HashMap<>();
        userService.deleteUser(userDetails,passwordDto);
        model.put("statusCode", "200");
        model.put("statusMessage", "Ok");
        return new ResponseEntity<>(model, HttpStatus.OK);
    }





}
