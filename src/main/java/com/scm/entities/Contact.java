package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

//MODEL yhaa prr ENTITY hota hai
@Entity

public class Contact {

    //Id jisko bnaana hota hai usko alag se likhte hai
    @Id
    private String Id;

    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;

    //Column use krke hmlog specific column mein changes krte hai 
    @Column(length = 1000)
    private String description;

    private boolean favorite = false;
    private String websiteLink;
    private String linkedInLink;

    @ManyToOne
    private User user;

    //EAGER kiya hai so that jaise hi contact list fetch housse saare links fetch ho jaaye
    //yhaa btaana padta hai ki kisse mapped hai taaki ek new table nhi bnega wrna ek mapping table bnn jaati hai 
    @OneToMany(mappedBy = "contact" , cascade = CascadeType.ALL , fetch = FetchType.EAGER , orphanRemoval = true)
    private List<SocialLink> links = new ArrayList<>(); 
}
