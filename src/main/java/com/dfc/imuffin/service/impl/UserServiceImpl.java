package com.dfc.imuffin.service.impl;

import com.dfc.imuffin.dao.UserDao;
import com.dfc.imuffin.dao.UserRoleDao;
import com.dfc.imuffin.dto.*;
import com.dfc.imuffin.repository.RecipeRepository;
import com.dfc.imuffin.repository.UserRepository;
import com.dfc.imuffin.repository.UserRoleRepository;
import com.dfc.imuffin.security.JwtTokenProvider;
import com.dfc.imuffin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RecipeRepository recipeRepository;
    @Override
    public void createUser(UserDto userDto) {
        UserDao userDao = new UserDao(userDto.getEmail(),userDto.getUsername(),passwordEncoder.encode(userDto.getPassword()));
        userDao = userRepository.save(userDao);

        UserRoleDao userRoleDao = new UserRoleDao(userDao.getId(),"ROLE_USER");
        userRoleRepository.save(userRoleDao);
    }

    @Override
    public void deleteUser(UserDetails userDetails, PasswordDto passwordDto) {
        UserDao userDao = userRepository.findByUsername(userDetails.getUsername()).get();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDao.getUsername(),passwordDto.getPassword()));
        userRepository.deleteUserById(userDao.getId());
    }

    @Override
    public void updateUser(UserDetails userDetails, UpdateUserDto updateUserDto) {
        UserDao userDao = userRepository.findByUsername(userDetails.getUsername()).get();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDao.getUsername(),updateUserDto.getPassword().getPassword()));
        userRepository.updateUserById(updateUserDto.getUser().getEmail(),updateUserDto.getUser().getUsername(),passwordEncoder.encode(updateUserDto.getUser().getPassword()),userDao.getId());
    }

    @Override
    public UserDto getUser(AuthenticationDto authenticationDto) {
        boolean emailInDatabase = userRepository.findByEmail(authenticationDto.getUsernameOrEmail()).isPresent();
        boolean usernameInDatabase = userRepository.findByUsername(authenticationDto.getUsernameOrEmail()).isPresent();
        UserDao userDao;
        if(emailInDatabase){
            userDao = userRepository.findByEmail(authenticationDto.getUsernameOrEmail()).get();
        }else{
            userDao = userRepository.findByUsername(authenticationDto.getUsernameOrEmail()).get();
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDao.getUsername(),authenticationDto.getPassword()));
        UserDto userDto = new UserDto();
        userDto.setEmail(userDao.getEmail());
        userDto.setPassword(userDao.getPassword());
        userDto.setId(userDao.getId());
        userDto.setUsername(userDao.getUsername());

        return userDto;
    }

    @Override
    public UserDto getUserByToken(UserDetails userDetails) {
        UserDao userDao;
        UserDto userDto = new UserDto();
        userDao = userRepository.findByUsername(userDetails.getUsername()).get();
        userDto.setEmail(userDao.getEmail());
        userDto.setUsername(userDao.getUsername());
        userDto.setPassword(userDao.getPassword());
        userDto.setId(userDao.getId());
        return userDto;
    }

    @Override
    public UserRoleDto getUserRole(UserDto userDto) {
        UserDao userDao = userRepository.findByUsername(userDto.getUsername()).get();
        UserRoleDto userRoleDto = new UserRoleDto();
        List<String> roles = new ArrayList<>();
        UserRoleDao userRoleDao = this.userRoleRepository.findById(userDao.getId()).get();
        roles.add(userRoleDao.getNameRole());
        userRoleDto.setRoles(roles);
        return userRoleDto;
    }

    @Override
    public String loginUser(UserDto userDto) {
        return jwtTokenProvider.createToken(userDto.getUsername(),getUserRole(userDto).getRoles());
    }
}