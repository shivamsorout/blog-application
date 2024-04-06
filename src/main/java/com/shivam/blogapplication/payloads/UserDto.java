package com.shivam.blogapplication.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
    @NotNull
    @Size(min = 4, message = "Username must be min of 4 characters !!")
    private String name;
    @Email(message = "Email address is not valid !!")
    @NotEmpty(message = "Email cannot be empty!!v")
    @NotNull
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern.List({
            @Pattern(regexp = "(?=.*[0-9]).+", message = "Password must contain at least one digit"),
            @Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain at least one lowercase letter"),
            @Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain at least one uppercase letter"),
            @Pattern(regexp = "(?=.*[@#$%^&+=]).+", message = "Password must contain at least one special character")
    })
    private String password;
    @NotNull
    private String about;
}
