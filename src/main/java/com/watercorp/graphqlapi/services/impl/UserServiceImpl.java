package com.watercorp.graphqlapi.services.impl;

import com.watercorp.graphqlapi.models.User;
import com.watercorp.graphqlapi.repositories.UserRepository;
import com.watercorp.graphqlapi.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return (ArrayList) userRepository.findAll();
    }

    @Override
    public User findOneById(ObjectId id) {
        return userRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<User> findByIdIn(List<String> ids) {
        return userRepository.findByIdIn(ids);
    }
}
