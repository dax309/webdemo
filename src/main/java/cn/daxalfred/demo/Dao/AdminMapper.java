package cn.daxalfred.demo.Dao;

import cn.daxalfred.demo.Entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    public Admin login(@Param("username") String username, @Param("password") String password);
}
