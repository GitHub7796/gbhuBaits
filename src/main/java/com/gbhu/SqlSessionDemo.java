package com.gbhu;

import com.gbhu.dao.UserMapper;
import com.gbhu.dao.VideoMapper;
import com.gbhu.dao.VideoOrderMapper;
import com.gbhu.domain.User;
import com.gbhu.domain.Video;
import com.gbhu.domain.VideoOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SqlSessionDemo {
    public static void main(String[] args) throws IOException {
        String resouce = "config/mybatis-config.xml";
//读取配置⽂文件
        InputStream inputStream = Resources.getResourceAsStream(resouce);
//构建Session⼯⼚
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
//获取Session
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            VideoMapper videoMapper =
                    sqlSession.getMapper(VideoMapper.class);
//
//            Video video = videoMapper.selectById(44);
//            System.out.println(video.toString());
            //xml配置 和 注解配置 对比
//            List<Video> videoList = videoMapper.selectList();
//            System.out.println(videoList.toString());
//            List<Video> videoList1 = videoMapper.selectListByXML();
//            System.out.println(videoList1.toString());

//            List<Video> videoList1 = videoMapper.selectByPointAndTitleLike(8.7,"HTML");
//            System.out.println(videoList1.toString());

            //resuletMap
//            Video video = videoMapper.selectByResultMap(44);
//            System.out.println(video.toString());
//插入
//            Video video = new Video();
//            video.setCoverImg("123");
//            video.setSummary("Summary");
//            video.setTitle("titleTest");
//            video.setCoverImg("CoverImg");
//            video.setCreateTime(new Date());
//            video.setPrice(10);
//            video.setPoint(9.8d);
//            Integer id = videoMapper.addVideo(video);
//            System.out.println(video);

//批量插入
//            Video video = new Video();
//            video.setCoverImg("Img1");
//            video.setSummary("Summary1");
//            video.setTitle("titleTest1");
//            video.setCoverImg("CoverImg1");
//            video.setCreateTime(new Date());
//            video.setPrice(10);
//            video.setPoint(9.8d);
//            Video video2 = new Video();
//            video2.setCoverImg("Img2");
//            video2.setSummary("Summary2");
//            video2.setTitle("titleTest2");
//            video2.setCoverImg("CoverImg2");
//            video2.setCreateTime(new Date());
//            video2.setPrice(10);
//            video2.setPoint(9.8d);
//            List<Video> videos = new ArrayList<>();
//            videos.add(video);
//            videos.add(video2);
//            Integer rows= videoMapper.addBatch(videos);
//            System.out.println(videos);

            //更新
//            Video video = new Video();
//            video.setCoverImg("Img4");
//            video.setVideoId(55);
////            int row=videoMapper.updateById(video);
////            System.out.println(row);
//            //为空不更新
//            int row=videoMapper.updateByIdActive(video);
//            System.out.println(row);

//            Map map = new HashMap();
//            map.put("createTime", "2023-08-10 00:00:00");
//            map.put("price", 500);
//            videoMapper.deleteByTimeAndPrice(map);
//            sqlSession.commit();//不提交，数据库会没有数据
            //复杂查询 一多一
//            VideoOrderMapper videoOrderMapper =
//                    sqlSession.getMapper(VideoOrderMapper.class);
//            VideoOrder videoOrder = videoOrderMapper.selectOrderAndUser(1);
//            System.out.println(videoOrder.toString());
            //复杂查询一对多
//            UserMapper userMapper=
//                    sqlSession.getMapper(UserMapper.class);
//           User users= userMapper.selectUserOrder(6);
//            System.out.println(users.toString());
            //懒加载
            VideoOrderMapper videoOrderMapper=
                    sqlSession.getMapper(VideoOrderMapper.class);
            VideoOrder videoOrder=videoOrderMapper.selectOrderAndUserLazy(2);
            System.out.println(videoOrder);
//            System.out.println(videoOrder.getVideoTitle());
//            System.out.println(videoOrder.getUser().getName());
        }
    }
}
