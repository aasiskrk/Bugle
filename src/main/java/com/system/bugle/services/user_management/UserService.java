package com.system.bugle.services.user_management;

import com.system.bugle.dto.AuthenticationResponse;
import com.system.bugle.dto.BlogDto;
import com.system.bugle.dto.LoginDto;
import com.system.bugle.entity.user_management.User;
import com.system.bugle.pojo.user_management.UserPojo;

import java.io.IOException;
import java.util.List;

public interface UserService {

    UserPojo save(UserPojo userPojo) throws IOException;

    List<User> fetchAll();

    User fetchById(Integer id);

    void deleteById(Integer id);

    void sendEmail();

    void updateUser(Integer id, UserPojo userPojo);

    AuthenticationResponse authenticate(LoginDto loginDto);
}
