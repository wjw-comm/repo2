package jdbc02;
/*封装 job 表数据的类*/
public class stutb1 {
    private String sname;
    private int age;
    private String sex;
    private String department;
    private int score;

    public stutb1() {
    }

    public stutb1(String sname, int age, String sex, String department, int score) {
        this.sname = sname;
        this.age = age;
        this.sex = sex;
        this.department = department;
        this.score = score;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "stutb1{" +
                "sname='" + sname + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", department='" + department + '\'' +
                ", score=" + score +
                '}';
    }
}
