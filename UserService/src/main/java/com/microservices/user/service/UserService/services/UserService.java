package com.microservices.user.service.UserService.services;

import com.microservices.user.service.UserService.entities.User;

import java.util.List;

public interface UserService {

    //user ops

    //create
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single User as per Id
    User getUser(String userId);

    //TODO: delete,update
}
