package jdbc01;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcDemo3 {
    public static void main(String[] args)  {  //jdbc查询表里的数据
        ResultSet rt=null;
        Statement stat=null;
        Connection conn=null;
        try {//注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
             conn = DriverManager.getConnection("jdbc:mysql:///guiik", "root", "root");
            //定义sql语句
            String sql="select * from sell";
            // 获取sql的执行对象
             stat = conn.createStatement();
           // PreparedStatement ps = conn.prepareStatement();
            rt = stat.executeQuery(sql);
             while(rt.next()){
                 int s_id = rt.getInt("s_id");
                 String s_name = rt.getString("s_name");
                 int s_sellnumbers = rt.getInt("s_sellnumbers");
                 int s_sellmoney = rt.getInt("s_sellmoney");
                 int s_money = rt.getInt("s_money");
                 System.out.println(s_id+"--" + s_name+"--"+ s_sellnumbers+"--"+ s_sellmoney+"--" + s_money);
             }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
}
