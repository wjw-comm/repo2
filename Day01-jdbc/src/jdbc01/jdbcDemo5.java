package jdbc01;

import jdbc02.stutb1;
import util.utilJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcDemo5 {
    public static void main(String[] args) {  //JDBC工具类的演示
        List<stutb1> list = new jdbcDemo5().findAll();
        System.out.println(list);
    }

    public List<stutb1> findAll() {
        ResultSet rt=null;
        Statement stat=null;
        Connection conn=null;
        List <stutb1> list=null;
        try {    //注册驱动
             utilJDBC.getConnection();
            //定义sql语句
            String sql="select * from stutb1";
            //获取SQL的执行对象
            stat = conn.createStatement();
            //执行sql
            rt = stat.executeQuery(sql);
            //遍历ResultSet结果集，封装对象装载集合
            stutb1 stu=null; //创建stutb1对象
            list=new ArrayList<>();

            while(rt.next()){
                String sname = rt.getString("sname");
                int age = rt.getInt("age");
                String sex = rt.getString("sex");
                String department = rt.getString("department");
                int score = rt.getInt("score");
                //创建stutb1对象,并赋值
                stu=new stutb1();
                stu.setSname(sname);
                stu.setAge(age);
                stu.setSex("sex");
                stu.setDepartment("department");
                stu.setScore(score);
                //装载集合
                list.add(stu);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //释放资源
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            utilJDBC.close(rt,stat,conn);
        }
        return list;
    }
}


