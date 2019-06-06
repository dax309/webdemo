package cn.daxalfred.demo.Entity;


import org.springframework.stereotype.Component;

@Component
public class ExamPaper{
    private Integer examPaperId;
    private String examPaperName;
    private int subjectNum;
    private int examPaperScore;
    //起错名了，错用 章节ID
    private int division;
    private int examPaperEasy;
    private int examPaperTime;

    public ExamPaper() {
    }

    public ExamPaper(Integer examPaperId, String examPaperName, int subjectNum, int examPaperScore, int division, int examPaperEasy, int examPaperTime) {
        this.examPaperId = examPaperId;
        this.examPaperName = examPaperName;
        this.subjectNum = subjectNum;
        this.examPaperScore = examPaperScore;
        this.division = division;
        this.examPaperEasy = examPaperEasy;
        this.examPaperTime = examPaperTime;
    }

    public Integer getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(Integer examPaperId) {
        this.examPaperId = examPaperId;
    }

    public String getExamPaperName() {
        return examPaperName;
    }

    public void setExamPaperName(String examPaperName) {
        this.examPaperName = examPaperName;
    }

    public int getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(int subjectNum) {
        this.subjectNum = subjectNum;
    }

    public int getExamPaperScore() {
        return examPaperScore;
    }

    public void setExamPaperScore(int examPaperScore) {
        this.examPaperScore = examPaperScore;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public int getExamPaperEasy() {
        return examPaperEasy;
    }

    public void setExamPaperEasy(int examPaperEasy) {
        this.examPaperEasy = examPaperEasy;
    }

    public int getExamPaperTime() {
        return examPaperTime;
    }

    public void setExamPaperTime(int examPaperTime) {
        this.examPaperTime = examPaperTime;
    }

    @Override
    public String toString() {
        return "ExamPaper{" +
                "examPaperId=" + examPaperId +
                ", examPaperName='" + examPaperName + '\'' +
                ", subjectNum=" + subjectNum +
                ", examPaperScore=" + examPaperScore +
                ", division=" + division +
                ", examPaperEasy=" + examPaperEasy +
                ", examPaperTime=" + examPaperTime +
                '}';
    }


}
