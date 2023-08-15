package com.gbhu.dao;

import com.gbhu.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User selectUserOrder(@Param("user_id") int userId);
}
