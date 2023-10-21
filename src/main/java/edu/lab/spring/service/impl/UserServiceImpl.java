package edu.lab.spring.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import edu.lab.spring.domain.model.User;
import edu.lab.spring.domain.repository.UserRepository;
import edu.lab.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("Este número de conta já existe");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    
}
