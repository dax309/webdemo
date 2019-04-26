package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.Student;

import java.util.Date;

public interface UserService {
//    Student login(String username,String password);
    int selOne(String username);
    int insRegister(Student student);
    Student login(String username,String password);
    Student getinfo(String name);
    int updateinfo(String username, String email, String realname, int gender, Date birthday);
}
