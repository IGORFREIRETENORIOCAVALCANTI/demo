package com.poo.aula.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.aula.model.User;
import com.poo.aula.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public void insertUser(User u)
    {
        userRepository.save(u);
    }

    public void deletUser(User u)
    {
        userRepository.delete(u);
    }

    public boolean deleteUserById(Long id)
    {
        Optional<User> opUser = userRepository.findById(id);

        if(opUser.isEmpty())
        {
            return false;
        }

        User u = opUser.get();
        userRepository.delete(u);

        return true;
    }

    
}
