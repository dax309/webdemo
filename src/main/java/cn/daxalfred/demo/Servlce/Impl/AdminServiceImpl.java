package cn.daxalfred.demo.Servlce.Impl;

import cn.daxalfred.demo.Dao.AdminMapper;
import cn.daxalfred.demo.Entity.Admin;
import cn.daxalfred.demo.Entity.Student;
import cn.daxalfred.demo.Servlce.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        return adminMapper.login(username,password);
    }


    public int getTeacherTotal() {
        return adminMapper.getTeacherTotal();
    }

    @Override
    public List<Admin> getTeachers(int startIndex,int pageSize) {
        return adminMapper.getTeachers(startIndex,pageSize);
    }

    @Override
    public Admin getTeacherById(int ID) {
        return this.adminMapper.getTeacherById(ID);
    }

    @Override
    public int isUpdateTeacherInfo(Admin admin) {
        return this.adminMapper.isUpdateTeacherInfo(admin);
    }

    @Override
    public int isAddTeacherInfo(Admin admin) {
        return this.adminMapper.isAddTeacherInfo(admin);
    }

    @Override
    public int isDelTeacherInfo(int admin) {
        return this.adminMapper.isDelTeacherInfo(admin);
    }
}
