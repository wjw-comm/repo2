package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo1 {
    public static void main(String[] args) throws Exception {
       // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guiik", "root", "root");
        Connection con = DriverManager.getConnection("jdbc:mysql:///guiik", "root", "root");
        //4.定义SQL语句
        String sql="update sell set s_money = 20000 where s_id =1"; // 修改表里的数据
        //5.获取执行sql的对象。
        Statement stmt = con.createStatement();
        //6.执行sql语句
        int i = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(i);
        //8.释放资源
        con.close();
        stmt.close();

    }
}
