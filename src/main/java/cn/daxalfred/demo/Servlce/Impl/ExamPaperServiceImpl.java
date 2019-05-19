package cn.daxalfred.demo.Servlce.Impl;

import cn.daxalfred.demo.Dao.ClassMapper;
import cn.daxalfred.demo.Dao.ExamPaperMapper;
import cn.daxalfred.demo.Dao.SubjectInfoMapper;
import cn.daxalfred.demo.Entity.Classinfo;
import cn.daxalfred.demo.Entity.ExamPaper;
import cn.daxalfred.demo.Entity.SubjectInfo;
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
    public List<SubjectInfo> getExamPaperWithSubject(int a) {
        List<Integer> list=examPaperMapper.getExamPaperWithSubject(a);

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
}
