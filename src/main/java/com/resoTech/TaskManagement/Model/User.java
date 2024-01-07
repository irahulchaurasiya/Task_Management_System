package com.resoTech.TaskManagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    private String userName;

    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$" , message = "Enter Valid Email")
    private String userEmail;

    @NotBlank
    @Pattern(regexp = "^.{6,}$", message = "Password must have at least 6 characters")
    private String userPassword;
}
