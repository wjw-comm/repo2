package jdbc01;

import jdbc02.stutb1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*定义一个方法，查询job 表的数据，将其封装成对象然后装载集合并返回，再打印
 1. 定义一个 stutb1 类
 2.定义一个方法查找所有的数据并且返回值是（stutb1类型的）集合
 public list<job> findAll
 3.实现方法   select * from job     */
public class jdbcDemo4 {
    public static void main(String[] args) {
        jdbcDemo4 jd = new jdbcDemo4();
        List<stutb1> list = jd.findAll();//通过jdbcDemo4的对象 调用findAll()方法  返回一个集合
        System.out.println(list);
    }

    public List<stutb1> findAll() {
        ResultSet rt=null;
        Statement stat=null;
        Connection conn=null;
        List <stutb1> list=null;
        try {    //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
               //获取连接
             conn = DriverManager.getConnection("jdbc:mysql:///guiik", "root", "root");
            //定义sql语句
            String sql="select * from stutb1";
            //获取SQL的执行对象
             stat = conn.createStatement();
            //执行sql  (查询)
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
//                 stu=new stutb1();
//                 stu.setSname(sname);
//                 stu.setAge(age);
//                 stu.setSex("sex");
//                 stu.setDepartment("department");
//                 stu.setScore(score);
                stu=new stutb1(sname,age,sex,department,score);
                 //装载集合
                list.add(stu);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //释放资源
        finally {
            if(rt!=null){
                try {
                    rt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }  if(stat!=null){
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
            }
        }
        return list;
    }
}
