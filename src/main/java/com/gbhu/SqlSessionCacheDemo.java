package com.gbhu;

import com.gbhu.dao.UserMapper;
import com.gbhu.dao.VideoMapper;
import com.gbhu.domain.User;
import com.gbhu.domain.Video;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SqlSessionCacheDemo {
    public static void main(String[] args) throws IOException {
        String resouce = "config/mybatis-config.xml";
//读取配置⽂文件
        InputStream inputStream = Resources.getResourceAsStream(resouce);
//构建Session⼯⼚
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
//获取Session
        try {
            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            VideoMapper videoMapper =
                    sqlSession1.getMapper(VideoMapper.class);
            List<Video> list = videoMapper.selectListByXML();
            System.out.println(list);
            sqlSession1.commit();
            SqlSession sqlSession2 = sqlSessionFactory.openSession();
            VideoMapper videoMapper2 =
                    sqlSession2.getMapper(VideoMapper.class);
            List<Video> list2 = videoMapper.selectListByXML();
            System.out.println(list2);
            sqlSession1.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
