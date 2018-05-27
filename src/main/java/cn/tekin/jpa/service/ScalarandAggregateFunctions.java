package cn.tekin.jpa.service;

import cn.tekin.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ScalarandAggregateFunctions
{
    public static void main( String[ ] args )
    {
        EntityManagerFactory emfactory = Persistence.
                createEntityManagerFactory( "JPA" );
        EntityManager entitymanager = emfactory.
                createEntityManager();

        //返回对象的查询
        Query query = entitymanager.
                createQuery("Select e from Employee e");
        List<Employee> list=query.getResultList();

        for(Employee e:list)
        {
            System.out.println("Employee Name:"+e.getEname()+" EID:"+e.getEid());
        }
        //返回字符串
        Query querys = entitymanager.createQuery("select e.ename from Employee  e");
        List<String> lists=querys.getResultList();
        for (String val: lists
             ) {
            System.out.println(" name:" + val);
        }

        //Aggregate function
        Query query1 = entitymanager.
                createQuery("Select MAX(e.salary) from Employee e");
        Double result=(Double) query1.getSingleResult();
        System.out.println("Max Employee Salary :"+result);
    }
}
