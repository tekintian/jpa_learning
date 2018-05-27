package cn.tekin.jpa.service;

import cn.tekin.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BetweenAndLikeFunctions
{
    public static void main( String[ ] args )
    {
        EntityManagerFactory emfactory = Persistence.
                createEntityManagerFactory( "JPA" );
        EntityManager entitymanager = emfactory.
                createEntityManager();
        //Between
        Query query = entitymanager.
                createQuery( "Select e " +
                        "from Employee e " +
                        "where e.salary " +
                        "Between 300 and 20000" );
        List<Employee> list=(List<Employee>)query.getResultList( );

        for( Employee e:list )
        {
            System.out.print("Employee ID :"+e.getEid( ));
            System.out.println("\t Employee salary :"+e.getSalary( ));
        }

        //Like
        Query query1 = entitymanager.
                createQuery("Select e " +
                        "from Employee e " +
                        "where e.ename LIKE '我%'");
        List<Employee> list1=(List<Employee>)query1.getResultList( );
        for( Employee e:list1 )
        {
            System.out.print("Employee ID :"+e.getEid( ));
            System.out.println("\t Employee name :"+e.getEname( ));
        }
    }
}
