package cn.tekin.jpa.service;

import cn.tekin.jpa.entity.Department;
import cn.tekin.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @OneToOne 关系
 *
 * 在一对一关系，一个项可以链接到只能另一个项。这意味着一个实体中的每一行被称为一个且仅一个行对另一个实体。
 *
 * 让我们考虑上面的例子。Employee和Department在反向单向的方式，关系是一对一的关系。这意味着每个员工只能属于一个部门。
 * 在Eclipse中创建一个IDE JPA项目命名JPA_Eclipselink_OTO。这个项目的所有模块下面讨论。
 */
public class OneToOne
{
    public static void main(String[] args)
    {
        EntityManagerFactory emfactory = Persistence.
                createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager entitymanager = emfactory.
                createEntityManager( );
        entitymanager.getTransaction( ).begin( );

        //Create Department Entity
        Department department = new Department();
        department.setName("Development");

        //Store Department
        entitymanager.persist(department);

        //Create Employee Entity
        Employee employee = new Employee();
        employee.setEname("Satish");
        employee.setSalary(45000.0);
        employee.setDeg("Technical Writer");
        employee.setDepartment(department);

        //插入第二个职员
        Employee employee1 = new Employee();
        employee1.setEname("Tekin");
        employee1.setSalary(99999.99);
        employee1.setDeg("我是CTO");
        employee1.setDepartment(department);

        //Store Employee
        entitymanager.persist(employee);
        entitymanager.persist(employee1);

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }
}