package cn.daxalfred.demo.Servlce.Impl;

import cn.daxalfred.demo.Dao.ExamPaperMapper;
import cn.daxalfred.demo.Entity.ExamPaper;
import cn.daxalfred.demo.Servlce.ExamPaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ExamPaperService")
public class ExamPaperServiceImpl implements ExamPaperService {

    @Resource
    private ExamPaperMapper examPaperMapper;

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
    public int isAddExamPaper(ExamPaper examPaper) {
        return this.examPaperMapper.isAddExamPaper(examPaper);
    }


}
