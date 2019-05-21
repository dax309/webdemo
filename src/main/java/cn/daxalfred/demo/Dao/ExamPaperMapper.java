package cn.daxalfred.demo.Dao;

import cn.daxalfred.demo.Entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExamPaperMapper {
    int getExamPpaerTotal();
    int isDelExamPaper(int ID);
    int isUpdateExamPaper(ExamPaper examPaper);
    int isAddExamPaper(ExamPaper examPaper);
    int isUpdateExamPaperScore(Map<String, Object> map);
    int isUpdateExamPaperSubjects(Map<String, Object> map);
    int isAddESM(Map<String, Object> map);
    int removeSubjectWithExamPaper(Map<String, Object> map);
    int getHistoryInfoWithIds(Map<String, Object> map);
    int addChoose(Map<String, Object> map);
    int updateChooseWithIds(ExamChooseInfo examChoose);
    int isAddExamHistory(Map<String, Object> map);
    int getClassid(int a);
    ExamPaper getExamPaperById(int ID);
    ExamPaper getExamPaperbyclassid(int ID);
    ExamChooseInfo getChooseWithIds(Map<String, Object> map);
    Integer getEsmByExamIdWithSubject(@Param("examPaperId") int examPaperId, @Param("subjectId") int subjectId);
    List<ExamPaper> pageShow(@Param("startIndex") int startIndex, @Param("pageShow") int pageShow);
    List<ExamSubjectMiddle> getExamPaperbyexam(int ID);
    List<ExamSubjectMiddle> getExamPaperWithSubject(int a);
    List<ExamChooseInfo> getChooseInfoWithSumScore(Map<String, Object> map);
    List<ExamChoose> getChooseInfoSumScore(@Param("studentId") int a,@Param("examPaperId") int b);
    List<Integer> getExamPaperSubject(int a);
}
