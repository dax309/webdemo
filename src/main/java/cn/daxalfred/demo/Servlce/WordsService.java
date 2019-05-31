package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.Replywords;
import cn.daxalfred.demo.Entity.Words;

import java.util.Date;
import java.util.List;

public interface WordsService {
    List<Words> selall(int a);
    List<Replywords> selallrp(int id);

    int wordsadd(int uid, Date date, String content, int classId, int wordstype);

    int replywords(int uid, Date date, String content, int classId, int wordstype, int replyID);
}
