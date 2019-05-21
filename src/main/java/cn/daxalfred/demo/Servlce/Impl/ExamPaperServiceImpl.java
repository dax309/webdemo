package cn.daxalfred.demo.Servlce.Impl;

import cn.daxalfred.demo.Dao.ClassMapper;
import cn.daxalfred.demo.Dao.ExamPaperMapper;
import cn.daxalfred.demo.Dao.StudentMapper;
import cn.daxalfred.demo.Dao.SubjectInfoMapper;
import cn.daxalfred.demo.Entity.*;
import cn.daxalfred.demo.Servlce.ExamPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("ExamPaperService")
public class ExamPaperServiceImpl implements ExamPaperService {

    @Autowired
    private ExamPaperMapper examPaperMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private SubjectInfoMapper subjectInfoMapper;

    @Autowired
    private List<ExamSubjectMiddle> list;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<ExamPaper> getExamPapers(int startIndex, int pageShow) {
        return this.examPaperMapper.pageShow(startIndex,pageShow);
    }

    @Override
    public int getExamPpaerTotal() {
        return this.examPaperMapper.getExamPpaerTotal();
    }

    @Override
    public ExamPaper getExamPaper(int ID) {
        return this.examPaperMapper.getExamPaperById(ID);
    }

    @Override
    public int isDelExamPaper(int ID) {
        return this.examPaperMapper.isDelExamPaper(ID);
    }

    @Override
    public int isUpdateExamPaper(ExamPaper examPaper) {
        return this.examPaperMapper.isUpdateExamPaper(examPaper);
    }

    @Override
    public int isUpdateExamPaperScore(Map<String, Object> map) {
        return examPaperMapper.isUpdateExamPaperScore(map);
    }

    @Override
    public int isUpdateExamPaperSubjects(Map<String, Object> map) {
        return examPaperMapper.isUpdateExamPaperSubjects(map);
    }

    @Override
    public int isAddExamPaper(ExamPaper examPaper) {
        return this.examPaperMapper.isAddExamPaper(examPaper);
    }

    @Override
    public Integer getEsm(int a, int b) {
        return this.examPaperMapper.getEsmByExamIdWithSubject(a,b);
    }

    @Override
    public List<ExamSubjectMiddleInfo> getExamPaperWithSubject(int a) {
        ExamPaper examPaper=this.examPaperMapper.getExamPaperbyclassid(a);
        list=examPaperMapper.getExamPaperWithSubject(examPaper.getExamPaperId());
        List<ExamSubjectMiddleInfo> examSubjectMiddleInfos = new ArrayList<>();
        for (ExamSubjectMiddle i:list){
            ExamSubjectMiddleInfo examSubjectMiddleInfo = new ExamSubjectMiddleInfo();
            examSubjectMiddleInfo.setExamPaper(examPaper);
            examSubjectMiddleInfo.setSubject(this.subjectInfoMapper.getSubjectWithId(i.getSubjectid()));
            examSubjectMiddleInfo.setEsmId(i.getEsmId());
            examSubjectMiddleInfos.add(examSubjectMiddleInfo);
        }
        return examSubjectMiddleInfos;
    }

    @Override
    public int isAddESM(Map<String, Object> map) {
        return this.examPaperMapper.isAddESM(map);
    }

    @Override
    public List<Classinfo> selallname() {
        return this.classMapper.selallname();
    }

    @Override
    public int removeSubjectWithExamPaper(Map<String, Object> map) {
            return examPaperMapper.removeSubjectWithExamPaper(map);
    }
    @Override
    public ExamPaper getExamPaperbyclassid(int a) {
        return this.examPaperMapper.getExamPaperbyclassid(a);
    }

    @Override
    public int getHistoryInfoWithIds(Map<String, Object> map) {
        return examPaperMapper.getHistoryInfoWithIds(map);
    }

    @Override
    public List<ExamChooseInfo> getChooseInfoSumScore(int a,int b) {
        List<ExamChoose> chooseInfoWithSumScore = examPaperMapper.getChooseInfoSumScore(a, b);
        List<ExamChooseInfo> examChooseInfoList = new ArrayList<>();
        for (ExamChoose e:chooseInfoWithSumScore){
            ExamChooseInfo examChooseInfo = new ExamChooseInfo();
            examChooseInfo.setSubject(subjectInfoMapper.getSubjectWithId(e.getSubjectId()));
            examChooseInfo.setStudent(studentMapper.getStudentById(a));
            examChooseInfo.setExamPaper(examPaperMapper.getExamPaperById(b));
            examChooseInfo.setChooseId(e.getChooseId());
            examChooseInfo.setChooseResult(e.getChooseResult());
            examChooseInfoList.add(examChooseInfo);
        }
        System.out.println(examChooseInfoList);
        return examChooseInfoList;
    }

    @Override
    public List<ExamChooseInfo> getChooseInfoWithSumScore(Map<String, Object> map) {
        return examPaperMapper.getChooseInfoWithSumScore(map);
    }

    @Override
    public int addChoose(Map<String, Object> map) {
        return examPaperMapper.addChoose(map);
    }

    @Override
    public ExamChooseInfo getChooseWithIds(Map<String, Object> map) {
        return examPaperMapper.getChooseWithIds(map);
    }

    @Override
    public int updateChooseWithIds(ExamChooseInfo examChoose) {
        return examPaperMapper.updateChooseWithIds(examChoose);
    }

    @Override
    public List<SubjectInfo> getExamPaperSubject(int a) {
        List<Integer> list=examPaperMapper.getExamPaperSubject(a);
        List<SubjectInfo> subjectInfos = new ArrayList<SubjectInfo>();
        for (int i:list){
            SubjectInfo subjectWithId = this.subjectInfoMapper.getSubjectWithId(i);
            if (subjectWithId!=null){
                subjectInfos.add(subjectWithId);
            }
        }
        return subjectInfos;
    }

    @Override
    public int isAddExamHistory(Map<String, Object> map) {
        return examPaperMapper.isAddExamHistory(map);
    }

    @Override
    public int getClassid(int a) {
        return this.examPaperMapper.getClassid(a);
    }

}
