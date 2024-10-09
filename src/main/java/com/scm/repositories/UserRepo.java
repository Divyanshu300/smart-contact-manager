package com.scm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;


@Repository

//kis entity prr kaam krr rhe:- User
//uski id kis type ki hai:- String
public interface UserRepo extends JpaRepository<User , String> {
    //extra methods for DB related operations
    //custom query methods
    //custom finder methods
}
