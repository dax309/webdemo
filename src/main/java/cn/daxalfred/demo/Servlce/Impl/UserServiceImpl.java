package cn.daxalfred.demo.Servlce.Impl;

import cn.daxalfred.demo.Dao.StudentMapper;
import cn.daxalfred.demo.Entity.Student;
import cn.daxalfred.demo.Servlce.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public int selOne(String usernmae) {

        return this.studentMapper.selOne(usernmae);
    }

    @Override
    public int insRegister(Student student) {

        return this.studentMapper.insRegister(student);
    }

    @Override
    public Student login(String username, String password) {

        return this.studentMapper.login(username,password);
    }

    @Override
    public Student getinfo(String name) {
        return this.studentMapper.getinfo(name);
    }

    @Override
    public int updateinfo(String username, String email, String realname, int gender, Date birthday) {

        return this.studentMapper.updateinfo(username,email,realname,gender,birthday);
    }

    @Override
    public int selpass(String username, String password) {
        return this.studentMapper.selpass(username,password);
    }

    @Override
    public int updatepwd(String username, String password) {
        return this.studentMapper.updatepwd(username,password);
    }

    @Override
    public List<Student> getStudents(int pageStart,int pageSize) {
        return this.studentMapper.getStudents(pageStart,pageSize);
    }

    @Override
    public int getStudentTotal() {
        return this.studentMapper.getStudentTotal();
    }

    @Override
    public int isUpdateStudent(Student student) {
        return this.studentMapper.isUpdateStudent(student);
    }

    @Override
    public int isAddStudent(Student student) {
        return this.studentMapper.isAddStudent(student);
    }

    @Override
    public int isDelStudent(int ID) {
        return this.studentMapper.isDelStudent(ID);
    }

    @Override
    public Student getStudentById(int ID) {
        return this.studentMapper.getStudentById(ID);
    }


}
