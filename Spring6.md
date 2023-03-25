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
