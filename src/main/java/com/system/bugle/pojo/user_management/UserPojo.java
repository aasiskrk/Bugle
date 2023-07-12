package com.system.bugle.pojo.user_management;

import com.system.bugle.entity.user_management.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserPojo {

    private Integer id;

    @NotEmpty(message = "Email can't be empty")
    private String email;

    @NotEmpty(message = "Full name can't be empty")
    private String fullname;

    @NotEmpty(message = "Password can't be empty")
    private String password;

    private MultipartFile image;

    public UserPojo(User user){
        this.id=user.getId();
        this.email=user.getEmail();
        this.fullname=user.getFullName();
        this.password=user.getPassword();
    }
}
