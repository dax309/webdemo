package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.*;

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
    List<ExamSubjectMiddleInfo> getExamPaperWithSubject(int a);
    int isAddESM(Map<String, Object> map);
    List<Classinfo> selallname();
    int removeSubjectWithExamPaper(Map<String, Object> map);
    ExamPaper getExamPaperbyclassid(int a);
    int getHistoryInfoWithIds(Map<String, Object> map);
    List<ExamChooseInfo> getChooseInfoWithSumScore(Map<String, Object> map);
    List<ExamChooseInfo> getChooseInfoSumScore(int a,int b);
    int addChoose(Map<String, Object> map);
    ExamChooseInfo getChooseWithIds(Map<String, Object> map);
    int updateChooseWithIds(ExamChooseInfo examChoose);
    List<SubjectInfo> getExamPaperSubject(int a);
    int isAddExamHistory(Map<String, Object> map);
    int getClassid(int a);
}
