package cn.tekin.jpa.service;

import cn.tekin.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteEmployee {
    public static void main(String[] args) {
        EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager=emfactory.createEntityManager();
        //开始事务
        entityManager.getTransaction().begin();
        //创建指定的Employee对象
        Employee employee=entityManager.find(Employee.class, 3);

        //删除对象
        entityManager.remove(employee);

        //提交事务
        entityManager.getTransaction().commit();

        //关闭资源
        entityManager.close();
        emfactory.close();

    }
}
