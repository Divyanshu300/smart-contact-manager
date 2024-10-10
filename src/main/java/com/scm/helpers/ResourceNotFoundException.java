package com.scm.helpers;


//Ye khud ka create kiyaa huaa error hai
//saare khud se bnaaye hue errors helpers package mein save hote hai
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException() {
        super("Resource not found");
    }
}
