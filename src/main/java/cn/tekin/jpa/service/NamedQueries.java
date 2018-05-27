package cn.tekin.jpa.service;

import cn.tekin.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class NamedQueries
{
    public static void main( String[ ] args )
    {
        EntityManagerFactory emfactory = Persistence.
                createEntityManagerFactory( "JPA" );
        EntityManager entitymanager = emfactory.
                createEntityManager();
        Query query = entitymanager.createNamedQuery(
                "find_employee_by_id_or_keywords");
        query.setParameter("id",1);
        query.setParameter("keywords", "%测试%");
        List<Employee> list = query.getResultList( );
        for( Employee e:list )
        {
            System.out.print("Employee ID :"+e.getEid( ));
            System.out.println("\t Employee Name :"+e.getEname( ));
        }
    }
}
