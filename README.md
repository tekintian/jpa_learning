# JPA 学习

任何企业应用程序通过存储和检索大量数据进行数据库操作。尽管所有的存储管理提供技术，应用程序开发人员通常很难有效地执行数据库操作。

一般情况下，Java开发人员使用大量的代码，或使用专有的架构与数据库进行交互，而使用JPA与数据库绑定交互负担显著降低。它形成（数据库程序）对象模型之间的桥梁（Java程序）和关系模型。

关系型和对象模型之间的不匹配

关系对象表示以表格的形式，而对象模型表示的对象格式的相互连接的图形。而存储和检索来自关系数据库的对象模型，一些不匹配的发生是由于以下原因：

粒度：对象模型比关系模型更精细。

亚型：亚型（指继承）所有类型的关系数据库不支持。

标识：如对象模型，关系模型并没有同时编写暴露身份。

关联：关系模型无法确定多重关系，同时寻找到一个对象域模型。

数据导航：在一个对象网络对象之间的数据导航是在这两种模式中有所不同。

##JPA是什么?

Java持久性API(简称JAP)是类和方法的集合，以海量数据关系映射持久并存储到数据库，这是由Oracle公司提供方案技术。

##在哪里使用JPA？

为了减少编写代码，对象关系管理的负担，程序员遵循“JPA提供者”框架，它可以方便地与数据库实例的交互。这里所需要的框架接管JPA。

##JPA 历史

早期版本的EJB，定义持久层结合使用 javax.ejb.EntityBean 接口作为业务逻辑层。

同时引入EJB3.0的持久层分离，并指定为JPA1.0（Java持久性API）。这个API规范随着JAVA EE5对2006年5月11日使用JSR220规范发布。

JPA2.0的JAVA EE 6规范发布于2009年12月10日并成Java Community Process JSR317 的一部分。

JPA2.1使用JSR338 的 JAVA EE7的规范发布于2013年4月22日。

##JPA提供者

JPA是一个开源的API，因此各企业厂商如Oracle，Redhat，Eclipse等，通过增加 JPA 持续性，在提供JPA的新产品。这些产品包括：

Hibernate, Eclipselink, Toplink, Spring Data JPA, etc.


- 本项目中使用的JPA提供者为 Eclipselink JPA 

