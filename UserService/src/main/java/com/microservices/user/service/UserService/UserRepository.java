package com.microservices.user.service.UserService;

import com.microservices.user.service.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>
{

    //if you want to implement any custom method or query
    //code here

}
