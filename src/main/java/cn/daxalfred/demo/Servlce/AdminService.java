package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    Admin login(String username, String password);

    int getTeacherTotal();
    //获取教师集合
    public List<Admin> getTeachers(int startIndex,int pageSize);

    Admin getTeacherById(int ID);

    int isUpdateTeacherInfo(Admin admin);

    int isAddTeacherInfo(Admin admin);

    int isDelTeacherInfo(int admin);

}
