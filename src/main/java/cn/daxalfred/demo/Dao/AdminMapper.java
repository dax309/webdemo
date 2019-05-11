package cn.daxalfred.demo.Dao;

import cn.daxalfred.demo.Entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    Admin login(@Param("username") String username, @Param("password") String password);
    int getTeacherTotal();

    //获取教师集合
    public List<Admin> getTeachers(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    Admin getTeacherById(int ID);

    public int isUpdateTeacherInfo(Admin admin);

    public int isAddTeacherInfo(Admin admin);

    int isDelTeacherInfo(int ID);
}
