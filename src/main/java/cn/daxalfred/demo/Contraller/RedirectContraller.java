package cn.daxalfred.demo.Contraller;


import cn.daxalfred.demo.Entity.notice;
import cn.daxalfred.demo.Servlce.Impl.ClassInfoServiceImpl;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
public class RedirectContraller {

    @Autowired
    private ClassInfoServiceImpl classInfoService;

    @RequestMapping("/adminlogin")
    public String adminlogin(){
        return "adminindex";
    }

    @RequestMapping("/index")
    public String index(ModelMap map){

        List<notice> notics = classInfoService.selallnotices();
        map.addAttribute("notis",notics);
        return "index";
    }

    @RequestMapping("/notices")
    public String notices(HttpServletRequest request){

        List<notice> notices = classInfoService.selallnotices();
        request.setAttribute("notis",notices);
        return "notis";
    }


    @RequestMapping("/learnhistory")
    public String learnhistory(ModelMap map,HttpServletRequest request){
        String studentid = request.getParameter("studentid");
        int a = classInfoService.sellearnhistory(Integer.parseInt(studentid));
        map.addAttribute("learnhistory",a);
        return "/student/learnhistory";
    }

    @RequestMapping("/download")
    public  void  download(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String classId = request.getParameter("classId");
        String fileName = classInfoService.getdownfile(Integer.parseInt(classId));
        if (fileName != null){
            response.setHeader("content-disposition", "attachment;filename=" + fileName);
            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream("E:" + "\\" + fileName);
            byte buffer[] = new byte[1024];
            int len = 0;
//循环将输入流中的内容读取到缓冲区当中
            while((len=in.read(buffer))>0){
//输出缓冲区的内容到浏览器，实现文件下载
                out.write(buffer, 0, len);
            }
//关闭文件输入流
            in.close();
//关闭输出流
            out.close();
        }
    }

    @RequestMapping("/play")
    public String play(){
        return "play";
    }


    /*学生*/

    //个人中心
    @RequestMapping("/studentinfo")
    public String studentinfo(){
        return "/student/infoindex";
    }




    /*管理员*/

    //管理员主页
    @RequestMapping("/adminindex")
    public String admin(){
        return "/admin/index";
    }

    @RequestMapping("adminhead")
    public String adminhead(){
        return "admin/head";
    }

    @RequestMapping("adminleft")
    public String adminleft(){
        return "admin/left";
    }

    @RequestMapping("adminnav")
    public String adminnav(){
        return "admin/nav";
    }

    @RequestMapping("adminhome")
    public String adminhome(){
        return "admin/home";
    }

    @RequestMapping("adminteacheredit")
    public String adminteacheredit(){
        return "admin/teacheredit";
    }

    /*课程*/

    @RequestMapping("/classinfofrower")
    public String classinfofrower(){
        return "/class/classInfo";
    }

    @RequestMapping("/Compiler")
    public String Compiler(){
        return "/Compiler/CompilerIndex";
    }

    /*试题*/
    @RequestMapping("/testIndex")
    public String testIndex(){
        return "/test/testIndex";
    }

    @RequestMapping("/updatepassword")
    public String updatepassword(){
        return "/student/updatepassword";
    }

    @RequestMapping("/home")
    public String home(){
        return "/admin/home";
    }

    /*编译*/
    @RequestMapping("/ctest")
    public String ctest(){
        return "/Compiler/test";
    }
}
