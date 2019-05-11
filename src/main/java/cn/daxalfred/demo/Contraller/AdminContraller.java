package cn.daxalfred.demo.Contraller;


import cn.daxalfred.demo.Entity.Admin;
import cn.daxalfred.demo.Entity.PageInfo;
import cn.daxalfred.demo.Entity.Student;
import cn.daxalfred.demo.Servlce.AdminService;
import cn.daxalfred.demo.Servlce.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminContraller {

    @Autowired
    private AdminServiceImpl adminService;

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
                request.getSession().setAttribute("adminPower", admin.getAdminPower());
                session.setMaxInactiveInterval(1800);
                return "redirect:/adminindex";
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

    @RequestMapping("/exitTeacher")
    public void exitTeacher(HttpSession session, HttpServletResponse response) throws IOException {
        session.removeAttribute("admin");
        session.removeAttribute("adminPower");
        response.sendRedirect("admin/login.jsp");
    }




    @RequestMapping(value="/teachers", method= RequestMethod.GET)
    public ModelAndView getTeachers(HttpServletRequest request) {
        int pageShow =10;
        String pageNumber = request.getParameter("startPage");
        int Number;
        if(pageNumber==null){
            Number = 1;
        }else {
            Number = Integer.parseInt(pageNumber);
        }

        ModelAndView model = new ModelAndView();
        model.setViewName("admin/teachers");

        List<Admin> teachers;

        Map<String, Object> map = new HashMap<String, Object>();
        //计算当前查询起始数据索引
        int startIndex = (Number-1) * pageShow;
        teachers = adminService.getTeachers(startIndex,pageShow);
        model.addObject("teachers", teachers);

        //获取教师总量
        int teacherTotal = adminService.getTeacherTotal();
        //计算总页数
        int pageTotal = 1;
        if (teacherTotal % pageShow == 0)
            pageTotal = teacherTotal / pageShow;
        else
            pageTotal = teacherTotal / pageShow + 1;
        model.addObject("pageTotal", pageTotal);
        model.addObject("pageNow", Number);

        return model;
    }


    @RequestMapping(value="/teacher/{teacherId}", method=RequestMethod.GET)
    public ModelAndView preUpdateTeacher(@PathVariable("teacherId") Integer teacherId) {

        ModelAndView model = new ModelAndView();
        //获取要修改教师
        Admin teacher = adminService.getTeacherById(teacherId);
        model.setViewName("/admin/teacheredit");
        model.addObject("teacher", teacher);

        return model;
    }




    @RequestMapping(value="/teacher/teacher", method=RequestMethod.POST)
    public String isUpdateOrAddTeacher(@RequestParam(value="teacherId", required=false) Integer teacherId,
                                       @RequestParam(value="isupdate", required=false) Integer isUpdate,
                                       @RequestParam("teacherName") String teacherName,
                                       @RequestParam("teacherAccount") String teacherAccount,
                                       @RequestParam("teacherPwd") String teacherPwd,
                                       @RequestParam("adminPower") Integer adminPower) {

        Admin teacher = new Admin();
        teacher.setID(teacherId);
        teacher.setRealname(teacherName);
        teacher.setUsername(teacherAccount);
        teacher.setPassword(teacherPwd);
        teacher.setAdminPower(adminPower);
        int row;
        //修改
        //添加
        if (isUpdate != null) {
            row = adminService.isUpdateTeacherInfo(teacher);
        } else {
            row = adminService.isAddTeacherInfo(teacher);
        }

        return "redirect:/teachers";
    }


    @RequestMapping(value="/teacher/{teacherId}", method=RequestMethod.DELETE)
    public String isDelTeacher(@PathVariable("teacherId") Integer teacherId) {

        int row = adminService.isDelTeacherInfo(teacherId);

        return "redirect:/teachers";
    }





}
