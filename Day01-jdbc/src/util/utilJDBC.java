package util;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/*JDBC的工具类  目的：简化书写
   注册驱动抽取
   抽取一个方法获取连接对象
   抽取一个方法来释放资源*/
public class utilJDBC {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

     static{  // 静态代码块，获取值
       //1.创建Properties集合类
         try {  //2.加载文件
             Properties pro = new Properties(); // 获取Properties 的对象
             //获取src路径下的文件的方式---->class.loader 类加载器
             ClassLoader classLoader = utilJDBC.class.getClassLoader();
             URL res = classLoader.getResource("jdbc.properties");
             String path = res.getPath();
             System.out.println(path);
            // pro.load(new FileReader("src/jdbc.properties"));
             pro.load(new FileReader(path));
               //3.获取数据，并赋值
              url = pro.getProperty("url");
              user = pro.getProperty("user");
              password = pro.getProperty("password");
             //注册驱动
             Class.forName("drives");

         } catch (IOException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }

     }
    public static Connection getConnection() throws Exception { //抽取一个方法获取连接对象* 需求：不想传递参数（麻烦），
        // 还得保证工具类的通用性，解决：配置文件
        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Statement stat,Connection conn){  //抽取一个方法来释放资源
    /*  if(stat!=null){
          try {
              stat.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }  if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    close(null,stat,conn);
    }
    public static void close(ResultSet rt, Statement stat, Connection conn){  //释放方法
        if(rt!=null){
            try {
                rt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
