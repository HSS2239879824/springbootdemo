package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(name,account_id,token,gmt_create,gmt_modified,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("SELECT * FROM user WHERE token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("SELECT COUNT(id) FROM USER WHERE account_id = '${accountId}'")
    Integer findByAccountIdCount(@Param("accountId") String accountId);

    @Select("SELECT * FROM USER WHERE account_id = '${accountId}'")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("UPDATE USER SET `name` = #{name},`token` = #{token},`gmt_modified` = #{gmtModified},`bio` = #{bio},`avatar_url` = #{avatarUrl} where `account_id` = #{accountId}")
    void update(User user);
}
