package com.dfc.imuffin.service;

import com.dfc.imuffin.dao.RecipeDao;
import com.dfc.imuffin.dto.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import javax.jws.soap.SOAPBinding;

public interface UserService {

    void createUser(UserDto userDto);

    void deleteUser(UserDetails userDetails, PasswordDto passwordDto);

    void updateUser(UserDetails userDetails, UpdateUserDto updateUserDto);

    void addSkiValleyToFavorite(UserDetails userDetails,SkiValleyDao skiValleyDao);

    UserDto getUser(AuthenticationDto authenticationDto);

    UserDto getUserByToken(UserDetails userDetails);

    UserRoleDto getUserRole(UserDto userDto);

    String loginUser(UserDto userDto);


}