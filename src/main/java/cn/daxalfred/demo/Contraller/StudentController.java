package cn.daxalfred.demo.Contraller;

import cn.daxalfred.demo.Entity.Student;
import cn.daxalfred.demo.Servlce.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wf.captcha.Captcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class StudentController {

    @Autowired
    private UserService userService;

    //生成验证码
    @RequestMapping("/checkCode")
    public void captcha(HttpServletRequest request, HttpServletResponse response ,int page) throws Exception {
        // 设置请求头为输出图片类型
        CaptchaUtil.setHeader(response);
        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha=null;
        if(page == 1){
            specCaptcha = new SpecCaptcha(120, 48, 4);
        }else {
            specCaptcha = new SpecCaptcha(120, 48, 4);
        }
        // 设置字体
        specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // 有默认字体，可以不用设置

        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_DEFAULT);

        // 生成的验证码
        String code = specCaptcha.text();

        // 验证码存入session
        request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());

        // 输出图片流
        specCaptcha.out(response.getOutputStream());
    }

    //Ajax验证用户名是否已注册
    @PostMapping("/userCentre")
    public void userCentre(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        boolean flag = userService.selOne(username)>0?false:true;
        String json = "{\"flag\":" + flag + "}";
        response.getWriter().write(json);
    }

    //注册验证
    @PostMapping("/register")
    public String register(HttpServletRequest request) throws ParseException {

        String checkCode = request.getParameter("checked");
        HttpSession session = request.getSession();
        String sessionCheckCode = (String) session.getAttribute("captcha");
        if(checkCode!=null&&checkCode.equals(sessionCheckCode)){
            session.removeAttribute("captcha");
            Student student=new Student();
            student.setUsername(request.getParameter("username"));
            student.setPassword(request.getParameter("password"));
            String gender= request.getParameter("gender");
            student.setGender(Integer.parseInt(gender));
            String birthday = request.getParameter("birthday");
            java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
            student.setBirthday(formatter.parse(birthday));
            student.setEmail(request.getParameter("email"));
            student.setRealname(request.getParameter("realname"));
            int i = userService.insRegister(student);
            if(i>0){
                return "redirect:/index";
            }else {
                request.setAttribute("checkCodeEror", "注册失败");
                return "forward:register.jsp";
            }
        }else{
            request.setAttribute("checkCodeEror", "验证码错误");
            session.removeAttribute("captcha");
            return "forward:register.jsp";
        }
    }

    //登陆验证
    @PostMapping("/userlogin")
    public String userlogin(HttpServletRequest request,HttpSession session){
        String checkCode = request.getParameter("checkCode");
        String sessionCheckCode = (String) session.getAttribute("captcha");
        if(checkCode!=null&&checkCode.equals(sessionCheckCode)) {
            session.removeAttribute("captcha");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Student user = userService.login(username, password);
            if (user != null) {
                session.setAttribute("student", user);
                session.setMaxInactiveInterval(1800);
                return "redirect:index";
            } else {
                request.setAttribute("loginError", "用户名或密码错误");
                return "forward:login.jsp";
            }
        }else{
            request.setAttribute("checkCodeEror", "验证码错误");
            session.removeAttribute("captcha");
            return "forward:login.jsp";
        }
    }

    //退出
    @RequestMapping("/logOut")
    public String logOut(HttpSession session){
        session.removeAttribute("student");
        return "redirect:index.jsp";
    }

    //学生信息查找
    @RequestMapping("/studentupdate")
    public String studentupdate(HttpSession session){
        Student student= (Student) session.getAttribute("student");
        /*String name = student.getUsername();
        Student s = userService.getinfo(name);*/
        return "/student/update";
    }

    //学生信息修改
    @RequestMapping("/updateStudent")
    public void updateStudent(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws ParseException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String realname = request.getParameter("realname");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String birthday = request.getParameter("birthday");
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date birth = formatter.parse(birthday);
        int i = userService.updateinfo(username, email, realname, gender, birth);
        boolean info;
        ObjectMapper mapper = new ObjectMapper();
        if(i<1){
            info = false;
        }else {
            request.setAttribute("info", "true");
            Student student = new Student();
            student.setGender(gender);
            student.setRealname(realname);
            student.setBirthday(birth);
            student.setEmail(email);
            Student student1 = (Student) session.getAttribute("student");
            student.setUsername(student1.getUsername());
            session.setAttribute("student",student);
            info = true;
        }
        String json = "{\"info\":" + info + "}";
        response.getWriter().write(json);

    }












}
