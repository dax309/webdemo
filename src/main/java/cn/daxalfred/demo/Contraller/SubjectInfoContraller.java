package cn.daxalfred.demo.Contraller;

import cn.daxalfred.demo.Entity.SubjectInfo;
import cn.daxalfred.demo.Servlce.Impl.SubjectInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class SubjectInfoContraller {

    @Autowired
    private SubjectInfoServiceImpl subjectInfoService;

    @RequestMapping(value="/subjects", method= RequestMethod.GET)
    public ModelAndView getTeachers(
            @RequestParam(value="subjectId", required=false) Integer subjectId,
            @RequestParam(value="startPage", required=false, defaultValue="1") Integer startPage,
            @RequestParam(value="pageShow", required=false, defaultValue="10") Integer pageShow,
            @RequestParam(value="handAdd", required=false) Integer handAdd,
            @RequestParam(value="examPaperId", required=false) Integer examPaperId,
            HttpSession session) {

        ModelAndView model = new ModelAndView();
        model.setViewName("admin/subjects");

        SubjectInfo subject = new SubjectInfo();
        //条件处理
        if (subjectId != null) subject.setSubjectId(subjectId);

        //计算当前查询起始数据索引
        int startIndex = (startPage-1) * pageShow;
        //map.put("subject", subject);
        List<SubjectInfo> subjects = subjectInfoService.getSubjects(startIndex,pageShow);
        model.addObject("subjects", subjects);
        //获取试题总量
        int subjectTotal = subjectInfoService.getSubjectTotal();
        //计算总页数
        int pageTotal = 1;
        if (subjectTotal % pageShow == 0)
            pageTotal = subjectTotal / pageShow;
        else
            pageTotal = subjectTotal / pageShow + 1;
        model.addObject("pageTotal", pageTotal);
        model.addObject("pageNow", startPage);

        //是否为需要进行手动添加试题到试卷而发起的请求
        if (handAdd != null && handAdd == 1) {
            model.addObject("handAdd", "1");
        }
        //如果是手动添加试题到试卷，则需要返回试卷编号, 且返回当前已经选择试题数量
        if (examPaperId != null) {
            model.addObject("examPaperId", examPaperId);
            List<String> ids = (List<String>) session.getAttribute("ids");
            if (ids == null) {
                model.addObject("choosed", 0);
            } else {
                model.addObject("choosed", ids.size());
            }
        }

        return model;
    }


    @RequestMapping(value="/delSubject", method=RequestMethod.POST)
    public void delSubject(@RequestParam("subjectId") Integer subjectId,
                           HttpServletResponse response) throws IOException {

        int row = subjectInfoService.isDelSubject(subjectId);

        if (row > 0) {
            response.getWriter().print("t");
        } else {
            response.getWriter().print("f");
        }
    }


    @RequestMapping(value="/addSubject", method=RequestMethod.POST)
    public void addSubject(SubjectInfo subject, HttpServletResponse response) throws IOException {
        issubject(subject);
        int row = subjectInfoService.isAddSubject(subject);
        response.getWriter().print("试题添加成功!");
    }


    //预添加信息
    @RequestMapping("/preAddSubject")
    public ModelAndView preAddStudent() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/admin/subject-test");
        return model;
    }

    @RequestMapping("/subject/{subjectId}")
    public ModelAndView updateSubject(@PathVariable("subjectId") Integer subjectId) {
        SubjectInfo subject = subjectInfoService.getSubjectWithId(subjectId);

        ModelAndView model = new ModelAndView("/admin/subject-test");
        model.addObject("subject", subject);
        return model;
    }



    @RequestMapping(value="/updateSubject", method=RequestMethod.POST)
    public void updateSubject(SubjectInfo subject, HttpServletResponse response) throws IOException {

        issubject(subject);
        int row = subjectInfoService.isUpdateSubject(subject);
        if (row > 0) {
            response.getWriter().print("试题修改成功!");
        } else {
            response.getWriter().print("试题修改失败!");
        }
    }

    private void issubject(SubjectInfo subject) {
        if(subject != null){
            subject.setSubjectName(trimChar(subject.getSubjectName()));
            subject.setRightResult(trimChar(subject.getRightResult()));
            subject.setOptionA(trimChar(subject.getOptionA()));
            subject.setOptionB(trimChar(subject.getOptionB()));
            subject.setOptionC(trimChar(subject.getOptionC()));
            subject.setOptionD(trimChar(subject.getOptionD()));
        }
    }


    private String trimChar(String str){
        if(str != null){
            return str.replaceAll("^,*|,*$", "");
        }
        return str;
    }



}
