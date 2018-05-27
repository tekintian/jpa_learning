package cn.tekin.jpa.service;

import cn.tekin.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateEmployee {
    public static void main(String[] args) {
        //创建实体管理工厂
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
        //创建实体管理对象
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //实例化对象
        Employee employee = new Employee();

        //主键eid数据库设置为自动增加，所以这里不需要添加ID
        employee.setEname("我是测试2");
        employee.setSalary(888);
        employee.setDeg("wo shi 测试试题描述");

        em.persist(employee);
        em.getTransaction().commit();

        System.out.println("插入的数据为："+employee.toString());

        //先创建的后关闭，后创建的先关闭
        em.close();
        emf.close();
    }
}
