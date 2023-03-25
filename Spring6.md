# Spring6

![](C:\Users\shiga\AppData\Roaming\marktext\images\2023-03-24-20-07-35-image.png)

对象创建之后放在哪里？

org.springframework.beans.factory.support.DefaultListableBeanFactory#beanDefinitionMap

日志级别：

级别高的会自动屏蔽级别低的日志

IOC: 是Inversion of Control的简写，译为“控制反转”

Spring通过IOC容器来管理所有java对象的实例化和初始化，控制对象与对象之间的依赖关系。

我们将由IOC容器管理的Java对象称为SpringBean它与使用关键字new创建的Java对象没有任何区别

## IoC容器

- 控制反转是一种思想

- 控制反转是为了降低程度的耦合度，提高程序扩展力

- 控制反转，反转的是什么？
  
  - 将对象的创建权利交出去，交给第三方容器负责
  
  - 将对象和对象之间关系的维护权交出去，交给第三方容器负责

- 控制反转这种思想如何实现？
  
  - DI（Dependency Injection）：依赖注入

### 依赖注入

依赖注入实现了控制反转的思想

- 指Spring创建对象的过程中，将对象依赖属性通过配置进行注入

依赖注入常见的实现方式包括两种：

- set注入

- 构造注入

所以结论是：IOC是一种控制反转的思想，而DI是对IOC的一种具体实现

Bean管理：Bean对象的创建，以及Bean对象中属性的赋值（或者叫做Bean对象之间关系的维护）

### IOC容器在Spring的实现

## 基于XML管理Bean

获取bean的方式：id/类型/id和类型

如果组件类实现了接口，根据接口类型可以获取bean吗？

> 可以，前提是bean唯一

如果一个接口有多个实现类，这些实现类都配置了bean，根据接口类型可以获取bean吗？

> 不行，因为bean不行

结论：

根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：对象instance of指定的类型，的返回结果，只要返回的是true就可以认定为何类型匹配，能够获取到。

Java中，instanceof运算符用于判断前面的对象是否是后面的类、实现类的实例。如果返回true，否则返回false。也就是说：用instance of关键字做判断时，instance of操作符的左右操作必须有继承或实现关系。

## setter/constructor注入

```xml
<!-- 1. set注入 -->
<bean id="book" class="com.atguigu.di.Book">
	<property name="bname" value="vue"/>
	<property name="author" value="尚硅谷"/>
</bean>

<!-- 2. 构造器注入 -->
<bean id="bookCon" class="com.atguigu.di.Book">
	<constructor-arg name="bname" value="java开发"/>
	<constructor-arg name="author" value="尚硅谷"/>
</bean>
```

## 注入特殊值处理

- 字面量

- null

- xml实体

- CDATA

```xml
<property name="author" value="尚硅谷"/>
<!--<property name="others">
    <null/>
</property>-->
<!--<property name="others" value="&lt;&gt;"/>-->
<property name="others">
    <value><![CDATA[a < b]]></value>
</property>
```

## 特殊类型属性注入（对象）

- 方式一：引用外部bean

- 方式二：内部bean

- 方式三：级联属性赋值

```xml
<!--第一种方式：引入外部bean-->
<bean id="dept" class="com.atguigu.ditest.Dept">
	<property name="dname" value="安保部"/>
</bean>
<bean id="emp" class="com.atguigu.ditest.Emp">
	<!-- 普通属性注入 -->
	<property name="ename" value="lucy"/>
	<property name="age" value="50"/>
	<!-- 注入对象类属性
	 private Dept dept; -->
	<property name="dept" ref="dept"/>
</bean>

<!--第二种方式：引入外部bean-->
<bean id="emp2" class="com.atguigu.ditest.Emp">
	<property name="ename" value="mary"/>
	<property name="age" value="20"/>
	<property name="dept">
		<bean id="dept2" class="com.atguigu.ditest.Dept">
			<property name="dname" value="财务部"/>
		</bean>
	</property>
</bean>

<!--第三种方式：级联赋值-->
<bean id="dept3" class="com.atguigu.ditest.Dept">
	<property name="dname" value="技术研发部"/>
</bean>
<bean id="emp3" class="com.atguigu.ditest.Emp">
	<property name="ename" value="tom"/>
	<property name="age" value="30"/>
	<property name="dept" ref="dept3"/>
	<property name="dept.dname" value="测试部"/>
</bean>
```

## 依赖注入-数组类型属性
