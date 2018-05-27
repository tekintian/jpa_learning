package cn.tekin.jpa.service;

import cn.tekin.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateEmployee
{
    public static void main( String[ ] args )
    {
        EntityManagerFactory emfactory = Persistence.
                createEntityManagerFactory( "JPA" );
        EntityManager entitymanager = emfactory.
                createEntityManager( );
        entitymanager.getTransaction( ).begin( );
        Employee employee=entitymanager.find(Employee.class,6);
//        Employee employee=entitymanager. find( Employee.class, 1201 );
        //before update
        System.out.println( employee.toString() );

        employee.setSalary( 6666 );
        employee.setEname("六六六");
        employee.setDeg("麻溜的");

        entitymanager.getTransaction( ).commit( );
        //after update
        System.out.println( employee );
        entitymanager.close();
        emfactory.close();
    }
}
