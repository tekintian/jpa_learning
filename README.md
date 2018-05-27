#JPA标准API
标准是用来定义查询实体的预定义API。它是定义JPQL查询的另一种方式。这些查询是类型安全的，可移植的，并且容易被改变的语法进行修改。类似于JPQL，它遵循的抽象模式(容易编辑模式)和嵌入的对象。元数据API是夹杂着标准的API模型持久性实体的标准查询。

标准的API的主要优点是，错误可以较早在编译时被检测到。基于字符串JPQL查询和基于查询JPA的范围是在性能和效率相同。

##标准API历史

该标准被纳入因此标准的每一步中JPA的规范通知所有版本JPA。

在JPA2.0中，标准查询API，查询的标准化开发。
在JPA2.1，标准更新和删除（批量更新和删除）都包括在内。

##标准查询结构

该标准与JPQL是密切相关的，并允许使用类似的操作符在他们的查询设计。它遵循javax.persistence.criteria包设计一个查询。查询结构指的语法条件查询。

下面简单的条件查询返回数据源中的实体类的所有实例。

EntityManager em = ...;
CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Entity class> cq = cb.createQuery(Entity.class);
Root<Entity> from = cq.from(Entity.class);
cq.select(Entity);
TypedQuery<Entity> q = em.createQuery(cq);
List<Entity> allitems = q.getResultList();

查询演示了基本的步骤来创建一个标准。

EntityManager实例被用来创建一个CriteriaBuilder对象。

CriteriaQuery实例是用来创建一个查询对象。这个查询对象的属性将与该查询的细节进行修改。

CriteriaQuery.form方法被调用来设置查询根。

CriteriaQuery.select被调用来设置结果列表类型。

TypedQuery<T>实例是用来准备一个查询执行和指定的查询结果的类型。

在TypedQuery<T>对象getResultList方法来执行查询。该查询返回实体的集合，结果存储在一个列表中。