package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.Classinfo;
import cn.daxalfred.demo.Entity.ExamPaper;
import cn.daxalfred.demo.Entity.ExamSubjectMiddleInfo;
import cn.daxalfred.demo.Entity.SubjectInfo;

import java.util.List;
import java.util.Map;

public interface ExamPaperService {
    List<ExamPaper> getExamPapers(int startIndex,int pageShow);
    int getExamPpaerTotal();
    ExamPaper getExamPaper(int ID);
    int isDelExamPaper(int ID);
    int isUpdateExamPaper(ExamPaper examPaper);
    int isUpdateExamPaperScore(Map<String, Object> scoreWithNum);
    int isUpdateExamPaperSubjects(Map<String, Object> scoreWithNum);
    int isAddExamPaper(ExamPaper examPaper);
    Integer getEsm(int a, int b);
    List<SubjectInfo> getExamPaperWithSubject(int a);
    int isAddESM(Map<String, Object> map);
    List<Classinfo> selallname();
    public int removeSubjectWithExamPaper(Map<String, Object> map);
}
