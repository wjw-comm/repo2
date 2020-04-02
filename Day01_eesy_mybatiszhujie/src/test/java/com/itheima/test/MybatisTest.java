package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取sqlsessionfactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //使用factory工厂对象获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //使用sqlsession对象获取dao层接口的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //使用代理对象执行方法
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        //释放资源
        sqlSession.close();
        in.close();
    }
}
