package cn.daxalfred.demo.Contraller;

import cn.daxalfred.demo.Entity.*;
import cn.daxalfred.demo.Servlce.ExamPaperService;
import cn.daxalfred.demo.Servlce.Impl.ClassInfoServiceImpl;
import cn.daxalfred.demo.Servlce.Impl.ExamPaperServiceImpl;
import com.google.gson.Gson;
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
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ExamPaperContraller {

    @Autowired
    private ExamPaperServiceImpl examPaperService;

    @Autowired
    private ClassInfoServiceImpl classInfoService;

    @Autowired
    private ExamSubjectMiddleInfo esm;

    @Autowired
    private SubjectInfo subject;

    @Autowired
    private ExamPaperServiceImpl esmService;

    @Autowired
    private ExamPaper examPaper;

    @Autowired
    private Gson gson;

    @Autowired
    private ExamChooseInfo examChoose;

    @RequestMapping("/examPapers")
    public ModelAndView getCourses(@RequestParam(value="startPage", required=false, defaultValue="1") Integer startPage,
                                   @RequestParam(value="pageShow", required=false, defaultValue="10") Integer pageShow ) {
        ModelAndView model = new ModelAndView();
        model.setViewName("/admin/examPapers");

        //计算当前查询起始数据索引
        int startIndex = (startPage-1) * pageShow;
        List<ExamPaper> examPapers = examPaperService.getExamPapers(startIndex,pageShow);
        model.addObject("examPapers", examPapers);
        model.addObject("subjects",esmService.selallname());
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
        List<Classinfo> classes = classInfoService.sellflower();
        model.addObject("classes",classes);
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

        examPaper.setExamPaperId(examPaperId);
        examPaper.setExamPaperName(examPaperName);
        examPaper.setSubjectNum(subjectNum);
        examPaper.setExamPaperScore(examPaperScore);
        examPaper.setExamPaperTime(examPaperTime);
        examPaper.setDivision(examPaperEasy);
        examPaper.setExamPaperEasy(division);

        if (isUpdate != null) {
            int row = examPaperService.isUpdateExamPaper(examPaper);
        } else {
            int row = examPaperService.isAddExamPaper(examPaper);
        }

        return "redirect:/examPapers";
    }

    @RequestMapping("/preAddExamPaper")
    public ModelAndView preAddStudent() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/admin/examPaperedit");
        List<Classinfo> classes = classInfoService.presellflower();
        model.addObject("classes",classes);
        return model;
    }

    @RequestMapping("/getChooseSubId")
    public void getChooseSubjectId(
            @RequestParam("subjectId") Integer subjectId,
            @RequestParam("examPaperId") Integer examPaperId,
            @RequestParam("score") Integer score,
            @RequestParam(value="handle", required=false) Integer handle,
            HttpSession session, HttpServletResponse response) throws IOException {
        List<String> ids = null;
        /*
         * 添加到 Session 中需先判断该试题是否已经存在该试卷中
         * 如果存在，则不进行添加；反之添加
         */
        examPaper.setExamPaperId(examPaperId);
        subject.setSubjectId(subjectId);
        esm.setExamPaper(examPaper);
        esm.setSubject(subject);
        /** 验证添加记录 是否已经存在 */
        Integer esmId = esmService.getEsm(examPaperId,subjectId);
        if (esmId == null) {
            ids = (List<String>) session.getAttribute("ids");
            /** Session 记录非空验证 */
            if (subjectId != null && score != null) {
                //第一次添加
                if (ids == null) {
                    ids = new ArrayList<String>();
                    ids.add((subjectId+","+score));
                } else {
                    //存在就移除,反之添加
                    if (ids.contains((subjectId+","+score))) {
                        ids.remove((subjectId+","+score));

                    } else {
                        ids.add((subjectId+","+score));
                    }
                }
            } else {
                response.getWriter().print("添加失败，试题编号或试题分数异常！");
                return;
            }
        } else {
            //同时返回添加失败的题号，用于前台方便移除选中
            response.getWriter().print("f-exists-"+subjectId);
            return;
        }
        session.setAttribute("ids", ids);
        response.getWriter().print("编号为 "+subjectId+" 的试题添加成功");
    }



    @RequestMapping(value="/handAdd", method={RequestMethod.GET, RequestMethod.POST})
    public void isHandAddSubjectToExamPaper(
            @RequestParam(value="examPaperId") Integer examPaperId,
            HttpSession session,
            HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("utf-8");
        //添加试题总分统计
        int scoreSum = 0;
        //添加试题总量统计
        int subjectSum = 0;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("examPaperId", examPaperId);
        ArrayList<Integer> subjectIds = new ArrayList<Integer>();
        //试题信息
        List<String> ids = (List<String>) session.getAttribute("ids");
        if (ids != null) {
            for (String is : ids) {
                //分割试题编号和分数
                String[] idAndScore = is.split(",");
                subjectIds.add(Integer.parseInt(idAndScore[0]));
                //累加试题分数
                scoreSum += Integer.parseInt(idAndScore[1]);
                //累加试题数量
                subjectSum += 1;
            }
            /** 需要添加试题集合 */
            map.put("subjectIds", subjectIds);
        } else {
            response.getWriter().print("需要添加的试题为空，操作失败！");
            return;
        }
        //总分和题目数量信息
        Map<String, Object> scoreWithNum = new HashMap<String, Object>();
        scoreWithNum.put("subjectNum", subjectSum);
        scoreWithNum.put("score", scoreSum);
        scoreWithNum.put("examPaperId", examPaperId);
        /** 修改试卷总分 */
        examPaperService.isUpdateExamPaperScore(scoreWithNum);
        /** 修改试卷试题总量 */
        examPaperService.isUpdateExamPaperSubjects(scoreWithNum);
        /** 添加试题到试卷中 */
        esmService.isAddESM(map);
        response.getWriter().print("试题已成功添加到试卷中！");
    }

    @RequestMapping(value="/getESM", method={RequestMethod.GET, RequestMethod.POST})
    public void getExamPaperWithSubject(
            @RequestParam(value="examPaperId", required=false) Integer examPaperId,
            HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        ModelAndView model = new ModelAndView();
        /*条件处理*/
        if (examPaperId != null) examPaper.setExamPaperId(examPaperId);
        esm.setExamPaper(examPaper);
        List<SubjectInfo> esms = esmService.getExamPaperSubject(examPaperId);
        response.getWriter().print(gson.toJson(esms));
    }


    @RequestMapping(value="/removeSubjectFromPaper", method={RequestMethod.GET, RequestMethod.POST})
    public void removeSubjectWithExamPaper(
            @RequestParam("subjectId") Integer subjectId,
            @RequestParam("examPaperId") Integer examPaperId,
            @RequestParam("score") Integer score,
            HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("subjectNum", (-1));
        map.put("score", (-score));
        map.put("examPaperId", examPaperId);
        map.put("subjectId", subjectId);
        //修改试卷总分
        examPaperService.isUpdateExamPaperScore(map);
        //修改试卷题目数量
        examPaperService.isUpdateExamPaperSubjects(map);
        //从试卷中移除试题
        esmService.removeSubjectWithExamPaper(map);
        response.getWriter().print("t");
    }


    @RequestMapping("/begin")
    public String beginExam(
            @RequestParam("classId") Integer classId,
            HttpSession session) {
        ModelAndView model = new ModelAndView();
        Student student = (Student) session.getAttribute("student");
        Date beginTimes = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String beginTime = formatter.format(beginTimes);
        ExamPaper examPaper1 = examPaperService.getExamPaperbyclassid(classId);
        /*
         * 查询该考试当前进入的试卷是否已经在历史记录中存在
         * 如果存在，则不能再次进入考试； 反之进入考试
         */
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", student.getID());
        map.put("examPaperId", examPaper1.getExamPaperId());
        int count = examPaperService.getHistoryInfoWithIds(map);
        if (count >= 1) {
            return "redirect:review?studentId="+student.getID()+"&examPaperId="+examPaper1.getExamPaperId()+"&classId="+classId;
        } else {
            model.setViewName("/reception/exam");
            esm.setExamPaper(examPaper1);
            //获取试卷 试题集合
            List<ExamSubjectMiddleInfo> esms = examPaperService.getExamPaperWithSubject(classId);
            //获取当前考生在当前试卷中已选答案记录
            System.out.println(esms);
            Map<String, Object> choosedMap = new HashMap<String, Object>();
            choosedMap.put("studentId", student.getID());
            choosedMap.put("examPaperId", examPaper1.getExamPaperId());
            List<ExamChooseInfo> chooses = examPaperService.getChooseInfoWithSumScore(choosedMap);
            if (chooses == null || chooses.size() == 0) {
                model.addObject("chooses", null);
            } else {
                model.addObject("chooses", chooses);
            }
            model.addObject("esms", esms);
            model.addObject("sumSubject", esms.size());
            model.addObject("examPaperId", examPaper1.getExamPaperId());
            model.addObject("examTime", examPaper1.getExamPaperTime());
            model.addObject("beginTime", beginTime);
            return "/reception/exam";
        }
    }

    @RequestMapping(value="/choose", method=RequestMethod.POST)
    public void examChooseHandler(
            @RequestParam("studentId") Integer studentId,
            @RequestParam("examPaperId") Integer examPaperId,
            @RequestParam("subjectId") Integer subjectId,
            @RequestParam(value="index", required=false) Integer index,
            @RequestParam("chooseAswer") String chooseAswer,
            HttpServletResponse response) throws IOException {
        //判断该考生是否已经选择过该试题
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("studentId", studentId);
        map.put("examPaperId", examPaperId);
        map.put("subjectId", subjectId);
        examChoose = examPaperService.getChooseWithIds(map);
        if (examChoose == null) {
            map.put("chooseResult", chooseAswer);
            examPaperService.addChoose(map);
        } else if (examChoose.getChooseId() != null && examChoose != null) {
            /*
             * 如果选择了和上次相同的答案，则不做修改操作
             * 优化 -- 前台判断选择了相同答案则不发出请求
             */
            if(!chooseAswer.equals(examChoose.getChooseResult())) {
                examChoose.setChooseResult(chooseAswer);
                examPaperService.updateChooseWithIds(examChoose);
            }
        } else {
            response.getWriter().print("f");
            return;
        }
        response.getWriter().print("t");
    }
}
