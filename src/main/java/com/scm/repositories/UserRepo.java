package com.scm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;
import java.util.Optional;


//Ek repo ka main kaam hota hai DB se interract krrna yaani data storage and retrievel
@Repository

                                //kis entity prr kaam krr rhe:- User
                                //uski id kis type ki hai:- String
public interface UserRepo extends JpaRepository<User , String> {
    //extra methods for DB related operations
    //custom query methods
    
    
    //custom finder methods
    //inki implementation apne aap spring data jpa khud se krr deta hai
    
    //for eg agar mail ke through kuch find krrna ho toh camel casing mein findBy ke baad Email likh do
    Optional<User> findByEmail(String email);
    //simillarly agar email and password dono ka use krna ho toh dono likh do
    Optional<User> findByEmailAndPassword(String email, String password);

}
