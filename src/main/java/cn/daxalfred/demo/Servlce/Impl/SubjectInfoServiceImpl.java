package cn.daxalfred.demo.Servlce.Impl;

import cn.daxalfred.demo.Dao.SubjectInfoMapper;
import cn.daxalfred.demo.Entity.SubjectInfo;
import cn.daxalfred.demo.Servlce.SubjectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SubjectInfoService")
public class SubjectInfoServiceImpl implements SubjectInfoService {

    @Resource
    private SubjectInfoMapper subjectInfoMapper;

    @Override
    public List<SubjectInfo> getSubjects(int startIndex, int pageShow) {
        return this.subjectInfoMapper.getSubjects(startIndex,pageShow);
    }

    @Override
    public int getSubjectTotal() {
        return this.subjectInfoMapper.getSubjectTotal();
    }

    @Override
    public int isDelSubject(int ID) {
        return this.subjectInfoMapper.isDelSubject(ID);
    }

    @Override
    public int isAddSubject(SubjectInfo subjectInfo) {
        return this.subjectInfoMapper.isAddSubject(subjectInfo);
    }

    @Override
    public SubjectInfo getSubjectWithId(int ID) {
        return this.subjectInfoMapper.getSubjectWithId(ID);
    }
}
