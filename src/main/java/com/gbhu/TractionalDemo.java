package com.gbhu;

import com.gbhu.dao.VideoMapper;
import com.gbhu.dao.VideoOrderMapper;
import com.gbhu.domain.Video;
import com.gbhu.domain.VideoOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class TractionalDemo {
    public static void main(String[] args) throws IOException {
        String resouce = "config/mybatis-config.xml";
//读取配置⽂文件
        InputStream inputStream = Resources.getResourceAsStream(resouce);
//构建Session⼯⼚
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
//获取Session
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {

            VideoMapper videoMapper =
                    sqlSession.getMapper(VideoMapper.class);
            Video video = new Video();
            video.setPoint(10d);
            video.setPrice(10);
            video.setSummary("test");
            video.setCreateTime(new Date());
            video.setCoverImg("10dXXXIMG");
            video.setTitle("title");
            videoMapper.addVideo(video);
            System.out.println(video);
            int i = 1 / 0;
//            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
        sqlSession.close();
    }
}
