package com.mengxuegu.mapper;


/*
* 使用注解版本
* */
import com.mengxuegu.entities.Provider;
import org.apache.ibatis.annotations.*;

//@Mapper
public interface ProviderMapper {

    @Select("select * from provider where pid = #{pid}")
    Provider getProviderByPid(Integer pid);


    @Options(useGeneratedKeys = true,keyColumn = "pid",keyProperty = "pid")
    @Insert("insert into provider (providerName) values(#{providerName})")
    int addProvider(Provider provider);

    @Delete("delete from provider where pid = #{pid}")
    int deleteProvider(Integer pid);

    @Update("update provider set providerName = #{providerName} where pid = #{pid}}")
    int update(Provider provider);
}
