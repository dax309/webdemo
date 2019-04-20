package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.Admin;

public interface AdminService {
    Admin login(String username, String password);
}
