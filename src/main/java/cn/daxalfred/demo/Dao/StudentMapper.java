package cn.daxalfred.demo.Dao;

import cn.daxalfred.demo.Entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface StudentMapper {
     int selOne(String username);

     int insRegister(Student student);

     Student login(@Param("username") String username, @Param("password") String password);

     Student getinfo(String name);

     int updateinfo(@Param("username") String username,
                    @Param("email") String email,
                    @Param("realname") String realname,
                    @Param("gender") int gender,
                    @Param("birthday") Date birthday);
     int selpass(@Param("username")String username,@Param("password")String password);
     int updatepwd(@Param("username")String username,@Param("password")String password);
}
