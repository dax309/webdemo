package cn.daxalfred.demo.Contraller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectContraller {

    @RequestMapping("/adminlogin")
    public String adminlogin(){
        return "adminindex";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
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


    /*回复*/
    @RequestMapping("/reply")
    public String reply(){
        return "/reply/reply";
    }




}
