package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.Student;

public interface UserService {
//    Student login(String username,String password);
    int selOne(String username);
    int insRegister(Student student);
    Student login(String username,String password);
}
