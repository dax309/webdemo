package cn.daxalfred.demo.Contraller;

import cn.daxalfred.demo.Entity.*;
import cn.daxalfred.demo.Servlce.Impl.ExamPaperServiceImpl;
import cn.daxalfred.demo.Servlce.Impl.UserServiceImpl;
import cn.daxalfred.demo.Servlce.UserService;
import cn.daxalfred.demo.Utils.MD5Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wf.captcha.Captcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExamPaperServiceImpl examPaperService;

    @Autowired
    private ExamSubjectMiddleInfo esm;

    @Autowired
    private ExamPaper examPaper;
    @Autowired
    private UserServiceImpl studentService;

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
        String usernamer = request.getParameter("username");
        boolean flag = userService.selOne(usernamer)>0?false:true;
        String json = "{\"flag\":" + flag + "}";
        response.getWriter().write(json);
    }

    //Ajax验证旧密码是否正确
    @RequestMapping("/passwordCentre")
    public void passwordCentre(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        String password = request.getParameter("oldpassword");
        Student student = (Student) session.getAttribute("student");
        String username = student.getUsername();
        boolean flag = userService.selpass(username,MD5Utils.md5(password))<1?false:true;
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
            student.setPassword(MD5Utils.md5(request.getParameter("password")));
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
    public String userlogin(HttpServletRequest request,HttpSession session,HttpServletResponse response){
        String checkCode = request.getParameter("checkCode");
        String sessionCheckCode = (String) session.getAttribute("captcha");
        if(checkCode!=null&&checkCode.equals(sessionCheckCode)) {
            session.removeAttribute("captcha");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Student user = userService.login(username,MD5Utils.md5( password));
            if (user != null) {
                String rember = null;
                if(request.getParameter("rember") == null){
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null) {
                        for (Cookie c : cookies) {
                            if(c.getName().equals("uname")){
                                c.setMaxAge(0);
                            }else if(c.getName().equals("pword")){
                                c.setMaxAge(0);
                            }
                        }
                    }
                }else{
                    Cookie uname = new Cookie("uname", username);
                    uname.setMaxAge(60*60*24*7);
                    uname.setPath("/");
                    response.addCookie(uname);
                    Cookie pword = new Cookie("pword", password);
                    pword.setMaxAge(60*60*24*7);
                    pword.setPath("/");
                    response.addCookie(pword);
                }
                session.setAttribute("student", user);
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

    @RequestMapping("/updatepwd")
    public void updatepwd(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IOException {
        String password = request.getParameter("password");
        Student student = (Student) session.getAttribute("student");
        boolean info = userService.updatepwd(student.getUsername(),MD5Utils.md5(password))<0?false:true;
        System.out.println(info);
        String json = "{\"info\":" + info + "}";
        response.getWriter().write(json);
    }


    @RequestMapping("/students")
    public ModelAndView getCourses(@RequestParam(value = "studentId", required = false) Integer studentId,
                                   @RequestParam(value="startPage", required=false, defaultValue="1") Integer startPage,
                                   @RequestParam(value="pageShow", required=false, defaultValue="10") Integer pageShow ) {
        ModelAndView model = new ModelAndView();
        model.setViewName("/admin/students");

        //查询条件处理
        Student student = new Student();
        if (studentId != null)
            student.setID(studentId);

        Map<String, Object> map = new HashMap<String, Object>();
        //计算当前查询起始数据索引
        int startIndex = (startPage-1) * pageShow;
        map.put("student", student);
        map.put("startIndex", startIndex);
        map.put("pageShow", pageShow);
        List<Student> students = userService.getStudents(startIndex,10);
        model.addObject("students", students);

        //获取学生总量
        int studentTotal = userService.getStudentTotal();
        //计算总页数
        int pageTotal = 1;
        if (studentTotal % pageShow == 0)
            pageTotal = studentTotal / pageShow;
        else
            pageTotal = studentTotal / pageShow + 1;
        model.addObject("pageTotal", pageTotal);
        model.addObject("pageNow", startPage);

        return model;
    }


    @RequestMapping("/student/{studentId}")
    public ModelAndView getCourseById(@PathVariable("studentId") Integer studentId) {
        ModelAndView model = new ModelAndView();
        model.setViewName("/admin/studentedit");

        Student student = userService.getStudentById(studentId);
        model.addObject("student", student);

        return model;
    }




    @RequestMapping(value = "/student/student", method = RequestMethod.POST)
    public String isUpdateOrAddCourse(
            @RequestParam(value = "studentId", required = false) Integer studentId,
            @RequestParam(value = "isupdate", required = false) Integer isUpdate,
            @RequestParam(value = "studentName", required = false) String studentName,
            @RequestParam("studentAccount") String studentAccount,
            @RequestParam("studentPwd") String studentPwd) {

        Student student = new Student();
        student.setID(studentId);
        student.setRealname(studentName);
        student.setUsername(studentAccount);
        student.setPassword(studentPwd);

        if (isUpdate != null) {
            int row = userService.isUpdateStudent(student);
        } else {
            int row = userService.isAddStudent(student);
        }

        return "redirect:/students";
    }

    /**
     * 删除学生
     * @param studentId
     * @return
     */
    @RequestMapping(value = "/student/{studentId}", method = RequestMethod.DELETE)
    public String isDelTeacher(@PathVariable("studentId") Integer studentId) {

        int row = userService.isDelStudent(studentId);

        return "redirect:/students";
    }


    @RequestMapping(value="/submit", method={RequestMethod.POST, RequestMethod.GET})
    public String examSubmit(
            @RequestParam("studentId") Integer studentId,
            @RequestParam("examPaperId") Integer examPaperId){
        //获取当前学生当前试卷所选择的全部答案
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);
        map.put("examPaperId", examPaperId);
        List<ExamChooseInfo> chooses = examPaperService.getChooseInfoSumScore(studentId,examPaperId);
        //总分记录
        int sumScore = 0;
        for (ExamChooseInfo choose : chooses) {
            SubjectInfo subject = choose.getSubject();
            String chooseResult = choose.getChooseResult();
            String rightResult = subject.getRightResult();
            if (chooseResult.equals(rightResult)) {	//答案正确
                sumScore += subject.getSubjectScore();
            }
        }
        /*
         * 首先判断当前记录是否已经添加过
         * 防止当前学生点击提交后，系统倒计时再次进行提交
         */
        int count = examPaperService.getHistoryInfoWithIds(map);
        System.out.println(count);
        if (count == 0) {
            //添加到历史记录
            map.put("examScore", sumScore);
            int row = examPaperService.isAddExamHistory(map);
        }
        return "redirect:playclassbyid?id="+examPaperService.getClassid(examPaperId);
    }

    @RequestMapping("/review")
    public ModelAndView reViewExam(
            @RequestParam("studentId") Integer studentId,
            @RequestParam("examPaperId") Integer examPaperId,
            @RequestParam("classId") Integer classId){
        ModelAndView model = new ModelAndView();
        examPaper.setExamPaperId(examPaperId);
        esm.setExamPaper(examPaper);
        List<ExamSubjectMiddleInfo> esms = examPaperService.getExamPaperWithSubject(classId);
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);
        map.put("examPaperId", examPaperId);
        ExamPaper examPaper = examPaperService.getExamPaper(examPaperId);
        int score = examPaperService.gethistoryScore(studentId,examPaperId);
        Student stud = studentService.getStudentById(studentId);
        //获取当前回顾试卷 试题、选择答案 信息
        List<ExamChooseInfo> reviews = examPaperService.getChooseInfoSumScore(studentId,examPaperId);
        //设置试卷名称、试卷总分
        model.addObject("examPaperName", examPaper.getExamPaperName());
        model.addObject("score", score);
        model.setViewName("reception/review");
        model.addObject("views", reviews);
        model.addObject("esms", esms);
        model.addObject("studentName", stud.getRealname());
        model.addObject("ExamedPaper", examPaper);
        return model;
    }


}
