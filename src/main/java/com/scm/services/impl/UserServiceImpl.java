package com.scm.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.services.UserService;

@Service //taaki spring samajh jaaye ki ye ek service hai and uska object pehle se create krrle 
public class UserServiceImpl implements UserService {

    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveUser'");
    }

    @Override
    public Optional<User> getUserById(String Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public Optional<User> updateUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public boolean isUserExists(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isUserExists'");
    }

    @Override
    public boolean isUserExistsByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isUserExistsByEmail'");
    }

    @Override
    public List<User> getAllUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUser'");
    }

}
