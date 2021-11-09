import com.example.mybatis_demo.User;
import com.example.mybatis_demo.UserDao;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author dzx
 * @data 2021/10/26 -9:56
 */
public class mybatisTest {
    @Test
    public void Test(){
        String resource = "mybatis-config1.xml";
        SqlSession session = null;
        try {
            InputStream inputStream=Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sessionFactory.openSession();
            UserDao userDao=session.getMapper(UserDao.class);
            for(User user:userDao.selectUser()){
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert session != null;
            session.close();
        }
    }
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mabatis-spring.xml");
        UserDao dao=context.getBean("userMapper", UserDao.class);
        for (User user:dao.selectUser()){
            System.out.println(user);
        }
    }
    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mabatis-spring.xml");
        UserDao dao=context.getBean("userMapper2", UserDao.class);
        for (User user:dao.selectUser()){
            System.out.println(user);
        }

    }

}
