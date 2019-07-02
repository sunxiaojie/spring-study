package com.sxj.product.mapper;

import com.sxj.product.domain.OrderInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    Integer countOrderList();

    List<OrderInfoDO> queryOrderList(@Param("start") Integer start, @Param("end") Integer end);
}
