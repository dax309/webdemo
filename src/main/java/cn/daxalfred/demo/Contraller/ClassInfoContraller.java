package cn.daxalfred.demo.Contraller;

import cn.daxalfred.demo.Entity.Classinfo;
import cn.daxalfred.demo.Entity.PageInfo;
import cn.daxalfred.demo.Servlce.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ClassInfoContraller {

    @Autowired
    private ClassInfoService classInfoService;

    @RequestMapping("/classdir")
    public String classdir(HttpServletRequest request){
        List<Classinfo> list = classInfoService.selAllp();
        request.setAttribute("list",list);
        return "/class/classdir";
    }

    /*获取子目录*/
    @PostMapping("/classinfos")
    @ResponseBody
    public PageInfo classinfos(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pcode = request.getParameter("pcode");
        String pageNumber = request.getParameter("pageNumber");
        PageInfo pageInfo = null;
        int Number;
        if(pageNumber==null){
            Number = 1;
        }else {
            Number = Integer.parseInt(pageNumber);
        }

        if(pcode.equals("all")){
            pageInfo = classInfoService.selAlltwoByPage(
                            2, 5, Number);
        }else {
            pageInfo = classInfoService.showPage(pcode,5,Number);
        }
        return pageInfo;
    }

    @RequestMapping("/classinfo")
    public String classinfo(HttpServletRequest request,ModelMap map){
        String code = request.getParameter("code");
        String pageNumber = request.getParameter("pageNumber");
        int Number;
        if(pageNumber==null||pageNumber.equals("")){
            Number =1;
        }else {
            Number = Integer.parseInt(pageNumber);
            if (Number<=1){
                Number = 1;
            }
        }
        PageInfo pageInfo =classInfoService.showPage(code,5,Number);
        map.addAttribute("pageInfo",pageInfo);
        map.addAttribute("code",code);
        return "/class/classInfo";
    }

    @RequestMapping("/playclass")
    public String playclass(HttpServletRequest request,ModelMap map){
        String code = request.getParameter("code");
        Classinfo classinfo =classInfoService.selcode(code);
        Classinfo classinfo2 = classInfoService.selcode(classinfo.getPcode());
        Classinfo classinfo1 = classInfoService.selflowerone(classinfo.getPcode());
        List<Classinfo> list1 = classInfoService.selAll(classinfo1.getCode());
        List<Classinfo> list2 = classInfoService.selAll(classinfo.getPcode());

        map.addAttribute("classinfo",classinfo);     //本节信息
        map.addAttribute("classinfo1",classinfo1);   //本课程信息
        map.addAttribute("classinfo2",classinfo2);   //本章信息
        map.addAttribute("list1",list1);             //本课程所有章
        map.addAttribute("list2",list2);             //本章所有节
        return "play";
    }




}
