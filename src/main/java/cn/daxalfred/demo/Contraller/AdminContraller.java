package cn.daxalfred.demo.Contraller;


import cn.daxalfred.demo.Entity.Admin;
import cn.daxalfred.demo.Entity.Student;
import cn.daxalfred.demo.Servlce.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminContraller {

    @Autowired
    private AdminService adminService;

    @PostMapping("adminlogin")
    public String adminlogin(HttpServletRequest request, HttpSession session){
        String checkCode = request.getParameter("checkCode");
        String sessionCheckCode = (String) session.getAttribute("captcha");
        if(checkCode!=null&&checkCode.equals(sessionCheckCode)) {
            session.removeAttribute("captcha");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Admin admin = adminService.login(username, password);
            if (admin != null) {
                session.setAttribute("admin", admin);
                session.setMaxInactiveInterval(1800);
                return "redirect:index";
            } else {
                request.setAttribute("loginError", "用户名或密码错误");
                return "forward:adminlogin.jsp";
            }
        }else {
            request.setAttribute("checkCodeEror", "验证码错误");
            session.removeAttribute("captcha");
            return "forward:adminlogin.jsp";
        }
    }

}
