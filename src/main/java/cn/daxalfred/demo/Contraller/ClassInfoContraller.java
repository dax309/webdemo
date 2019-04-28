package cn.daxalfred.demo.Contraller;

import cn.daxalfred.demo.Entity.Classinfo;
import cn.daxalfred.demo.Entity.PageInfo;
import cn.daxalfred.demo.Servlce.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    @RequestMapping("/classinfos")
    @ResponseBody
    public List<Classinfo> classinfos(HttpServletRequest request){
        String pcode = request.getParameter("pcode");
        List<Classinfo> list =new ArrayList<Classinfo>();
        List<Classinfo> list1 =new  ArrayList<Classinfo>();
        if(pcode.equals("all")){
            for (Classinfo classInfo:classInfoService.selAllp()){
                list1 = classInfoService.selAll(classInfo.getCode());
                if(list1.size()!=0){
                    for(Classinfo classInfo1:list1){
                        list.add(classInfo1);
                    }
                }
            }

        }else {
            System.out.println(pcode);
            int pagenumber;
            String currentPage = request.getParameter("currentPage");
            if(currentPage ==null||currentPage.equals("")){
                pagenumber = 1;
            }else {
              pagenumber  = Integer.parseInt(currentPage);
            }
            PageInfo pageInfo = classInfoService.showPage(pcode, 5, pagenumber);
            list1= (List<Classinfo>) pageInfo.getList();
            for (Classinfo classInfo:list1){
                list.add(classInfo);
            }
        }
        return list;
    }
}
