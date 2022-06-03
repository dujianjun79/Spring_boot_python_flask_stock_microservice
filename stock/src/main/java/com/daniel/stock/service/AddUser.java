package com.daniel.stock.service;

import com.daniel.stock.Repository.UserRepository;
import com.daniel.stock.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class AddUser {

    private final UserRepository userRepository;

    public AddUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUpUser(User user){
        userRepository.save(user);
    }

}
