package me.majiajie.db.Mapper;

import me.majiajie.db.entity.UserEntity;



public interface UserMapper
{
    UserEntity selectUser(int id);
}
