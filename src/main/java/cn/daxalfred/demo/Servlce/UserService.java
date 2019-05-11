package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.Student;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserService {
//    Student login(String username,String password);
    int selOne(String username);
    int insRegister(Student student);
    Student login(String username,String password);
    Student getinfo(String name);
    int updateinfo(String username, String email, String realname, int gender, Date birthday);
    int selpass(String username,String password);
    int updatepwd(String username,String password);

    List<Student> getStudents(int pageStart,int pageSize);

    int getStudentTotal();

    int isUpdateStudent(Student student);
    int isAddStudent(Student student);
    int isDelStudent(int ID);
    Student getStudentById(int ID);
}
