package cn.daxalfred.demo.Servlce.Impl;

import cn.daxalfred.demo.Dao.ClassMapper;
import cn.daxalfred.demo.Dao.ExamPaperMapper;
import cn.daxalfred.demo.Entity.*;
import cn.daxalfred.demo.Servlce.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service("ClassInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {

    @Resource
    private ClassMapper classMapper;

    @Autowired
    private ExamPaperMapper examPaperMapper;

    @Autowired
    private List<Classinfo> classes;

    @Autowired
    private List<ExamPaper> examPapers;



    @Override
    public List<Classinfo> selAllp() {
        return (List<Classinfo>) this.classMapper.selAllp();
    }

    @Override
    public List<Classinfo> selAll(String pcode) {
        return this.classMapper.selAll(pcode);
    }


    @Override
    public PageInfo showPage(String pcode,int pageSize, int pageNumber) {

        PageInfo pi = new PageInfo();
        pi.setPageNumber(pageNumber);
        pi.setPageSize(pageSize);
        int pageStart = pageSize * (pageNumber - 1);
        pi.setList(this.classMapper.selByPage(pcode,pageStart,pageSize));
        long count = this.classMapper.selCount(pcode);
        pi.setTotal(count%pageSize == 0?count/pageSize:count/pageSize+1);
        return pi;
    }

    @Override
    public PageInfo selAlltwoByPage(int flower, int pageSize, int pageNumber) {
        PageInfo pi = new PageInfo();
        pi.setPageNumber(pageNumber);
        pi.setPageSize(pageSize);
        int pageStart = pageSize * (pageNumber - 1);
        pi.setList(this.classMapper.selAlltwoByPage(flower,pageStart,pageSize));
        long count = this.classMapper.seltwoCount();
        pi.setTotal(count%pageSize == 0?count/pageSize:count/pageSize+1);
        return pi;
    }

    @Override
    public Classinfo selcode(String code) {
        return this.classMapper.selcode(code);
    }

    @Override
    public List<Classinfo> selflowerone(String code) {
        Classinfo classinfos = this.classMapper.selone(code);   //章
        Classinfo classinfos1 = this.classMapper.selone(classinfos.getPcode());   //课程
        List<Classinfo> classinfoList = new ArrayList<>();
        List<Classinfo> classinfoList2 = new ArrayList<>();
        if (classinfos1 != null){
            classinfoList = this.classMapper.selAllpbycode(classinfos1.getCode());  //所有章
            for (Classinfo classinfo2:classinfoList){
                List<Classinfo> classinfoList1 = new ArrayList<>();
                classinfoList1=this.classMapper.selAllpbycode(classinfo2.getCode());
                if (classinfoList1 != null){
                    for (Classinfo classinfo:classinfoList1){
                        classinfoList2.add(classinfo);
                    }
                }

            }
        }
        return classinfoList2;
    }

    @Override
    public List<Classinfo> sellflower() {
        return this.classMapper.sellflower(3);
    }

    @Override
    public String getclassinfobyid(int a) {
        return this.classMapper.getclassinfobyid(a);
    }

    @Override
    public List<Classinfo> presellflower() {
        classes=this.classMapper.sellflower(3);
        examPapers=this.examPaperMapper.selall();
        for (int i = 0;i<classes.size();i++ ){
            for (ExamPaper e:examPapers){
                if (classes.get(i).getID()==e.getDivision()){
                    classes.remove(i);
                }
            }
        }
        return classes;
    }

    @Override
    public List<notice> selallnotices() {
        return this.classMapper.selallnotices();
    }

    @Override
    public List<Classinfo> selallpbycode(String code) {
        return this.classMapper.selAllpbycode(code);
    }

    @Override
    public int learnhistory(int id,int studentid) {
        int a = this.classMapper.sellearinhistory(studentid);
        if (a == 0){
            return this.classMapper.learnhistory(id,studentid);
        }else {
            return this.classMapper.updatelearnhistory(id,studentid);
        }
    }

    @Override
    public int sellearnhistory(int parseInt) {
        int i = 0;
        learnhistory a = this.classMapper.sellearnhistory(parseInt);
        if (a != null){
            i = a.getClassID();
        }
        return i;
    }

    @Override
    public String getdownfile(int parseInt) {
        return this.classMapper.getdownfile(parseInt);
    }
}