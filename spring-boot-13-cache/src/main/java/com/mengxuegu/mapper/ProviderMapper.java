package com.mengxuegu.mapper;/*
 *
 *  @Author:shipeixin
 *  @Date:2019/5/31 13:41
 *
 */

import com.mengxuegu.entities.Provider;
import org.apache.ibatis.annotations.Param;

public interface ProviderMapper {

    Provider getProviderByPid(@Param("pid") Integer pid);

    Integer updateProvider(Provider provider);

    Integer addProvider(Provider provider);

    Integer deleteProvider(Integer pid);
}
