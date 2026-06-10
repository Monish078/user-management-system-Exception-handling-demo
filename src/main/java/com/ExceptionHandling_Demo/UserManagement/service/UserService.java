package com.ExceptionHandling_Demo.UserManagement.service;

import com.ExceptionHandling_Demo.UserManagement.entity.UserEntity;
import com.ExceptionHandling_Demo.UserManagement.exception.EmailAlreadyExistsException;
import com.ExceptionHandling_Demo.UserManagement.exception.UserNotFoundException;
import com.ExceptionHandling_Demo.UserManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;


    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // id se user find
    public UserEntity getUserById(Long id) {
        // check karo user hai ya nhi
        UserEntity user = userRepository.findById(id) // nhi to costume exception message bhej do jo banaya hai humne
                .orElseThrow(() -> new UserNotFoundException("User not found! id: " + id)
                );
        return user;
    }


    public UserEntity addUser(UserEntity user) {
        // check karo ki is email pehle to use nhi ho rakhi
        if(userRepository.existsByEmail(user.getEmail())) {
            // agar email pehle  se hai to , exception throw kardo
            throw new EmailAlreadyExistsException("Email already exist");
        }
        return userRepository.save(user);
    }

    // user delete karme ka logic
    public void deleteUserById(Long id) {
        // check karo user hai ya nhi
        UserEntity user = userRepository.findById(id) // nhi to costume exception message bhej do jo banaya hai humne
                .orElseThrow(() -> new UserNotFoundException("User not found! id: " + id)
                );
        // ya delete kardo


         userRepository.deleteById(id);
    }
}
