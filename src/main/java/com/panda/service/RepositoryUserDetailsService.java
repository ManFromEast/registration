package com.panda.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.panda.repository.UserRepository;

public class RepositoryUserDetailsService implements UserDetailsService {

    private UserRepository repository;
    
    @Autowired
    public RepositoryUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }
    
}
