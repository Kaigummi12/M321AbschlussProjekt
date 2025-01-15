package com.example.user_service.mapper;

import com.example.user_service.entity.UserIN;
import com.example.user_service.entity.UserOUT;
import com.example.user_service.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserOUT userToUserOut(User user);

    User userInToUser(UserIN user);
}
