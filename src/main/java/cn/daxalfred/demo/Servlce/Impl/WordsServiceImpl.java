package cn.daxalfred.demo.Servlce.Impl;

import cn.daxalfred.demo.Dao.AdminMapper;
import cn.daxalfred.demo.Dao.StudentMapper;
import cn.daxalfred.demo.Dao.WordsMapper;
import cn.daxalfred.demo.Entity.Replywords;
import cn.daxalfred.demo.Entity.Words;
import cn.daxalfred.demo.Servlce.WordsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("WordsServiceImpl")
public class WordsServiceImpl implements WordsService {

    @Autowired
    private WordsMapper wordsMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private List<Words> wordsList;

    @Autowired
    private List<Replywords> replyworods;


    @Override
    public List<Words> selall(int a) {

        wordsList=wordsMapper.selall(a);
        if (wordsList != null){
            for (Words e:wordsList){
                if (e.getWordsType()==0){
                    e.setUname(studentMapper.getStudentName(e.getUID()));
                }else {
                    e.setUname(adminMapper.getadminName(e.getUID()));
                }
            }
        }
        return wordsList;
    }

    @Override
    public List<Replywords> selallrp(int id) {
        replyworods=this.wordsMapper.selallrp(id);
        for (Replywords repl:replyworods){
            if(repl.getReplyType() == 0){
                repl.setSname(studentMapper.getStudentName(repl.getSID()));
            }else {
                repl.setSname(adminMapper.getadminName(repl.getSID()));
            }
        }
        return replyworods;
    }

    @Override
    public int wordsadd(int uid, Date date, String content, int classId, int wordstype) {
        return this.wordsMapper.wordsadd(uid,date,content,classId,wordstype);
    }

    @Override
    public int replywords(int uid, Date date, String content, int classId, int wordstype, int replyID) {
        return this.wordsMapper.replywords(uid,date,content,classId,wordstype,replyID);
    }
}
