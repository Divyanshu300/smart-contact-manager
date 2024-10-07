package com.scm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class Contact {

    @Id
    private String Id;

    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;

    @Column(columnDefinition = "TEXT")
    private String description;

    private boolean favorite = false;
    private String websiteLink;
    private String linkedInLink;

    @ManyToOne
    private User user;
}
