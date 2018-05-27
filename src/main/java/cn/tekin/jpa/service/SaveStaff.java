package cn.tekin.jpa.service;

import cn.tekin.jpa.entity.NonTeachingStaff;
import cn.tekin.jpa.entity.TeachingStaff;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SaveStaff
{
    public static void main( String[ ] args )
    {
        EntityManagerFactory emfactory = Persistence.
                createEntityManagerFactory( "JPA" );
        EntityManager entitymanager = emfactory.
                createEntityManager( );
        entitymanager.getTransaction( ).begin( );

        //Teaching staff entity
        TeachingStaff ts1=new TeachingStaff(
                1,"Tekin","MSc MEd","Maths");
        TeachingStaff ts2=new TeachingStaff(
                2, "Manisha", "BSc BEd", "English");
        //Non-Teaching Staff entity
        NonTeachingStaff nts1=new NonTeachingStaff(
                3, "Satish", "Accounts");
        NonTeachingStaff nts2=new NonTeachingStaff(
                4, "Krishna", "Office Admin");

        //storing all entities
        entitymanager.persist(ts1);
        entitymanager.persist(ts2);
        entitymanager.persist(nts1);
        entitymanager.persist(nts2);

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }
}