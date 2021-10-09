package com.example.redditDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;
    @NotNull(message = "Username is Required")
    private String username;
    @NotNull(message = "Password is Required")
    private String password;
    @Email
    @NotNull(message = "Email is Required")
    private String email;
    private Instant created;
    @NotNull(message = "PhoneNo is Required")
    private String phoneNo;
    private boolean enabled;
}
