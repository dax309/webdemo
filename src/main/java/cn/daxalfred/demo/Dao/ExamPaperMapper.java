package cn.daxalfred.demo.Dao;

import cn.daxalfred.demo.Entity.ExamPaper;
import cn.daxalfred.demo.Entity.ExamSubjectMiddleInfo;
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
    int isDelExamPaper(int ID);
    int isUpdateExamPaper(ExamPaper examPaper);
    int isAddExamPaper(ExamPaper examPaper);
    int isUpdateExamPaperScore(Map<String, Object> map);
    int isUpdateExamPaperSubjects(Map<String, Object> map);
    Integer getEsmByExamIdWithSubject(@Param("examPaperId") int examPaperId, @Param("subjectId") int subjectId);
    int isAddESM(Map<String, Object> map);

    List<Integer> getExamPaperWithSubject(int a);
    int removeSubjectWithExamPaper(Map<String, Object> map);
}
