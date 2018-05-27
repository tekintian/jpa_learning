package cn.tekin.jpa.service;

import cn.tekin.jpa.entity.Banji;
import cn.tekin.jpa.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class ManyToMany
{
    public static void main(String[] args)
    {
        EntityManagerFactory emfactory = Persistence.
                createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager entitymanager = emfactory.
                createEntityManager( );
        entitymanager.getTransaction( ).begin( );

        //Create Clas Entity
        Banji clas1=new Banji(0,"1st",null);
        Banji clas2=new Banji(0,"2nd",null);
        Banji clas3=new Banji(0,"3rd",null);

        //Store Banji
        entitymanager.persist(clas1);
        entitymanager.persist(clas2);
        entitymanager.persist(clas3);

        //Create Clas Set1
        Set<Banji> classSet1 = new HashSet();
        classSet1.add(clas1);
        classSet1.add(clas2);
        classSet1.add(clas3);

        //Create Clas Set2
        Set<Banji> classSet2 = new HashSet();
        classSet2.add(clas3);
        classSet2.add(clas1);
        classSet2.add(clas2);

        //Create Clas Set3
        Set<Banji> classSet3 = new HashSet();
        classSet3.add(clas2);
        classSet3.add(clas3);
        classSet3.add(clas1);

        //Create Teacher Entity
        Teacher teacher1 = new Teacher(0,
                "Satish","Java",classSet1);
        Teacher teacher2 = new Teacher(0,
                "Krishna","Adv Java",classSet2);
        Teacher teacher3 = new Teacher(0,
                "Masthanvali","DB2",classSet3);

        //Store Teacher
        entitymanager.persist(teacher1);
        entitymanager.persist(teacher2);
        entitymanager.persist(teacher3);

        entitymanager.getTransaction( ).commit( );
        entitymanager.close( );
        emfactory.close( );
    }
}