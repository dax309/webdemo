package cn.daxalfred.demo.Dao;

import cn.daxalfred.demo.Entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
     public List<Student> getStudents(@Param("pageStart")int pageStart,@Param("pageSize")int pageSize);

     int getStudentTotal();

     int isUpdateStudent(Student student);
     int isAddStudent(Student student);
     int isDelStudent(int ID);
     Student getStudentById(int ID);

    String getStudentName(int uid);
}

