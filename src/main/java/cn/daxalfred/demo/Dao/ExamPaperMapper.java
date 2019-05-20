package cn.daxalfred.demo.Dao;

import cn.daxalfred.demo.Entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExamPaperMapper {
    List<ExamPaper> pageShow(@Param("startIndex") int startIndex, @Param("pageShow") int pageShow);
    int getExamPpaerTotal();
    ExamPaper getExamPaperById(int ID);
    ExamPaper getExamPaperbyclassid(int ID);
    List<ExamSubjectMiddle> getExamPaperbyexam(int ID);
    int isDelExamPaper(int ID);
    int isUpdateExamPaper(ExamPaper examPaper);
    int isAddExamPaper(ExamPaper examPaper);
    int isUpdateExamPaperScore(Map<String, Object> map);
    int isUpdateExamPaperSubjects(Map<String, Object> map);
    Integer getEsmByExamIdWithSubject(@Param("examPaperId") int examPaperId, @Param("subjectId") int subjectId);
    int isAddESM(Map<String, Object> map);
    List<ExamSubjectMiddle> getExamPaperWithSubject(int a);
    int removeSubjectWithExamPaper(Map<String, Object> map);
    int getHistoryInfoWithIds(Map<String, Object> map);
    List<ExamChooseInfo> getChooseInfoWithSumScore(Map<String, Object> map);
    ExamChooseInfo getChooseWithIds(Map<String, Object> map);
    int addChoose(Map<String, Object> map);
    int updateChooseWithIds(ExamChooseInfo examChoose);
    List<Integer> getExamPaperSubject(int a);

}
