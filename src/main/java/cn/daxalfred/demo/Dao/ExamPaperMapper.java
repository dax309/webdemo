package cn.daxalfred.demo.Dao;

import cn.daxalfred.demo.Entity.ExamPaper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamPaperMapper {
    List<ExamPaper> pageShow(@Param("startIndex") int startIndex, @Param("pageShow") int pageShow);
    int getExamPpaerTotal();

    ExamPaper getExamPaperById(int ID);

    int isDelExamPaper(int ID);
    int isUpdateExamPaper(ExamPaper examPaper);
    int isAddExamPaper(ExamPaper examPaper);
}
