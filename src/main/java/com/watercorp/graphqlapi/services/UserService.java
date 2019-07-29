package com.watercorp.graphqlapi.services;

import com.watercorp.graphqlapi.models.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    User findOneById(ObjectId id);
    List<User> findByIdIn(List<String> ids);
}
