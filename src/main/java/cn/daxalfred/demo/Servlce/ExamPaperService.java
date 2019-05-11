package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.ExamPaper;

import java.util.List;

public interface ExamPaperService {
    List<ExamPaper> getExamPapers(int startIndex,int pageShow);
    int getExamPpaerTotal();

    ExamPaper getExamPaper(int ID);

    int isDelExamPaper(int ID);
    int isUpdateExamPaper(ExamPaper examPaper);
    int isAddExamPaper(ExamPaper examPaper);
}
