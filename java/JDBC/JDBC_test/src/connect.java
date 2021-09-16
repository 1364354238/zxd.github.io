import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * @author dzx
 * @date 2021/9/8 -12:41
 */
public class connect {
    public static void main(String[] args) {
       Integer []a=new Integer[2];

    }
//    方式一
    @Test
    public void testConnection() throws SQLException{

        Driver driver=new com.mysql.cj.jdbc.Driver();
/*        jdbc:mysql 协议
          localhost:IP地址
          3306：默认MySQL端口号
          test：test数据库
          serverTimezone=GMT%2B8 :时区
 */
        String url="jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
//      将用户名和密码封装在properties中
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","510510");
        Connection conn=driver.connect(url,info);
        System.out.println(conn);
    }

//  方式二，使程序具有更好的移植性
        @Test
        public void testConnection2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
//        使用反射获取Driver实例
//            1.获取类对象
            Class<?> clz = Class.forName("com.mysql.cj.jdbc.Driver");
//            2.通过反射创建类对象
            Driver driver= (Driver) clz.getDeclaredConstructor().newInstance();

        //     提供要连接的数据库
            String url="jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
//            提供用户名和密码
            Properties info=new Properties();
            info.setProperty("user","root");
            info.setProperty("password","510510");
//            获取连接
            Connection conn=driver.connect(url,info);
            System.out.println(conn);
        }

//        方法三 使用DiverManager 替换Driver
    @Test
    public void testconnect3() throws Exception{

//        获取driver实例
        Class<?> cls = Class.forName("com.mysql.cj.jdbc.Driver");

        Driver driver = (Driver) cls.getDeclaredConstructor().newInstance();
        System.out.println(driver.getClass());
//        注册驱动
        DriverManager.registerDriver(driver);

//        提供连接信息
        String url="jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        String user="root";
        String password = "510510";
//        获取连接
        Connection conn=DriverManager.getConnection(url, user, password);
        System.out.println(conn);


    }

//        方法四 省略注册驱动
    @Test
    public void testconnect4() throws Exception{
//        获取Driver类,加载Driver时会默认注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//        注册驱动
//        DriverManager.registerDriver(driver);

//        提供连接信息
        String url="jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        String user="root";
        String password = "510510";


//        获取连接
        Connection conn=DriverManager.getConnection(url, user, password);
        System.out.println(conn);


    }

//        方法五 将数据库连接需要的4个基本信息声明在配置文件当中
    @Test
    public void testconnect5() throws Exception{
//      读取配置文件当中的配置信息
        InputStream is=connect.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(is);

        String url=pro.getProperty("url");
        String user=pro.getProperty("user");
        String password = pro.getProperty("password");
        String driverClass = pro.getProperty("driverClass");

//      加载驱动
        Class.forName(driverClass);
//        获取连接
        Connection conn=DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }

}



