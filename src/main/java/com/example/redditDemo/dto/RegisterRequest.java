package com.example.redditDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotNull(message = "Email Address in DTO Cannot Be Empty")
    private String email;
    @NotNull(message = "username in DTO Cannot Be Empty")
    private String username;
    @NotNull(message = "password in DTO Cannot Be Empty")
    private String password;
    @NotNull(message = "Phone Number in DTO Cannot Be Empty")
    private String phoneNo;
}
