package com.dfc.imuffin.service;

import com.dfc.imuffin.dto.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    void createUser(UserDto userDto);

    void deleteUser(UserDetails userDetails, PasswordDto passwordDto);

    void updateUser(UserDetails userDetails, UpdateUserDto updateUserDto);

    UserDto getUser(AuthenticationDto authenticationDto);

    UserDto getUserByToken(UserDetails userDetails);

    UserRoleDto getUserRole(UserDto userDto);

    String loginUser(UserDto userDto);

    @Transactional
    void addFavorite(UserDto userDto, Long skiValleyId);

    @Transactional
    List<RecipeDto> getFavorites(UserDto userDto);


    @Transactional
    void deleteFromFavorite(UserDto userDto, Long skiValleyId);

}
