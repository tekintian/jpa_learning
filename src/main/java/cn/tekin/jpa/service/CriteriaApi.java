package cn.tekin.jpa.service;

import cn.tekin.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaApi
{
    public static void main(String[] args)
    {
        EntityManagerFactory emfactory = Persistence.
                createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager entitymanager = emfactory.
                createEntityManager( );

        CriteriaBuilder cb=entitymanager.getCriteriaBuilder();

        CriteriaQuery<Object> cq=cb.createQuery();

        Root<Employee> from = cq.from(Employee.class);

        //select all records
        System.out.println("Select all records");
        CriteriaQuery<Object> select =cq.select(from);
        TypedQuery<Object> typedQuery = entitymanager
                .createQuery(select);
        List<Object> resultlist= typedQuery.getResultList();

        for(Object o:resultlist)
        {
            Employee e=(Employee)o;
            System.out.println("EID : "+e.getEid()
                    +" Ename : "+e.getEname());
        }

        //Ordering the records
        System.out.println("Select all records by follow ordering");
        CriteriaQuery<Object> select1 = cq.select(from);
        select1.orderBy(cb.asc(from.get("ename")));
        TypedQuery<Object> typedQuery1 = entitymanager
                .createQuery(select);
        List<Object> resultlist1= typedQuery1.getResultList();

        for(Object o:resultlist1)
        {
            Employee e=(Employee)o;
            System.out.println("EID : "+e.getEid()
                    +" Ename : "+e.getEname());
        }

        entitymanager.close( );
        emfactory.close( );
    }
}
