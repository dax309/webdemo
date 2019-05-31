package cn.daxalfred.demo.Dao;

import cn.daxalfred.demo.Entity.Replywords;
import cn.daxalfred.demo.Entity.Words;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface WordsMapper {
    List<Words> selall(int classid);

    List<Replywords> selallrp(int id);

    int wordsadd(@Param("uid") int uid,@Param("date") Date date,@Param("content") String content, @Param("classId") int classId, @Param("wordstype") int wordstype);

    int replywords(@Param("uid") int uid,@Param("date") Date date,@Param("content") String content,@Param("classId") int classId,@Param("wordstype") int wordstype,@Param("replyID") int replyID);
}
