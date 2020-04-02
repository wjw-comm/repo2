package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo2 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stam=null;
        try {
             // 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
             conn= DriverManager.getConnection("jdbc:mysql:///guiik", "root", "root");
            //定义sql语句
            String sql=" insert into sell values (7,'喵喵',5,1000000,20000)"; //往sell表格里添加一列数据
            //获取执行sql的对象
            stam = conn.createStatement();
            //处理结果
            int i = stam.executeUpdate(sql);
            System.out.println(i);
            if(i>0){
                System.out.println("添加成功");
            } else if(i<0){
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {//释放资源
            if(stam!=null){
                try {
                    stam.close();
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
    }
