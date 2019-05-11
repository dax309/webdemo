package cn.daxalfred.demo.Contraller;

import cn.daxalfred.demo.Entity.ExamPaper;
import cn.daxalfred.demo.Entity.SubjectInfo;
import cn.daxalfred.demo.Servlce.Impl.ExamPaperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ExamPaperContraller {

    @Autowired
    private ExamPaperServiceImpl examPaperService;



    @RequestMapping("/examPapers")
    public ModelAndView getCourses(@RequestParam(value="startPage", required=false, defaultValue="1") Integer startPage,
                                   @RequestParam(value="pageShow", required=false, defaultValue="10") Integer pageShow ) {
        ModelAndView model = new ModelAndView();
        model.setViewName("/admin/examPapers");


        //计算当前查询起始数据索引
        int startIndex = (startPage-1) * pageShow;
        List<ExamPaper> examPapers = examPaperService.getExamPapers(startIndex,pageShow);
        model.addObject("examPapers", examPapers);

        //获取试卷总量
        int examPaperTotal = examPaperService.getExamPpaerTotal();
        //计算总页数
        int pageTotal = 1;
        if (examPaperTotal % pageShow == 0)
            pageTotal = examPaperTotal / pageShow;
        else
            pageTotal = examPaperTotal / pageShow + 1;
        model.addObject("pageTotal", pageTotal);
        model.addObject("pageNow", startPage);

        return model;
    }

    @RequestMapping("/examPaper/{examPaperId}")
    public ModelAndView getCourseById(@PathVariable("examPaperId") Integer examPaperId) {
        ModelAndView model = new ModelAndView();
        model.setViewName("/admin/examPaperedit");

        ExamPaper paper = examPaperService.getExamPaper(examPaperId);
        model.addObject("examPaper", paper);

        return model;
    }

    @RequestMapping(value = "/examPaper/{examPaperId}", method = RequestMethod.DELETE)
    public String isDelTeacher(@PathVariable("examPaperId") Integer examPaperId) {

        int row = examPaperService.isDelExamPaper(examPaperId);
        return "redirect:/examPapers";
    }

    @RequestMapping(value = "/examPaper/examPaper", method = RequestMethod.POST)
    public String isUpdateOrAddCourse(
            @RequestParam(value = "examPaperId", required = false) Integer examPaperId,
            @RequestParam(value = "isupdate", required = false) Integer isUpdate,
            @RequestParam(value = "examPaperName", required = false) String examPaperName,
            @RequestParam("subjectNum") Integer subjectNum,
            @RequestParam("examPaperScore") Integer examPaperScore,
            @RequestParam("examPaperTime") Integer examPaperTime,
            @RequestParam("division") Integer division,
            @RequestParam("examPaperEasy") Integer examPaperEasy) {

        ExamPaper examPaper = new ExamPaper();
        examPaper.setExamPaperId(examPaperId);
        examPaper.setExamPaperName(examPaperName);
        examPaper.setSubjectNum(subjectNum);
        examPaper.setExamPaperScore(examPaperScore);
        examPaper.setExamPaperTime(examPaperTime);
        examPaper.setDivision(division);
        examPaper.setExamPaperEasy(examPaperEasy);

        if (isUpdate != null) {
            int row = examPaperService.isUpdateExamPaper(examPaper);
        } else {
            int row = examPaperService.isAddExamPaper(examPaper);
        }

        return "redirect:/examPapers";
    }


}
