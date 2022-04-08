package com.javarunner.springrestvalidation.service;

import com.javarunner.springrestvalidation.dto.UserRequest;
import com.javarunner.springrestvalidation.entity.User;
import com.javarunner.springrestvalidation.exception.UserNotFoundException;
import com.javarunner.springrestvalidation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownServiceException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User saveUser(UserRequest userRequest){
        User user = User.build(0l,userRequest.getName(),userRequest.getEmail(),userRequest.getMobile(),userRequest.getGender(),userRequest.getAge(),userRequest.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long id) throws UserNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUserId(id));
        user.orElseThrow(() -> new UserNotFoundException("No user record found for the provided id: "+id));

        return user.get();
    }

}
