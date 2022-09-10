package com.bridgelabz.bookstorespringboot.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "User")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String email;
    private String password;

    public User(String encodedPassword, String userName, String email) {
        this.password = encodedPassword;
        this.userName = userName;
        this.email = email;
    }


}
