package com.huarui.dao;

import com.huarui.model.Dish;
import com.huarui.util.MyBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * Created by sloan on 2019/7/13.
 */

@Mapper
public interface DishMapper extends MyBaseMapper<Dish>
{


    @Select({
            "select * from dish where id = #{id}"
    })
    Dish findById(@Param("id") Long id);

}
