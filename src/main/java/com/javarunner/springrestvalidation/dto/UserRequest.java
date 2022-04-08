package com.javarunner.springrestvalidation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "user name should not be null")
    private String name;
    @Email (message = "Invalid Email id")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\d{10}$",message = "Invalid Mobile number entered")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(99)
    private Integer age;
    @NotBlank
    private String nationality;

}
