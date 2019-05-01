package cn.daxalfred.demo.Servlce.Impl;

import cn.daxalfred.demo.Dao.ClassMapper;
import cn.daxalfred.demo.Entity.Classinfo;
import cn.daxalfred.demo.Entity.PageInfo;
import cn.daxalfred.demo.Servlce.ClassInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("ClassInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {

    @Resource
    private ClassMapper classMapper;

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
}
