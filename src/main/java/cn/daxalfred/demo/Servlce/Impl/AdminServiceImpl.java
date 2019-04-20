package cn.daxalfred.demo.Servlce.Impl;

import cn.daxalfred.demo.Dao.AdminMapper;
import cn.daxalfred.demo.Entity.Admin;
import cn.daxalfred.demo.Entity.Student;
import cn.daxalfred.demo.Servlce.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        return adminMapper.login(username,password);
    }
}
