package cn.tekin.jpa.entity;

import javax.persistence.*;

/**
 * JPA 实体类
 * @Entity 声明该类为实体类
 * @Table
 *
 * @NamedQuery 命名查询 注解被定义为一个预定义的查询字符串，它是不可改变的查询。相反，动态查询，命名查询可以通过POJO分离JPQL
 * 查询字符串提高代码的组织。它也传送的查询参数，而不是动态地嵌入文本到查询字符串，并因此产生更高效的查询。
 *
 * query中的like查询 中的 % 需要在设置参数的时候增加，  如： query.setParameter("keywords", "%测试%");
 */
@Entity
@Table(name = "etest")
@NamedQuery(query = "Select e from Employee e where e.eid = :id or e.ename like  :keywords",
        name = "find_employee_by_id_or_keywords")
public class Employee
{
    /**
     * 一般我们使用 GenerationType.AUTO 自动选择主键生成策略，以适应不同的数据库移植。
     * 如果是 sqlserver 数据库, 使用GenerationType.AUTO ,不要配置  hibernate.id.new_generator_mappings=true
     * 如果是mysql数据库，且主键是设置自增，这里需要配置为 GenerationType.IDENTITY
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;
    private String ename;
    private double salary;
    private String deg;
    public Employee(int eid, String ename, double salary, String deg)
    {
        super( );
        this.eid = eid;
        this.ename = ename;
        this.salary = salary;
        this.deg = deg;
    }

    public Employee( )
    {
        super();
    }

    public int getEid( )
    {
        return eid;
    }
    public void setEid(int eid)
    {
        this.eid = eid;
    }
    public String getEname( )
    {
        return ename;
    }
    public void setEname(String ename)
    {
        this.ename = ename;
    }

    public double getSalary( )
    {
        return salary;
    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public String getDeg( )
    {
        return deg;
    }
    public void setDeg(String deg)
    {
        this.deg = deg;
    }
    @Override
    public String toString() {
        return "Employee [eid=" + eid + ", ename=" + ename + ", salary="
                + salary + ", deg=" + deg + "]";
    }
}