[EclipseLink JPA仓库地址](https://mvnrepository.com/artifact/org.eclipse.persistence/org.eclipse.persistence.jpa)


- Hibernate JPA在最新版已经包含在其核心包中
注意Hibernate不同版本使用方式不同，

[hibernate-core](https://mvnrepository.com/artifact/org.hibernate/hibernate-core)

Hibernage5的JPA提供接口
org.hibernate.jpa.HibernatePersistenceProvider

- Spring Data JPA
[Spring Data module for JPA repositories.](https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa)

## 类级别架构
下表描述了每个在上述架构的显示单元。

单元	| 描述
--- |  ---
EntityManagerFactory	| 	这是一个EntityManager的工厂类。它创建并管理多个EntityManager实例。
EntityManager	| 	这是一个接口，它管理的持久化操作的对象。它的工作原理类似工厂的查询实例。
Entity		| 实体是持久性对象是存储在数据库中的记录。
EntityTransaction	  	| 它与EntityManager是一对一的关系。对于每一个EntityManager，操作是由EntityTransaction类维护。
Persistence		| 这个类包含静态方法来获取EntityManagerFactory实例。
Query		| 该接口由每个JPA供应商，能够获得符合标准的关系对象。



上述的类和接口用于存储实体到数据库的一个记录。帮助程序员通过减少自己编写代码将数据存储到数据库中，使他们能够专注于更重要的业务活动代码，如 数据库表映射的类编写代码。
---

##JPA类关系
- EntityManagerFactory和EntityManager的关系是1对多。这是一个工厂类EntityManager实例。

- EntityManager和EntityTransaction之间的关系是1对1。对于每个EntityManager操作，只有一个EntityTransaction实例。

- EntityManager和Query之间的关系是1对多。查询数众多可以使用一个EntityManager实例执行。

- EntityManager实体之间的关系是1对多。一个EntityManager实例可以管理多个实体。


##注解
一般的XML文件用于配置特定的组件，或者映射两种不同规格的组件。在我们的例子中，我们要分别保持在一个框架的XML文件。这意味着在写一个映射的XML文件，我们需要比较用mapping.xml文件实体标签的POJO类的属性。

这里是解决方案。在类定义中，我们可以使用注释写配置的一部分。注解用于类，属性和方法。注释以'@'符号在类，属性或方法的注释中声明之前。 JPA的所有批注在javax.persistence包定义。

在这里，在我们的实例中使用的注释列表如下。

注解	 | 描述
--- | ---
@Entity	 | 	声明类为实体或表。
@Table		 | 声明表名。
@Basic	 | 	指定非约束明确的各个字段。
@Embedded		 | 指定类或它的值是一个可嵌入的类的实例的实体的属性。
@Id		 | 指定的类的属性，用于识别（一个表中的主键）。
@GeneratedValue	 | 	指定如何标识属性可以被初始化，例如自动，手动，或从序列表中获得的值。
@Transient	 | 	指定的属性，它是不持久的，即，该值永远不会存储在数据库中。
@Column	 | 	指定持久属性栏属性。
@SequenceGenerator	 | 	指定在@GeneratedValue注解中指定的属性的值。它创建了一个序列。
@TableGenerator		 | 指定在@GeneratedValue批注指定属性的值发生器。它创造了的值生成的表。
@AccessType | 	这种类型的注释用于设置访问类型。如果设置@AccessType（FIELD），然后进入FIELD明智的。如果设置@AccessType（PROPERTY），然后进入属性发生明智的。
@JoinColumn	 | 指定一个实体组织或实体的集合。这是用在多对一和一对多关联。
@UniqueConstraint | 	指定的字段和用于主要或辅助表的唯一约束。
@ColumnResult | 	参考使用select子句的SQL查询中的列名。
@ManyToMany	 | 定义了连接表之间的多对多一对多的关系。
@ManyToOne	 | 定义了连接表之间的多对一的关系。
@OneToMany	 | 定义了连接表之间存在一个一对多的关系。
@OneToOne	 | 定义了连接表之间有一个一对一的关系。
@NamedQueries | 	指定命名查询的列表。
@NamedQuery | 	指定使用静态名称的查询。


##Java Bean标准

Java类封装了实例的值及其行为为对象称为一个单元。 Java Bean是一个临时的存储和可重用的组件或对象。它是有一个默认的构造函数和getter和setter方法来初始化实例序列化的类单独的属性。

Bean约定

bean包含其默认构造函数或包含序列化实例的文件。因此，一个bean可以实例化另一个bean。

bean属性可以被隔离成布尔属性或者非布尔属性。

非布尔属性包含getter和setter方法。

布尔属性包含setter和方法。

任何字段的getter方法应从小字母get（Java方法的公约）开始，之后使用大写字母开头的字段名。例如，字段名为salary，因此这一字段的getter方法为getSalary()。

任何属性的setter方法应该先从小字母的集合（Java方法公约）开始，继续以大写字母，参数值设置为字段开头的字段名。例如，字段名为salary，因此这一字段的setter方法是setSalary（double sal ）。

对于布尔型属性，方法是检查它是否是 true 或 false。例如，Boolean属性为空，则该字段的就是方法isEmpty()。

##安装使用EclipseLink JPA
在pom.xml中增加

```xml
<!-- https://mvnrepository.com/artifact/org.eclipse.persistence/org.eclipse.persistence.jpa -->
        <dependency>
            <groupId>org.eclipse.persistence</groupId>
            <artifactId>org.eclipse.persistence.jpa</artifactId>
            <version>2.7.1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.46</version>
        </dependency>
```

## Java持久化查询语言 JPQL
JPQL代表Java持久化查询语言。它被用来创建针对实体的查询存储在关系数据库中。 JPQL是基于SQL语法的发展。但它不会直接影响到数据库。

JPQL可以检索使用SELECT子句中的数据，可以使用 UPDATE子句做批量UPDATE和DELETE子句。

###查询结构

JPQL语法非常类似于SQL语法。SQL的语法是一个优势，因为SQL很简单，被广泛使用。 SQL工作直接针对关系数据库表，记录和字段，而JPQL适用于Java类和实例。

例如，JPQL查询可以检索实体对象，而不是从一个数据库中设置字段结果，作为与SQL。该JPQL查询结构如下。

SELECT ... FROM ...
[WHERE ...]
[GROUP BY ... [HAVING ...]]
[ORDER BY ...]
JPQL的结构，DELETE和UPDATE查询，如下所示。

DELETE FROM ... [WHERE ...]
 
UPDATE ... SET ... [WHERE ...]



### 标量和聚合函数

标量函数返回基于输入值所得的数值。集合函数，通过计算输入值返回的结果值。

我们将使用相同的例子员工管理，在前面的章节。在这里将通过使用JPQL的标量和聚合函数的服务类。


- Between, And, Like 关键词

Between, And, 和Like是JPQL的主要关键字。这些关键字在查询子句后使用。


#### JPQL的like查询 的 % 需要放到设置查询关键词的地方
- 示例
```java
//接受参数 使用  :keywords
@NamedQuery(query = "Select e from Employee e where e.eid = :id or e.ename like  :keywords",
        name = "find_employee_by_id_or_keywords")

//设置查询关键词  % 放到关键词里面
// query.setParameter("keywords", "%测试%");
......
        EntityManagerFactory emfactory = Persistence.
                createEntityManagerFactory( "JPA" );
        EntityManager entitymanager = emfactory.
                createEntityManager();
        Query query = entitymanager.createNamedQuery(
                "find_employee_by_id_or_keywords");
        query.setParameter("id",1);
        query.setParameter("keywords", "%测试%");
        List<Employee> list = query.getResultList( );
 .....

```

- 排序

要排序JPQL中的记录，我们使用ORDER BY子句。这一个子句的使用类似于SQL中的用法，但它涉及的实体。下面的示例演示了如何使用ORDER BY子句。


### 命名查询

@NamedQuery注解被定义为一个预定义的查询字符串，它是不可改变的查询。相反，动态查询，命名查询可以通过POJO分离JPQL查询字符串提高代码的组织。它也传送的查询参数，而不是动态地嵌入文本到查询字符串，并因此产生更高效的查询。

[命名查询演示实例](tree/v0.1.2)


## 继承策略
继承是任何面向对象语言的核心理念，因此我们可以用实体之间的继承关系和策略。JPA支持三种类型的继承策略：SINGLE_TABLE，JOINED_TABLE和TABLE_PER_CLASS。

- SINGLE_TABLE 单一表策略

单表策略采取所有类的字段(包括超级亚类)，并将它们映射成称为SINGLE_TABLE策略一个表。这里的鉴别值起着区分在一个表中三个实体的值的关键作用。

- JOINED_TABLE 连接表策略
连接表的策略是共享引用的列包含唯一值的加入表并进行便捷事务。

- TABLE_PER_CLASS 每个类表策略
每个类表策略是创建一个中间表为每个子类实体。

## JPA实体关系

一般的关系数据库中的表之间的更有效。这里的实体类都被视为关系表(JPA的概念)，因此是实体类之间的关系如下：

- @ManyToOne 关系
    
    多对一实体之间存在的关系，其中一个实体（列或组列）的引用与另一个实体（列或组列）包含唯一值。在关系数据库中，这些关系是通过使用表之间的外键/主键应用。

- @OneToMany 关系

    在这种关系中，一个实体中的每一行被引用到其它实体的许多子记录。最重要的是，子记录不能有多个父。在表A和表B之间的1对多的关系，在表A中的每一行都可以在表B中被链接到一个或多个行

- @OneToOne 关系

    在一对一关系，一个项可以链接到只能另一个项。这意味着一个实体中的每一行被称为一个且仅一个行对另一个实体。
    
- @ManyToMany 关系

    多对多的关系，就是从一个实体中的一个或多个行与其他实体的多个行相关联。
    
[JPA实体关系演示实例0](tree/v0.2.0)

[JPA实体关系演示实例1](tree/v0.2.1)

[JPA实体关系演示实例2](tree/v0.2.2)

[JPA实体关系演示实例3](tree/v0.2.3)


## JPA标准API
标准是用来定义查询实体的预定义API。它是定义JPQL查询的另一种方式。这些查询是类型安全的，可移植的，并且容易被改变的语法进行修改。类似于JPQL，它遵循的抽象模式(容易编辑模式)和嵌入的对象。元数据API是夹杂着标准的API模型持久性实体的标准查询。


- EntityManager实例被用来创建一个CriteriaBuilder对象。
- CriteriaQuery 实例是用来创建一个查询对象。这个查询对象的属性将与该查询的细节进行修改。
- CriteriaQuery.form 方法被调用来设置查询根。
- CriteriaQuery.select  被调用来设置结果列表类型。
- TypedQuery<T> 实例是用来准备一个查询执行和指定的查询结果的类型。
在TypedQuery<T>对象getResultList方法来执行查询。该查询返回实体的集合，结果存储在一个列表中。

[JPA标准API演示实例](tree/v0.3.0)


