package com.huarui.util;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * Created by sloan on 2019/7/17.
 */


public interface MyBaseMapper<T>  extends Mapper<T>, MySqlMapper<T> {
@Options(
        useGeneratedKeys = true,
        keyProperty = "id"
)
@InsertProvider(
        type = MyBaseInsertProvider.class,
        method = "dynamicSQL"
)
    int insertReturnId(T var1);

@Options(
        useGeneratedKeys = true,
        keyProperty = "id"
)
@InsertProvider(
        type = MyBaseInsertProvider.class,
        method = "dynamicSQL"
)
    int insertSelectiveReturnId(T var1);

@InsertProvider(
        type = MyBaseInsertProvider.class,
        method = "dynamicSQL"
)
    int insertListNotKey(List<T> var1);
}
