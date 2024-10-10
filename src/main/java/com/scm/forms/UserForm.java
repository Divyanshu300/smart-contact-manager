package com.scm.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

//Ye skeleton hai yaa yun keh lo ki object hai jisme saare ke saare forms ki details save hoti hai
public class UserForm {

    private String name;
    private String email;
    private String password;
    private String about;
    private String phoneNumber;
    
}
