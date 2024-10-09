package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.User;

public interface UserService {
    
    //User return krega
    User saveUser(User user);
    
    //Check krna hai ki user exist krr rha hai yaa nhi:- Optional
    //alag se if wagera lagane ki jaroorat nhi padegi
    Optional<User> getUserById(String Id);
    Optional<User> updateUser(User user);

    void deleteUser(String id);

    boolean isUserExists(String userId);
    boolean isUserExistsByEmail(String email);

    List<User> getAllUser();

    //add more methods here related to User service[logic]

}
