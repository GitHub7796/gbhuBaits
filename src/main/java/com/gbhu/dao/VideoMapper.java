package com.gbhu.dao;

import com.gbhu.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface VideoMapper {
    /**
     * 根据id获取Video
     * Param 功能相当于给参数videoId，起了别名 video_id。
     *       在mapper.xml中可以使用 video_id
     *       多个参数必须有，不然会报错
     * @param videoId
     * @return
     */

//    Video selectById(int videoId);
    Video selectById(@Param("video_id") int videoId);

    @Select("select * from video")
    List<Video> selectList();

    List<Video> selectListByXML();

    List<Video> selectByPointAndTitleLike(@Param("point") double point,@Param("title") String title);

    int addVideo(Video video);

    int addBatch(List<Video> list);

    int updateById(Video video);
    int updateByIdActive(Video video);

    int deleteByTimeAndPrice(Map<String, Object> map);

    Video selectByResultMap(@Param("video_id") int video_id);
}
