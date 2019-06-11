package cn.xingchen;

import cn.xingchen.mapper.OrderNodeInstancesMapper;
import cn.xingchen.model.OrderNodeInstances;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {


    public static void main(String[] args){


//        try {
//            String resource = "mybatis-config.xml";
//            InputStream inputStream  = Resources.getResourceAsStream(resource);
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            OrderNodeInstances orderNodeInstances = sqlSession.selectOne("mybatis.OrderNodeInstancesMapper.selectByPrimaryKey",1L);
//            System.out.println(orderNodeInstances.getId());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream  = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            OrderNodeInstancesMapper mapper = sqlSession.getMapper(OrderNodeInstancesMapper.class);
            OrderNodeInstances orderNodeInstances = mapper.selectByPrimaryKey(1L);
            System.out.println(orderNodeInstances.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
