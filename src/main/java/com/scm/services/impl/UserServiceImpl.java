package com.scm.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.helpers.ResourceNotFoundException;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;

@Service //taaki spring samajh jaaye ki ye ek service hai and uska object pehle se create krrle 
public class UserServiceImpl implements UserService {

    //in sb ko db mein save krne ke liye we use repo
    @Autowired
    //UserRepo mere according DB mein data save ya fetch krne ke kaam aataa hai 
    private UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        //user id :- have to be generated
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        //Password Endcoder
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {     //khud se ek error generate krr diye and iss error ko helper class mein create krr diye
        User user2 = userRepo.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        //update krenge user2 from user
        user2.setName(user.getName());
        user2.setAbout(user.getAbout());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());

        //save the user in database
        User save = userRepo.save(user2);
        //agar user nhi hai toh nullable ek empty user return krr dega khud se
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        //fetch user
        User user2 = userRepo.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepo.delete(user2);
    }

    @Override
    public boolean isUserExists(String userId) {
        User user2 = userRepo.findById(userId).orElse(null);
        return user2 != null ? true : false;
    }

    @Override
    public boolean isUserExistsByEmail(String email) {
        User user2 = userRepo.findByEmail(email).orElse(null);
        return user2 != null ? true : false;
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

}
