package com.gbhu.dao;

import com.gbhu.domain.VideoOrder;
import org.apache.ibatis.annotations.Param;

public interface VideoOrderMapper {
    VideoOrder selectOrderAndUser(@Param("order_id") int orderId);
    VideoOrder selectOrderAndUserLazy(@Param("order_id") int orderId);
}
