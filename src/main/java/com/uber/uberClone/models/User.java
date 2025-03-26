package com.uber.uberClone.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor  // Generates an empty constructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    @NotBlank(message = "User Name is Required")
    private String name;
    @Email(message="Invalid email")
    @NotBlank(message="Email Field is required")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    private String socketId;

}
