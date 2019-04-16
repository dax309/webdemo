package cn.daxalfred.demo.Dao;

import cn.daxalfred.demo.Entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {
    public int selOne(String username);
    public int insRegister(Student student);
    public Student login(@Param("username") String username, @Param("password") String password);
}
