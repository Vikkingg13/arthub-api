package com.github.vikkingg13.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;
    private String email;
    private String name;
    private String lastName;
    private String photoPath;
    private int age;
    private String country;
    private String profession;

    @OneToMany(mappedBy = "user")
    private List<Album> album;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_follower",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "follower_id", referencedColumnName = "id")})
    private List<User> follower;

    @ManyToMany(mappedBy = "follower", fetch = FetchType.EAGER)
    private List<User> user;

}
