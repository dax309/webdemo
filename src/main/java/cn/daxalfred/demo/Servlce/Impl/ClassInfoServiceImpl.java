package cn.daxalfred.demo.Servlce.Impl;

import cn.daxalfred.demo.Dao.ClassMapper;
import cn.daxalfred.demo.Entity.classinfo;
import cn.daxalfred.demo.Servlce.ClassInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("ClassInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {

    @Resource
    private ClassMapper classMapper;

    @Override
    public List<classinfo> selAllp() {
        return (List<classinfo>) this.classMapper.selAllp();
    }

    @Override
    public List<classinfo> selAll(String pcode) {
        return this.classMapper.selAll(pcode);
    }
}
