package edu.lab.spring.service;

import edu.lab.spring.domain.model.User;

public interface UserService {
    
    User findById(Long id);

    User create(User userToCreate);
}
